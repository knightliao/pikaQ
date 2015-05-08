package com.baidu.pikaq.origin.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Server application than can be run as an app or unit test.
 *
 * @author Mark Pollack
 */
public class ConsumerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer-pikajob-Configuration.xml");
    }
}
