package com.baidu.pikaq.demo.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.core.db.store.impl.DbStoreUserCallback;
import com.baidu.pikaq.demo.service.campaign.dao.PikaDataDao;

/**
 * 保存 pika data
 */
@Service
public class DbStoreUserCallbackImpl implements DbStoreUserCallback {

    @Autowired
    private PikaDataDao pikaDataDao;

    @Override
    public void saveStatusData(String correlation, String data) {

        pikaDataDao.saveData(correlation, data);
    }
}
