package com.baidu.pikaq.client.producer.gateway;

/**
 * Created by knightliao on 15/7/2.
 */
public interface PikaQGateway {

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    void send(String exchange, String routeKey, Object data);
}
