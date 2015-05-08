package com.baidu.pikaq.origin.producer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by knightliao on 15/3/4.
 */
public class ProducerMain {

    private ConfigurableApplicationContext context;

    public void run() {
        context = new ClassPathXmlApplicationContext("producer-rabbitConfiguration.xml");

    }

    public static void main(String[] args) {
        new ProducerMain().run();
    }
}
