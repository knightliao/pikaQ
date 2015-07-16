package com.baidu.pikaq.demo.service.campaign.message.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.client.consumer.ConsumerSimpleListenerBase;
import com.baidu.pikaq.demo.service.campaign.message.CampaignPikaMessage;

/**
 * 弱一致性的消息处理
 */
public class CampaignUpdateConsumerHandler extends ConsumerSimpleListenerBase<CampaignPikaMessage> {

    protected static final Logger LOG = LoggerFactory.getLogger(CampaignUpdateConsumerHandler.class);

    /**
     * @param campaignPikaMessage
     */
    public void handleMessage(CampaignPikaMessage campaignPikaMessage) {

        LOG.info("receive: " + campaignPikaMessage.toString());
    }
}