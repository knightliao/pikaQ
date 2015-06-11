package com.baidu.pikaq.demo.origin.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ConsumerMain {

    protected final static Logger LOGGER = LoggerFactory.getLogger(ConsumerMain.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("consumer-pikaq-Configuration.xml");

        LOGGER.info("Start.");
        long start = System.currentTimeMillis();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
