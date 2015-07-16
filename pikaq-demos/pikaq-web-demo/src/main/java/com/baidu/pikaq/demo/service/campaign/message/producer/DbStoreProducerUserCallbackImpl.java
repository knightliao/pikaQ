package com.baidu.pikaq.demo.service.campaign.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.core.db.store.callback.DbStoreProducerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;
import com.baidu.pikaq.demo.service.campaign.dao.PikaDataDao;

/**
 * 保存 pika data
 */
@Service
public class DbStoreProducerUserCallbackImpl implements DbStoreProducerUserCallback {

    @Autowired
    private PikaDataDao pikaDataDao;

    @Override
    public void saveStatusData(String correlation, String data) throws StoreUserCallbackException {

        pikaDataDao.createOne(correlation, data);
    }
}
