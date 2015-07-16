package com.baidu.pikaq.client.producer.gateway.impl;

import java.io.IOException;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.client.producer.gateway.PikaQGateway;
import com.baidu.pikaq.core.db.commit.CommitExecutorFactory;
import com.baidu.pikaq.core.db.commit.executor.CommitExecutor;
import com.baidu.pikaq.core.db.store.StoreFactory;
import com.baidu.pikaq.core.db.store.StoreProducerResolver;

/**
 * Created by knightliao on 15/7/2.
 */
public class PikaQGatewayDefaultImpl extends RabbitGatewaySupport implements PikaQGateway {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    // 提交前设置
    private CommitExecutor beforeCommitExecutor = CommitExecutorFactory.getBeforeCommitDefaultImpl();

    // 提交后设置
    private CommitExecutor afterCommitExecutor = CommitExecutorFactory.getAfterCommitDefaultImpl();

    // pikaq data 存储方案
    private StoreProducerResolver storeResolver = StoreFactory.getDebStoreProducerImpl();

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    @Transactional
    @Override
    public void send(String exchange, String routeKey, Object data) {

        // exchange
        getRabbitTemplate().setExchange(exchange);

        //
        final String correlation;
        correlation = UUID.randomUUID().toString();

        //
        // convert and store
        ObjectMapper mapper = new ObjectMapper();
        String dataConvert;
        try {

            // convert
            dataConvert = mapper.writeValueAsString(data);

            // store
            makeStore(dataConvert, correlation, true);
        } catch (IOException e) {
            throw new AmqpException(e);
        }

        //
        // send
        //
        sendQ(exchange, routeKey, correlation, data);
    }

    /**
     * 发送消息
     *
     * @param exchange
     * @param routeKey
     * @param correlation
     * @param data
     */
    private void sendQ(final String exchange, final String routeKey, final String correlation, final Object data) {

        afterCommitExecutor.execute(new Runnable() {
            @Override
            public void run() {

                getRabbitTemplate().convertAndSend(routeKey, data, new MessagePostProcessor() {

                    public Message postProcessMessage(Message message) throws AmqpException {

                        try {

                            message.getMessageProperties().setCorrelationId(correlation.getBytes("UTF-8"));

                        } catch (Exception e) {
                            throw new AmqpException(e);
                        }

                        return message;
                    }
                });

            }
        });

    }

    /**
     * @param data
     * @param correlation
     * @param update2Store
     *
     * @throws IOException
     */
    private void makeStore(final String data, final String correlation, boolean update2Store) throws IOException {

        // save data before commit
        // only when enable
        if (update2Store) {
            beforeCommitExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    storeResolver.resolve(correlation, data);
                }
            });
        }
    }

}
