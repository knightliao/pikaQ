package com.baidu.pikaq.demo.service.campaign.service;

import java.util.List;

import com.baidu.pikaq.demo.service.campaign.bo.Campaign;

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

}
