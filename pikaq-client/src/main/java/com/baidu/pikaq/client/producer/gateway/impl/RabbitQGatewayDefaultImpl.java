package com.baidu.pikaq.client.producer.gateway.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;

import com.baidu.pikaq.client.producer.gateway.RabbitQGateway;

/**
 * Created by knightliao on 15/7/2.
 */
public class RabbitQGatewayDefaultImpl extends RabbitGatewaySupport implements RabbitQGateway {

    protected final Logger LOGGER = LoggerFactory.getLogger(RabbitQGatewayDefaultImpl.class);

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    @Override
    public void send(String exchange, String routeKey, Object data) {

        //
        final String correlation;
        correlation = UUID.randomUUID().toString();

        // exchange
        getRabbitTemplate().setExchange(exchange);
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

}
