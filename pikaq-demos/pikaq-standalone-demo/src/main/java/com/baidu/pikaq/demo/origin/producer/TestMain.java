package com.baidu.pikaq.demo.origin.producer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/5/27.
 */
public class TestMain {

    protected static final Logger LOGGER = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {

        String dd = "kkk";

        System.out.println(Arrays.asList(dd));

        for (int i = 0; i < 1000000; ++i) {
            LOGGER.info(String.valueOf(i));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
