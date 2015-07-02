package com.baidu.pikaq.core.db.store;

/**
 * 存储Q数据的实现
 */
public interface StoreResolver {

    void resolve(String correlation, String data);
}
