package com.baidu.pikaq.client.gateway;

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

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    void send(String exchange, String routeKey, Object data, boolean update2Store);
}
