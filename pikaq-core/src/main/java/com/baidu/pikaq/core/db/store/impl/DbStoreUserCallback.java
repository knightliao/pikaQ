package com.baidu.pikaq.core.db.store.impl;

/**
 * 用户写的保存status log的回调
 */
public interface DbStoreUserCallback {

    /**
     * @param correlation
     * @param data
     */
    void saveStatusData(String correlation, String data);
}
