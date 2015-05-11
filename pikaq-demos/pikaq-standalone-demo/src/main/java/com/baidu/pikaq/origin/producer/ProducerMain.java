package com.baidu.pikaq.origin.producer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ProducerMain {

    private ConfigurableApplicationContext context;

    public void run() {
        context = new ClassPathXmlApplicationContext("producer-pikaq-Configuration.xml");

        ProducerSender producerSender = (ProducerSender) context.getBean("producerSender", ProducerSender.class);

        for (int i = 0; i < 100000; ++i) {
            producerSender.send(i);
        }

        context.close();

    }

    public static void main(String[] args) {
        new ProducerMain().run();
    }
}
