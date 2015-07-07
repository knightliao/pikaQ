package com.baidu.pikaq.core.db.store;

import com.baidu.pikaq.core.db.store.exception.StoreException;

/**
 * Created by knightliao on 15/7/6.
 * <p/>
 * consumer 存储Q数据的实现
 */
public interface StoreConsumerResolver {

    /**
     * 获取 correlation id
     *
     * @param message
     *
     * @return
     */
    boolean exist(Object message) throws StoreException;

    /**
     * @param message
     *
     * @return
     *
     * @throws StoreException
     */
    boolean isProcessing(Object message) throws StoreException;

    /**
     * 处理为正在处理中
     *
     * @param message
     */
    void update2Processing(Object message) throws StoreException;

    /**
     * 处理为成功
     *
     * @param message
     */
    void update2Success(Object message, String infoMsg) throws StoreException;

    /**
     * 处理为失败
     *
     * @param message
     */
    void update2Failed(Object message, String infoMsg) throws StoreException;

}
