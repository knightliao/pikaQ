package com.baidu.pikaq.core.db.store;

import com.baidu.pikaq.core.db.store.exception.StoreException;

/**
 * producer 存储Q数据的实现
 */
public interface StoreProducerResolver {

    void resolve(String correlation, String data) throws StoreException;
}
