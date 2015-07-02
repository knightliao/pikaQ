package com.baidu.pikaq.core.db.store;

import com.baidu.pikaq.core.db.store.impl.DbStoreResolver;

/**
 * Created by knightliao on 15/7/2.
 */
public class StoreFactory {

    /**
     * @return
     */
    public static StoreResolver getDebStoreImpl() {
        return new DbStoreResolver();
    }
}
