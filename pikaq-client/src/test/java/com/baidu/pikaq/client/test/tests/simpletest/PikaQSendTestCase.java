package com.baidu.pikaq.client.test.tests.simpletest;

import java.math.BigDecimal;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.baidu.pikaq.client.producer.gateway.RabbitQGateway;
import com.baidu.pikaq.client.test.common.BaseTestCaseNoRollback;
import com.baidu.pikaq.client.test.mock.PikaQGatewayMockImpl;
import com.baidu.pikaq.client.test.service.campaign.service.CampaignMgr;

import junit.framework.Assert;

/**
 * Created by knightliao on 15/7/22.
 * <p/>
 * 测试 正常的事务提交、消息发送
 */
public class PikaQSendTestCase extends BaseTestCaseNoRollback {

    protected final Logger LOGGER = LoggerFactory.getLogger(PikaQSendTestCase.class);

    @Autowired
    @Qualifier(value = "rabbitQGatewayMockImpl")
    private RabbitQGateway rabbitQGateway;

    @Autowired
    private CampaignMgr campaignMgr;

    public static String EXCHANGE = "exchange";
    public static String ROUTE_KEY = "route-key";

    /**
     * 测试 正常的事务提交、消息发送
     */
    @Test
    public void test() {
    }

    @BeforeTransaction
    public void test_() {
        //
        long aa = RandomUtils.nextInt(10000000);

        campaignMgr.create("campaign" + String.valueOf(aa), BigDecimal.valueOf(aa));

        // check
        Object data = PikaQGatewayMockImpl.consumeOne();
        Assert.assertNotNull(data);
        LOGGER.info(data.toString());
    }
}
