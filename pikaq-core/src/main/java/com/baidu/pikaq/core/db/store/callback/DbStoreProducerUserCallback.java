package com.baidu.pikaq.core.db.store.callback;

import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;

/**
 * 用户写的保存status log的回调
 */
public interface DbStoreProducerUserCallback {

    /**
     * @param correlation
     * @param data
     */
    void saveStatusData(String correlation, String data, String exchange, String routerKey)
        throws StoreUserCallbackException;
}
