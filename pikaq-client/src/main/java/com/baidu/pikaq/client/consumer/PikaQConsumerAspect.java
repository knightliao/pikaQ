package com.baidu.pikaq.client.consumer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.baidu.pikaq.core.db.store.StoreConsumerResolver;
import com.baidu.pikaq.core.db.store.StoreFactory;

/**
 * Created by knightliao on 15/7/2.
 */
@Aspect
@Component
public class PikaQConsumerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PikaQConsumerAspect.class);

    public static final MessageConverter messageConverter = new JsonMessageConverter();

    // pikaq data 存储方案
    private StoreConsumerResolver storeResolver = StoreFactory.getDebStoreConsumerImpl();

    @Around("@annotation(pikaQConsumer) && args(message)")
    public Object aroundAdvice(final ProceedingJoinPoint pjp, PikaQConsumer pikaQConsumer, Message message)
        throws Throwable {

        boolean isProcessing = false;

        Object object = null;

        //
        // convert
        //
        try {

            object = PikaQConsumerAspect.messageConverter.fromMessage(message);

            // 是否在处理中
            isProcessing = storeResolver.isProcessing(object);

        } catch (MessageConversionException e) {

            LOGGER.error(e.toString(), e);
        }

        //
        // execute
        //
        if (object != null) {
            if (!isProcessing) {

                // setting to processing
                storeResolver.update2Processing(object);

                // 执行
                Object rtnOb;
                try {

                    // 执行方法
                    rtnOb = pjp.proceed();

                    // setting to success
                    storeResolver.update2Success(object, "");

                } catch (Throwable t) {
                    LOGGER.error(t.getMessage());

                    // setting to failed
                    storeResolver.update2Success(object, t.getMessage()
                                                             .substring(0, Math.min(255, t.getMessage().length() - 1)));

                    throw t;
                }

                return rtnOb;
            } else {

                LOGGER.info("is processing, ignore: " + object.toString());
            }
        }

        return null;
    }

}
