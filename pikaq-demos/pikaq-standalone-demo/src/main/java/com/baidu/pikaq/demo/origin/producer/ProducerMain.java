package com.baidu.pikaq.demo.origin.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ProducerMain {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ConfigurableApplicationContext context;

    public void run() {

        context = new ClassPathXmlApplicationContext("producer-pikaq-Configuration.xml");

        ProducerSender producerSender = (ProducerSender) context.getBean("producerSender", ProducerSender.class);

        LOGGER.info("Start.");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; ++i) {
            producerSender.send(i);
        }
        LOGGER.info(String.valueOf(System.currentTimeMillis() - start));
        LOGGER.info("End.");

        context.close();

    }

    public static void main(String[] args) {
        new ProducerMain().run();
    }
}
