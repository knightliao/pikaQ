package com.baidu.pikaq.origin.producer;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.origin.common.OrderServiceGateway;
import com.baidu.pikaq.origin.common.TradeRequest;

/**
 * Created by knightliao on 15/5/11.
 */
@Service
public class ProducerSender {

    @Autowired
    private OrderServiceGateway orderServiceGateway;

    /**
     * 发送数据
     *
     * @param orderId
     */
    public void send(Integer orderId) {

        TradeRequest tr = new TradeRequest();

        tr.setOrderId(String.valueOf(orderId));
        tr.setPrice(BigDecimal.valueOf(RandomUtils.nextInt(10000)));

        orderServiceGateway.send(tr);
    }
}
