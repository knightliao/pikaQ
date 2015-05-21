package com.baidu.pikaq.demo.origin.producer;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.pikaq.demo.origin.common.OrderServiceGateway;
import com.baidu.pikaq.demo.origin.common.TradeRequest;

/**
 * Created by knightliao on 15/5/11.
 */
public class ProducerSender {

    @Autowired
    private OrderServiceGateway orderServiceGateway;

    /**
     * 发送数据
     *
     * @param orderId
     */
    public void send(Integer orderId) {

        TradeRequest tr = new TradeRequest(BigDecimal.valueOf(RandomUtils.nextInt(10000)), String.valueOf(orderId));

        orderServiceGateway.send(tr);
    }
}
