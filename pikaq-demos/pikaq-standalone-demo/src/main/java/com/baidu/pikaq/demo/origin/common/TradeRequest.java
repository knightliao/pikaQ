package com.baidu.pikaq.demo.origin.common;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 交易的数据
 */
public class TradeRequest {

    public TradeRequest(BigDecimal price, String orderId) {
        this.price = price;
        this.orderId = orderId;
    }

    /*
                价格
             */
    private BigDecimal price;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 唯一ID
     */
    private String id = UUID.randomUUID().toString();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TradeRequest{" +
                   "price=" + price +
                   ", orderId='" + orderId + '\'' +
                   ", id='" + id + '\'' +
                   '}';
    }
}
