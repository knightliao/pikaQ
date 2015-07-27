package com.baidu.pikaq.client.test.tests.simpletest.error;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;

import com.baidu.pikaq.client.test.common.BaseTestCaseNoRollback;
import com.baidu.pikaq.client.test.mock.RabbitQGatewayMockImpl;
import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;

import junit.framework.Assert;

/**
 * Created by knightliao on 15/7/27.
 * <p/>
 * 使用 Rabbit，校验在 事务异常时，消息是否会回滚
 */
public class RabbitQCreateErrorTestCase extends BaseTestCaseNoRollback {

    protected static final Logger LOGGER = LoggerFactory.getLogger(RabbitQCreateErrorTestCase.class);

    @Autowired
    private CampaignMgr campaignMgr;

    private static long RANDOM_DATA = RandomUtils.nextInt(10000000);

    private static String campaignName = "campaign" + String.valueOf(RANDOM_DATA);

    /**
     * Rabbit 错误处理业务：订单生成，发送消息，
     * <p/>
     * 测试：数据库无此条数据，但消息有
     *
     * @throws Exception
     */
    @Test(expected = RuntimeException.class)
    @NotTransactional
    public void test() {

        campaignMgr.createWithConsumerError(campaignName, BigDecimal.valueOf(RANDOM_DATA));

    }

    /**
     * 由于 前面的主逻辑已经 throw 异常了，因此，这里都检测不到任何数据了
     */
    @After
    public void check() {

        checkDbData(campaignName);
        checkQData(campaignName);
    }

    /**
     * check Q有数据
     *
     * @param campaignName
     */
    public void checkQData(String campaignName) {

        Object data = RabbitQGatewayMockImpl.consumeOne();

        LOGGER.info("checking Q data.......");
        if (data != null) {
            Assert.assertTrue(true);

        } else {
            Assert.assertTrue(false);
        }

    }

    /**
     * check 消息数据库是否数据
     */
    public void checkDbData(String campaignName) {

        LOGGER.info("checking Db data.......");
        //
        // check 数据库有数据
        //
        Campaign campaign = campaignMgr.getByName(campaignName);
        Assert.assertNull(campaign);
    }
}
