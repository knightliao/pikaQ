/*
 * Copyright (C) 2015 knightliao, Inc. All Rights Reserved.
 */
package com.baidu.pikaq.client.test.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by knightliao on 15/7/2.
 */
public class PikaQGatewayWithExceptionMockImpl extends PikaQGatewayMockImpl {

    protected final Logger LOGGER = LoggerFactory.getLogger(PikaQGatewayWithExceptionMockImpl.class);

    /**
     * 正常的情况
     *
     * @param routeKey
     * @param correlation
     * @param data
     */
    @Override
    protected void sendRabbitQ(final String routeKey, final String correlation, final Object data) {
        throw new RuntimeException("oh ... no ... pikaQ throw exception");
    }

}
