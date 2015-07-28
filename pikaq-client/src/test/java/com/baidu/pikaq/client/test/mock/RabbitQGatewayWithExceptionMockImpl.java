/*
 * Copyright (C) 2015 knightliao, Inc. All Rights Reserved.
 */
package com.baidu.pikaq.client.test.mock;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/7/2.
 */
public class RabbitQGatewayWithExceptionMockImpl extends RabbitQGatewayMockImpl {

    protected final Logger LOGGER = LoggerFactory.getLogger(RabbitQGatewayWithExceptionMockImpl.class);

    // 为了方便测试，将 失败的 correlation 记录下来
    protected static BlockingQueue<String> correlationQueue = new LinkedBlockingQueue();

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    @Override
    public void send(String exchange, String routeKey, Object data) {

        //
        final String correlation;
        correlation = UUID.randomUUID().toString();
        correlationQueue.add(correlation);

        throw new RuntimeException("oh ... no ... RabbitQ throw exception");
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
