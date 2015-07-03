package com.baidu.pikaq.core.db.store.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.core.db.store.StoreResolver;
import com.baidu.pikaq.utils.SpringContextUtil;

/**
 * 本地存储 Resolver
 */
public class DbStoreResolver implements StoreResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbStoreResolver.class);

    @Override
    public void resolve(String correlation, String data) {

        DbStoreUserCallback dbStoreUserCallback =
            (DbStoreUserCallback) SpringContextUtil.getBean(DbStoreUserCallback.class);
        if (dbStoreUserCallback != null && data != null && correlation != null) {

            LOGGER.debug("save pikaq data to db.");
            dbStoreUserCallback.saveStatusData(correlation, data);

        } else {
            if (dbStoreUserCallback == null) {
                LOGGER.debug("dbStoreUserCallback is null");
            } else if (data == null) {
                LOGGER.debug("data is null");
            } else if (correlation == null) {
                LOGGER.debug("correlation is null");
            }
        }
    }
}
