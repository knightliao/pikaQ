package com.baidu.pikaq.demo.origin.common;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 交易的数据
 */
public class TradeRequest {

    public TradeRequest() {

    }

    public static TradeRequest make_data(BigDecimal price, String campaignId) {
        return new TradeRequest(price, campaignId, UUID.randomUUID().toString());
    }

    /**
     * 工厂模式
     *
     * @param price
     * @param campaignId
     *
     * @return
     */
    public TradeRequest(BigDecimal price, String campaignId, String id) {
        this.price = price;
        this.campaignId = campaignId;
        this.id = id;
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
    private String id;

    @Override
    public String toString() {
        return "TradeRequest{" +
                   "price=" + price +
                   ", campaignId='" + campaignId + '\'' +
                   ", id='" + id + '\'' +
                   '}';
    }

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
}
