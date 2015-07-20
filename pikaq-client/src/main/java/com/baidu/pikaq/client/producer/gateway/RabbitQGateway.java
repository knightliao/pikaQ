package com.baidu.pikaq.client.producer.gateway;

/**
 * Created by knightliao on 15/7/20.
 */
public interface RabbitQGateway {

    /**
     * 使用原生rabbit方式：非常容易导致丢数据
     *
     * @param exchange
     * @param routeKey
     * @param data
     */
    void send(String exchange, String routeKey, Object data);
}
