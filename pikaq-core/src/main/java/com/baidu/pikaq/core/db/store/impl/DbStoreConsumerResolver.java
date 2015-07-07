package com.baidu.pikaq.core.db.store.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.core.db.store.StoreConsumerResolver;
import com.baidu.pikaq.core.db.store.callback.DbStoreConsumerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.utils.SpringContextUtil;

/**
 * 本地存储 Resolver consumer
 */
public class DbStoreConsumerResolver implements StoreConsumerResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbStoreConsumerResolver.class);

    @Override
    public boolean exist(Object message) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("getCorrelationId db.");
            return dbStoreUserCallback.exist(message);

        } else {
            String errorMsg = "getCorrelationId dbStoreUserCallback is null";

            throw new StoreException(errorMsg);
        }
    }

    /**
     * @param message
     *
     * @return
     *
     * @throws StoreException
     */
    @Override
    public boolean isProcessing(Object message) throws StoreException {
        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("isProcessing db.");
            return dbStoreUserCallback.isProcessing(message);

        } else {
            String errorMsg = "isProcessing dbStoreUserCallback is null";

            throw new StoreException(errorMsg);
        }
    }

    @Override
    public void update2Processing(Object message) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Processing db.");
            dbStoreUserCallback.update2Processing(message);

        } else {
            String errorMsg = "update2Processing dbStoreUserCallback is null";
            throw new StoreException(errorMsg);
        }
    }

    @Override
    public void update2Success(Object message, String infoMsg) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Success db.");
            dbStoreUserCallback.update2Success(message, infoMsg);

        } else {
            String errorMsg = "update2Success dbStoreUserCallback is null";
            throw new StoreException(errorMsg);
        }
    }

    @Override
    public void update2Failed(Object message, String infoMsg) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Failed db.");
            dbStoreUserCallback.update2Failed(message, infoMsg);

        } else {
            String errorMsg = "update2Failed dbStoreUserCallback is null";
            throw new StoreException(errorMsg);
        }
    }

    /**
     * @return
     */
    private DbStoreConsumerUserCallback getCallback() {
        DbStoreConsumerUserCallback dbStoreUserCallback =
            (DbStoreConsumerUserCallback) SpringContextUtil.getBean(DbStoreConsumerUserCallback.class);

        return dbStoreUserCallback;
    }
}
