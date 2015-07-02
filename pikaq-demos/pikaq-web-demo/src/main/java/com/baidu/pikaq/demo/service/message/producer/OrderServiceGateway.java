package com.baidu.pikaq.demo.service.message.producer;

/**
 * Gateway interface that sends trades to an external process.
 */
public interface OrderServiceGateway {

    void send(TradeRequest tradeRequest);

}
