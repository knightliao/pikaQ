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
     * @param correlation
     *
     * @return
     *
     * @throws StoreException
     */
    boolean exist(String correlation) throws StoreException;

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
     * @throws StoreException
     */
    void update2Processing(String correlation) throws StoreException;

    /**
     * 处理为成功
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreException
     */
    void update2Success(String correlation, String infoMsg) throws StoreException;

    /**
     * 处理为失败
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreException
     */
    void update2Failed(String correlation, String infoMsg) throws StoreException;

}
