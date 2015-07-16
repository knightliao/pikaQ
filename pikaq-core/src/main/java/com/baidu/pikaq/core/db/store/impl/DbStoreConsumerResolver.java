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
    public boolean exist(String correlation) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("getCorrelationId db.");
            return dbStoreUserCallback.exist(correlation);

        } else {
            String errorMsg = "getCorrelationId dbStoreUserCallback is null";

            throw new StoreException(errorMsg);
        }
    }

    /**
     * @param correlation
     *
     * @return
     *
     * @throws StoreException
     */
    @Override
    public boolean isProcessing(String correlation) throws StoreException {
        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("isProcessing db.");
            return dbStoreUserCallback.isProcessing(correlation);

        } else {
            String errorMsg = "isProcessing dbStoreUserCallback is null";

            throw new StoreException(errorMsg);
        }
    }

    /**
     * @param correlation
     *
     * @throws StoreException
     */
    @Override
    public void update2Processing(String correlation) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Processing db.");
            dbStoreUserCallback.update2Processing(correlation);

        } else {
            String errorMsg = "update2Processing dbStoreUserCallback is null";
            throw new StoreException(errorMsg);
        }
    }

    /**
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreException
     */
    @Override
    public void update2Success(String correlation, String infoMsg) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Success db.");
            dbStoreUserCallback.update2Success(correlation, infoMsg);

        } else {
            String errorMsg = "update2Success dbStoreUserCallback is null";
            throw new StoreException(errorMsg);
        }
    }

    @Override
    public void update2Failed(String correlation, String infoMsg) throws StoreException {

        DbStoreConsumerUserCallback dbStoreUserCallback = getCallback();

        if (dbStoreUserCallback != null) {

            LOGGER.debug("update2Failed db.");
            dbStoreUserCallback.update2Failed(correlation, infoMsg);

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
