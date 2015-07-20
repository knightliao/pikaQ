package com.baidu.pikaq.client.producer.gateway;

/**
 * Created by knightliao on 15/7/2.
 */
public interface PikaQGateway {

    /**
     * 使用强一致性：任何情况下，均不会丢数据
     *
     * @param exchange
     * @param routeKey
     * @param data
     */
    void send(String exchange, String routeKey, Object data);

    /**
     * 使用弱一致性：在极端情况下 会导致丢数据
     *
     * @param exchange
     * @param routeKey
     * @param data
     */
    void sendSimple(String exchange, String routeKey, Object data);

    /**
     * 使用原生rabbit方式：非常容易导致丢数据
     *
     * @param exchange
     * @param routeKey
     * @param data
     */
    void sendWithOriginalRabbitType(String exchange, String routeKey, Object data);
}
