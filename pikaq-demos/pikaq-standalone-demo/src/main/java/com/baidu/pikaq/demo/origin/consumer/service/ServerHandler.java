package com.baidu.pikaq.demo.origin.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

/**
 *
 */
public class ServerHandler {

    protected static final Logger LOG = LoggerFactory.getLogger(ServerHandler.class);

    public void handleMessage(Message tradeRequest) {

        LOG.info("receive: " + tradeRequest.toString());
    }
}