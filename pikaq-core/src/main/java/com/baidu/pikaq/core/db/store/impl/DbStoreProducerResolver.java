package com.baidu.pikaq.core.db.store.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.core.db.store.StoreProducerResolver;
import com.baidu.pikaq.core.db.store.callback.DbStoreProducerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.utils.SpringContextUtil;

/**
 * 本地存储 Resolver producer
 */
public class DbStoreProducerResolver implements StoreProducerResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbStoreProducerResolver.class);

    @Override
    public void resolve(String correlation, String data, String exchange, String routerKey) throws StoreException {

        DbStoreProducerUserCallback dbStoreUserCallback =
            (DbStoreProducerUserCallback) SpringContextUtil.getBean(DbStoreProducerUserCallback.class);
        if (dbStoreUserCallback != null && data != null && correlation != null) {

            LOGGER.debug("save pikaq data to db.");
            dbStoreUserCallback.saveStatusData(correlation, data, exchange, routerKey);

        } else {

            String errorMsg = "";
            if (dbStoreUserCallback == null) {
                errorMsg = "dbStoreUserCallback is null";
            } else if (data == null) {
                errorMsg = "data is null";
            } else {
                errorMsg = "correlation is null";
            }

            LOGGER.error("correlation is null");
            throw new StoreException(errorMsg);
        }
    }

    /**
     * 处理为失败
     *
     * @param correlation
     * @param infoMsg
     * @param costTime
     *
     * @throws StoreException
     */
    @Override
    public void resolve2Failed(String correlation, String infoMsg, Long costTime) throws StoreException {

        DbStoreProducerUserCallback dbStoreUserCallback =
            (DbStoreProducerUserCallback) SpringContextUtil.getBean(DbStoreProducerUserCallback.class);

        if (dbStoreUserCallback != null && correlation != null) {

            LOGGER.debug("pikaq data encounter error: " + infoMsg);
            dbStoreUserCallback.update2InitFailed(correlation, infoMsg, costTime);

        } else {

            String errorMsg = "";
            if (dbStoreUserCallback == null) {
                errorMsg = "dbStoreUserCallback is null";
            } else {
                errorMsg = "correlation is null";
            }

            LOGGER.error("correlation is null");
            throw new StoreException(errorMsg);
        }
    }
}
