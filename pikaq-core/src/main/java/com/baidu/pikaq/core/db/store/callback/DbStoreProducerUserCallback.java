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

    /**
     * 处理为初始化失败
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    void update2InitFailed(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException;
}
