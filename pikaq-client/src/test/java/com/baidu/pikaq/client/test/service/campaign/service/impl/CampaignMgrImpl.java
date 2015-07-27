package com.baidu.pikaq.client.test.service.campaign.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.client.producer.gateway.PikaQGateway;
import com.baidu.pikaq.client.producer.gateway.RabbitQGateway;
import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.pikaq.client.test.service.campaign.dao.CampaignDao;
import com.baidu.pikaq.client.test.service.campaign.message.CampaignPikaMessageConverter;
import com.baidu.pikaq.client.test.service.campaign.message.MessageConstants;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;

/**
 *
 */
@Service
public class CampaignMgrImpl implements CampaignMgr {

    @Autowired
    private PikaQGateway pikaQGateway;

    @Autowired
    private RabbitQGateway rabbitQGateway;

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
     * 强一致性的消息生成：生成订单
     *
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

    /**
     * 本地事务回滚：强一致性的消息生成
     *
     * @param name
     * @param price
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Campaign createWithLocalErrorPikaQStrong(String name, BigDecimal price) {

        // db
        Campaign campaign = campaignDao.create(name, price);

        // send message
        pikaQGateway.send(MessageConstants.DEFAULT_EXCHANGE, MessageConstants.ROUTE_KEY_CONSUMER_ERROR,
                             CampaignPikaMessageConverter.convert2PikaMessage(campaign));

        throw new RuntimeException("oh ... something wrong...");
    }

    /**
     * 本地事务回滚：弱一致性的消息生成
     *
     * @param name
     * @param price
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Campaign createWithLocalErrorPikaQNormal(String name, BigDecimal price) {

        // db
        Campaign campaign = campaignDao.create(name, price);

        // send message
        pikaQGateway.sendSimple(MessageConstants.DEFAULT_EXCHANGE, MessageConstants.ROUTE_KEY_CONSUMER_ERROR,
                                   CampaignPikaMessageConverter.convert2PikaMessage(campaign));

        throw new RuntimeException("oh ... something wrong...");
    }

    /**
     * 本地事务回滚：使用原生rabbitmq来做消息生成
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public Campaign createWithLocalError(String name, BigDecimal price) {

        // db
        Campaign campaign = campaignDao.create(name, price);

        // send message
        rabbitQGateway.send(MessageConstants.DEFAULT_EXCHANGE, MessageConstants.ROUTE_KEY_CONSUMER_ERROR,
                               CampaignPikaMessageConverter.convert2PikaMessage(campaign));

        throw new RuntimeException("oh ... something wrong...");
    }

    /**
     * 弱一致性消息生成：修改订单，将订单修改数据异步化到其它地方，用作缓存读取。
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void update(Long campaignId, BigDecimal price) {

        Campaign campaign = campaignDao.get(campaignId);
        if (campaign != null) {

            // db
            campaignDao.updatePriceById(campaignId, price);
            campaign.setPrice(price);

            // send message
            pikaQGateway.sendSimple(MessageConstants.DEFAULT_EXCHANGE, MessageConstants.ROUTE_KEY2,
                                       CampaignPikaMessageConverter.convert2PikaMessage(campaign));
        }
    }

}
