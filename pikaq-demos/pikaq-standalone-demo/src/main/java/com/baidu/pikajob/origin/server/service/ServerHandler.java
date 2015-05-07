package com.baidu.pikajob.origin.server.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.baidu.pikajob.origin.common.TradeRequest;
import com.baidu.pikajob.origin.common.TradeResponse;

/**
 * Created by knightliao on 15/3/3.
 */
public class ServerHandler {

    protected static final Logger LOG = LoggerFactory.getLogger(ServerHandler.class);

    public TradeResponse handleMessage(TradeRequest tradeRequest) {
        TradeResponse tradeResponse;
        List<?> errors = new ArrayList<Object>();
        tradeResponse = new TradeResponse();
        tradeResponse.setError(true);
        tradeResponse.setErrorMessage(StringUtils.arrayToCommaDelimitedString(errors.toArray()));

        LOG.info(tradeResponse.toString());

        return tradeResponse;
    }

}