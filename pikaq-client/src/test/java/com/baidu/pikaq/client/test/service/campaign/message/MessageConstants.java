package com.baidu.pikaq.client.test.service.campaign.message;

/**
 * Created by knightliao on 15/7/3.
 * <p/>
 * 消息 配置
 */
public class MessageConstants {

    public static String DEFAULT_EXCHANGE = "pikaQWebDemoExchange";

    /**
     * normal
     */
    public static String DEFAULT_ROUTE_KEY = "logMessageInfo.info";
    public static String ROUTE_KEY2 = "logMessageInfo.info2";

    /**
     * consumer error
     */
    public static String ROUTE_KEY_CONSUMER_ERROR = "logMessageInfo.error";
    public static String ROUTE_KEY2_CONSUMER_ERROR = "logMessageInfo.error2";

}
