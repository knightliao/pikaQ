package com.baidu.pikaq.core.db.store;

import com.baidu.pikaq.core.db.store.exception.StoreException;

/**
 * producer 存储Q数据的实现
 */
public interface StoreProducerResolver {

    void resolve(String correlation, String data, String exchange, String routerKey) throws StoreException;

    /**
     * 处理为失败
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreException
     */
    void resolve2Failed(String correlation, String infoMsg, Long costTime) throws StoreException;
}
