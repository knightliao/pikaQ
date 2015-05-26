package com.baidu.pikaq.demo.origin.common;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 交易的数据
 */
public class TradeRequest {

    public TradeRequest(BigDecimal price, String campaignId) {
        this.price = price;
        this.campaignId = campaignId;
    }

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 订单ID
     */
    private String campaignId;

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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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
                   ", campaignId='" + campaignId + '\'' +
                   ", id='" + id + '\'' +
                   '}';
    }
}
