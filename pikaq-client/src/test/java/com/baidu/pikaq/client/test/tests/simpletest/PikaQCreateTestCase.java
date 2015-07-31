package com.baidu.pikaq.client.test.tests.simpletest;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.baidu.pikaq.client.test.common.BaseTestCaseNoRollback;
import com.baidu.pikaq.client.test.mock.MockObject;
import com.baidu.pikaq.client.test.mock.PikaQGatewayMockImpl;
import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;
import com.baidu.pikaq.client.test.service.pikadata.bo.PikaData;
import com.baidu.pikaq.client.test.service.pikadata.dao.PikaDataDao;
import com.baidu.pikaq.core.db.store.StoreDataStatusEnum;

import junit.framework.Assert;

/**
 * Created by knightliao on 15/7/22.
 * <p/>
 * 使用 PikaQ，校验在 发送时，本地事务和消息是否都已经提交
 */
public class PikaQCreateTestCase extends BaseTestCaseNoRollback {

    protected static final Logger LOGGER = LoggerFactory.getLogger(PikaQCreateTestCase.class);

    @Autowired
    private CampaignMgr campaignMgr;

    @Autowired
    private PikaDataDao pikaDataDao;

    private static long RANDOM_DATA = RandomUtils.nextInt(10000000);

    /**
     * 正常处理业务：订单生成，发送消息，（强一致性）
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
        String campaignName = "campaign" + String.valueOf(RANDOM_DATA);

        campaignMgr.create(campaignName, BigDecimal.valueOf(RANDOM_DATA));

        checkDbData(campaignName);
        checkQData(campaignName);
    }

    /**
     * check Q有数据
     *
     * @param campaignName
     */
    private void checkQData(String campaignName) {

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
     * @param correlation
     */
    private void checkPikaData(String correlation) {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        Assert.assertNotNull(pikaData);
        Assert.assertEquals(pikaData.getStatus().intValue(), StoreDataStatusEnum.PRODUCE_INIT.getValue());
        LOGGER.info(pikaData.toString());
    }

    /**
     * check 消息数据库是否数据
     */
    private void checkDbData(String campaignName) {

        LOGGER.info("checking Db data.......");
        //
        // check 数据库有数据
        //
        Campaign campaign = campaignMgr.getByName(campaignName);
        LOGGER.info(campaign.toString());
        Assert.assertNotNull(campaign);
    }

}
