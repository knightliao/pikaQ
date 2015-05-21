package com.baidu.pikaq.demo.origin.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.demo.origin.common.TradeRequest;

/**
 *
 */
public class ServerHandler {

    protected static final Logger LOG = LoggerFactory.getLogger(ServerHandler.class);

    public void handleMessage(TradeRequest tradeRequest) {

        LOG.info("receive: " + tradeRequest.toString());
    }
}