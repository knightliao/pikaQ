package com.baidu.pikaq.origin.producer.gateway;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.origin.common.Constants;
import com.baidu.pikaq.origin.common.OrderServiceGateway;
import com.baidu.pikaq.origin.common.TradeRequest;

/**
 * 发送网关
 * <p/>
 * Created by knightliao on 15/5/11.
 */
public class ProducerGateway extends RabbitGatewaySupport implements OrderServiceGateway {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 发送消息
     *
     * @param tradeRequest
     */
    @Transactional
    @Override
    public void send(final TradeRequest tradeRequest) {

        getRabbitTemplate().setExchange(Constants.DEFAULT_EXCHANGE);

        getRabbitTemplate().convertAndSend(Constants.DEFAULT_ROUTE_KEY, tradeRequest, new MessagePostProcessor() {

            public Message postProcessMessage(Message message) throws AmqpException {

                try {

                    message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString().getBytes("UTF-8"));
                    LOGGER.info("send: " + tradeRequest.toString());

                } catch (Exception e) {
                    throw new AmqpException(e);
                }
                return message;
            }
        });
    }
}
