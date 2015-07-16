package com.baidu.pikaq.demo.service.campaign.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.client.producer.gateway.PikaQGateway;
import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
import com.baidu.pikaq.demo.service.campaign.dao.CampaignDao;
import com.baidu.pikaq.demo.service.campaign.message.CampaignPikaMessageConverter;
import com.baidu.pikaq.demo.service.campaign.message.MessageConstants;
import com.baidu.pikaq.demo.service.campaign.service.CampaignMgr;

/**
 *
 */
@Service
public class CampaignMgrImpl implements CampaignMgr {

    @Autowired
    private PikaQGateway pikaQGateway;

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

    /**
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Campaign create(String name, BigDecimal price) {

        // db
        Campaign campaign = campaignDao.create(name, price);

        // send message
        pikaQGateway.send(MessageConstants.DEFAULT_EXCHANGE, MessageConstants.DEFAULT_ROUTE_KEY,
                             CampaignPikaMessageConverter.convert2PikaMessage(campaign));

        return campaign;
    }
}
