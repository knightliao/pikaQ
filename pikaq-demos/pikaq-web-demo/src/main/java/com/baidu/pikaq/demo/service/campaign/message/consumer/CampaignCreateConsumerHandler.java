package com.baidu.pikaq.demo.service.campaign.message.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.client.consumer.ConsumerListenerBase;
import com.baidu.pikaq.demo.service.campaign.message.CampaignPikaMessage;

/**
 * 强一致性的消息处理
 */
public class CampaignCreateConsumerHandler extends ConsumerListenerBase<CampaignPikaMessage> {

    protected static final Logger LOG = LoggerFactory.getLogger(CampaignCreateConsumerHandler.class);

    /**
     * @param campaignPikaMessage
     */
    public void handleMessage(CampaignPikaMessage campaignPikaMessage) {

        LOG.info("receive: " + campaignPikaMessage.toString());
    }
}