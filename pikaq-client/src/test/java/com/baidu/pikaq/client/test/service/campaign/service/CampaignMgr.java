package com.baidu.pikaq.client.test.service.campaign.service;

import java.math.BigDecimal;
import java.util.List;

import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;

/**
 *
 */
public interface CampaignMgr {
    /**
     * 根据APP名获取APP
     *
     * @param name
     */
    Campaign getByName(String name);

    /**
     * @return
     */
    List<Campaign> findAll();

    /**
     * @return
     */
    Campaign create(String name, BigDecimal price);

    /**
     * @param name
     * @param price
     *
     * @return
     */
    Campaign createWithLocalErrorPikaQStrong(String name, BigDecimal price);

    /**
     * @param name
     * @param price
     *
     * @return
     */
    Campaign createWithLocalErrorPikaQNormal(String name, BigDecimal price);

    /**
     * @param name
     * @param price
     *
     * @return
     */
    Campaign createWithLocalError(String name, BigDecimal price);

    /**
     * @param campaignId
     * @param price
     *
     * @return
     */
    void update(Long campaignId, BigDecimal price);

}
