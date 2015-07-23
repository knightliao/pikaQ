package com.baidu.pikaq.client.test.tests.simpletest;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.NotTransactional;

import com.baidu.pikaq.client.test.common.BaseTestCaseNoRollback;
import com.baidu.pikaq.client.test.mock.PikaQGatewayMockImpl;
import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;

import junit.framework.Assert;

/**
 * Created by knightliao on 15/7/22.
 */
@Service
public class UpdateTestCase extends BaseTestCaseNoRollback {

    protected static final Logger LOGGER = LoggerFactory.getLogger(UpdateTestCase.class);

    @Autowired
    private CampaignMgr campaignMgr;

    private static long RANDOM_DATA = RandomUtils.nextInt(10000000);

    /**
     * 正常处理业务：订单生成，发送消息，（弱一致性校验）
     * <p/>
     * 测试：数据库存在此条数据，消息也存在
     *
     * @throws Exception
     */
    @Test
    @NotTransactional
    public void test() {

        //
        Campaign campaign = campaignMgr.getByName("demo");
        Assert.assertNotNull(campaign);
        LOGGER.info(campaign.toString());

        //
        long aa = RandomUtils.nextInt(43434);
        campaignMgr.update(campaign.getId(), BigDecimal.valueOf(aa));

        // check
        checkQData(campaign.getName());
        checkDbData(campaign.getName(), aa);
    }

    /**
     * check Q有数据
     *
     * @param campaignName
     */
    public void checkQData(String campaignName) {

        Object data = PikaQGatewayMockImpl.consumeOne();

        LOGGER.info("checking Q data.......");
        if (data != null) {
            Assert.assertTrue(true);
            LOGGER.info(data.toString());

        } else {
            Assert.assertTrue(false);
        }

    }

    /**
     * check 消息数据库是否数据
     */
    public void checkDbData(String campaignName, long aa) {

        LOGGER.info("checking Db data.......");
        //
        // check 数据库有数据
        //
        Campaign campaign = campaignMgr.getByName(campaignName);
        LOGGER.info(campaign.toString());
        Assert.assertEquals(campaign.getPrice(), BigDecimal.valueOf(aa));
    }

}
