/*
 * Copyright (C) 2015 knightliao, Inc. All Rights Reserved.
 */
package com.baidu.pikaq.client.test.mock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/7/2.
 */
public class PikaQGatewayWithExceptionMockImpl extends PikaQGatewayMockImpl {

    protected final Logger LOGGER = LoggerFactory.getLogger(PikaQGatewayWithExceptionMockImpl.class);

    // 为了方便测试，将 失败的 correlation 记录下来
    protected static BlockingQueue<String> correlationQueue = new LinkedBlockingQueue();

    /**
     * 正常的情况
     *
     * @param routeKey
     * @param correlation
     * @param data
     */
    @Override
    protected void sendRabbitQ(final String routeKey, final String correlation, final Object data) {

        correlationQueue.add(correlation);

        throw new RuntimeException("oh ... no ... pikaQ throw exception");
    }

    /**
     * 拿数据
     *
     * @return
     */
    public static String getPreviousCorrelation() {

        return correlationQueue.poll();
    }
}
