package com.baidu.pikaq.demo.origin.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ConsumerMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("consumer-pikaq-Configuration.xml");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
