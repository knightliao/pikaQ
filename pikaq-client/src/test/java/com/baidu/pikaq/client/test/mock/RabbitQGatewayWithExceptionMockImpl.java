/*
 * Copyright (C) 2015 knightliao, Inc. All Rights Reserved.
 */
package com.baidu.pikaq.client.test.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/7/2.
 */
public class RabbitQGatewayWithExceptionMockImpl extends RabbitQGatewayMockImpl {

    protected final Logger LOGGER = LoggerFactory.getLogger(RabbitQGatewayWithExceptionMockImpl.class);

    /**
     * @param exchange
     * @param routeKey
     * @param data
     */
    @Override
    public void send(String exchange, String routeKey, Object data) {

        throw new RuntimeException("oh ... no ... RabbitQ throw exception");
    }

}
