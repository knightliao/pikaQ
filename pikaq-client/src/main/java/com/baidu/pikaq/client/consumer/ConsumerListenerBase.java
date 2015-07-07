package com.baidu.pikaq.client.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConversionException;

/**
 * Created by knightliao on 15/7/6.
 */
public abstract class ConsumerListenerBase<KEY extends Object> implements MessageListener {

    protected static final Logger LOG = LoggerFactory.getLogger(ConsumerListenerBase.class);

    /**
     * 由下游进行处理
     *
     * @param data
     */
    protected abstract void handleMessage(KEY data);

    /**
     * 收到消息
     *
     * @param message
     */
    @Override
    @PikaQConsumer
    public void onMessage(Message message) {

        try {

            Object object = PikaQConsumerAspect.messageConverter.fromMessage(message);

            handleMessage((KEY) object);

        } catch (MessageConversionException e) {

            LOG.error(e.toString(), e);
        }
    }
}
