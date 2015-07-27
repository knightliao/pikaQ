package com.baidu.pikaq.client.test.service.campaign.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.client.test.service.pikadata.bo.PikaData;
import com.baidu.pikaq.client.test.service.pikadata.dao.PikaDataDao;
import com.baidu.pikaq.core.db.store.StoreDataStatusEnum;
import com.baidu.pikaq.core.db.store.callback.DbStoreProducerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;

/**
 * 保存 pika data
 */
@Service
public class DbStoreProducerUserCallbackImpl implements DbStoreProducerUserCallback {

    @Autowired
    private PikaDataDao pikaDataDao;

    /**
     * 设置为生成成功
     *
     * @param correlation
     * @param data
     * @param exchange
     * @param routerKey
     *
     * @throws StoreUserCallbackException
     */
    @Override
    public void saveStatusData(String correlation, String data, String exchange, String routerKey)
        throws StoreUserCallbackException {

        pikaDataDao.createOne(correlation, data, exchange, routerKey);
    }

    /**
     * 设置为生成失败
     *
     * @param correlation
     * @param infoMsg
     * @param costTime
     *
     * @throws StoreUserCallbackException
     */
    @Override
    public void update2InitFailed(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (pikaData != null) {
            pikaData.setStatus(StoreDataStatusEnum.PRODUCE_INIT_FAILED.getValue());
            pikaData.setConsumeTime(costTime);
            pikaData.setInfoMsg(infoMsg);
            pikaDataDao.updateOne(pikaData);
        } else {
            throw new StoreUserCallbackException("update2Failed cannot find this message: " + correlation);
        }
    }
}
