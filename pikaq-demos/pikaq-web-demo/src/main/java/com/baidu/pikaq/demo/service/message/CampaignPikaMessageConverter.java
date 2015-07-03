package com.baidu.pikaq.demo.service.message;

import com.baidu.pikaq.demo.service.campaign.bo.Campaign;

/**
 * Created by knightliao on 15/7/3.
 * <p/>
 * 业务实例 与 消息的转换器
 */
public class CampaignPikaMessageConverter {

    public static CampaignPikaMessage convert2PikaMessage(Campaign campaign) {

        CampaignPikaMessage campaignPikaMessage = new CampaignPikaMessage();
        campaignPikaMessage.setName(campaign.getName());
        campaignPikaMessage.setPrice(campaign.getPrice());

        return campaignPikaMessage;
    }
}
