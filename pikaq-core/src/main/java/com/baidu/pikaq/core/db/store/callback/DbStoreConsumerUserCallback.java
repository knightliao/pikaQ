package com.baidu.pikaq.core.db.store.callback;

import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;

/**
 * Created by knightliao on 15/7/6.
 * 用户consumer callback
 */
public interface DbStoreConsumerUserCallback<MQDATA extends Object> {

    /**
     * 是否存在
     *
     * @param message
     *
     * @return
     */
    boolean exist(MQDATA message);

    /**
     * @param message
     *
     * @return
     *
     * @throws com.baidu.pikaq.core.db.store.exception.StoreException
     */
    boolean isProcessing(MQDATA message) throws StoreException;

    /**
     * 处理为正在处理中
     *
     * @param message
     */
    void update2Processing(MQDATA message) throws StoreUserCallbackException;

    /**
     * 处理为成功
     *
     * @param message
     */
    void update2Success(MQDATA message, String infoMsg) throws StoreUserCallbackException;

    /**
     * 处理为失败
     *
     * @param message
     */
    void update2Failed(MQDATA message, String infoMsg) throws StoreUserCallbackException;
}
