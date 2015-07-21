package com.baidu.pikaq.client.test.service.campaign.message;

import java.math.BigDecimal;

/**
 * Created by knightliao on 15/7/3.
 * <p/>
 * 上下游接口
 */
public class CampaignPikaMessage {

    private BigDecimal price;

    private String name;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CampaignPikaMessage{" +
                   "price=" + price +
                   ", name='" + name + '\'' +
                   '}';
    }
}
