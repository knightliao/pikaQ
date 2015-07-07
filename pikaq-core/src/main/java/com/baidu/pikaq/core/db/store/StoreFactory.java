package com.baidu.pikaq.core.db.store;

import com.baidu.pikaq.core.db.store.impl.DbStoreConsumerResolver;
import com.baidu.pikaq.core.db.store.impl.DbStoreProducerResolver;

/**
 * Created by knightliao on 15/7/2.
 * <p/>
 * store
 */
public class StoreFactory {

    /**
     * @return
     */
    public static StoreProducerResolver getDebStoreProducerImpl() {
        return new DbStoreProducerResolver();
    }

    /**
     * @return
     */
    public static StoreConsumerResolver getDebStoreConsumerImpl() {
        return new DbStoreConsumerResolver();
    }
}
