package com.baidu.pikaq.demo.service.campaign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
import com.baidu.pikaq.demo.service.campaign.dao.CampaignDao;
import com.baidu.pikaq.demo.service.campaign.service.CampaignMgr;

/**
 *
 */
@Service
public class CampaignMgrImpl implements CampaignMgr {

    @Autowired
    private CampaignDao campaignDao;

    /**
     *
     */
    @Override
    public Campaign getByName(String name) {

        return campaignDao.getByName(name);
    }

    /**
     * @return
     */
    @Override
    public List<Campaign> findAll() {
        return campaignDao.findAll();
    }
}
