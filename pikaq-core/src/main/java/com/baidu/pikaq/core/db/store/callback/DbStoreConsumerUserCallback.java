package com.baidu.pikaq.core.db.store.callback;

import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;

/**
 * Created by knightliao on 15/7/6.
 * 用户consumer callback
 */
public interface DbStoreConsumerUserCallback {

    /**
     * 是否存在
     *
     * @param correlation
     *
     * @return
     */
    boolean exist(String correlation);

    /**
     * @param correlation
     *
     * @return
     *
     * @throws StoreException
     */
    boolean isProcessing(String correlation) throws StoreException;

    /**
     * 处理为正在处理中
     *
     * @param correlation
     *
     * @throws StoreUserCallbackException
     */
    void update2Processing(String correlation) throws StoreUserCallbackException;

    /**
     * 处理为成功
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    void update2Success(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException;

    /**
     * 处理为失败
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    void update2Failed(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException;
}
