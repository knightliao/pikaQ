package com.baidu.pikaq.client.test.tests.simpletest;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.baidu.pikaq.client.test.common.BaseTestCase;
import com.baidu.pikaq.client.test.mock.MockObject;
import com.baidu.pikaq.client.test.mock.PikaQGatewayMockImpl;
import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;
import com.baidu.pikaq.client.test.service.pikadata.bo.PikaData;
import com.baidu.pikaq.client.test.service.pikadata.dao.PikaDataDao;

import junit.framework.Assert;

/**
 * Created by knightliao on 15/7/22.
 * <p/>
 * 使用 PikaQ，弱一致性，校验在 发送时，本地事务和消息是否都已经提交
 */
@Service
public class PIkaQUpdateTestCase extends BaseTestCase {

    protected static final Logger LOGGER = LoggerFactory.getLogger(PIkaQUpdateTestCase.class);

    @Autowired
    private CampaignMgr campaignMgr;

    @Autowired
    private PikaDataDao pikaDataDao;

    private static long RANDOM_DATA = RandomUtils.nextInt(10000000);

    /**
     * 正常处理业务：订单生成，发送消息，（弱一致性校验）
     * <p/>
     * 测试：数据库存在此条数据，消息也存在
     *
     * @throws Exception
     */
    @Test
    public void test() {

    }

    @BeforeTransaction
    public void test_() {
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

        MockObject data = PikaQGatewayMockImpl.consumeOne();

        LOGGER.info("checking Q data.......");
        if (data != null) {
            Assert.assertTrue(true);
            LOGGER.info(data.toString());

            // check correlation
            checkPikaData(data.getCorrelation());
        } else {
            Assert.assertTrue(false);
        }
    }

    /**
     * 弱一致性，没有 Pikadata
     *
     * @param correlation
     */
    private void checkPikaData(String correlation) {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        Assert.assertNull(pikaData);
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
