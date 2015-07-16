package com.baidu.pikaq.demo.service.campaign.message.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.core.db.store.StoreDataStatusEnum;
import com.baidu.pikaq.core.db.store.callback.DbStoreConsumerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;
import com.baidu.pikaq.demo.service.pikadata.bo.PikaData;
import com.baidu.pikaq.demo.service.pikadata.dao.PikaDataDao;

/**
 * 保存 pika data
 */
@Service
public class DbStoreConsumerUserCallbackImpl implements DbStoreConsumerUserCallback {

    @Autowired
    private PikaDataDao pikaDataDao;

    /**
     * @param correlation
     *
     * @return
     */
    public boolean exist(String correlation) {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (null != pikaData) {
            return true;
        }
        return false;
    }

    /**
     * @param correlation
     *
     * @return
     *
     * @throws StoreException
     */
    public boolean isProcessing(String correlation) throws StoreException {
        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (null != pikaData) {
            return pikaData.getStatus().equals(StoreDataStatusEnum.PROCESS.getValue());
        }
        throw new StoreUserCallbackException("cannot find this message " + correlation);
    }

    /**
     * 将消息设置为处理中
     *
     * @param correlation
     *
     * @throws StoreUserCallbackException
     */
    public void update2Processing(String correlation) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (null != pikaData) {
            pikaData.setStatus(StoreDataStatusEnum.PROCESS.getValue());
            pikaDataDao.updateOne(pikaData);
        } else {

            throw new StoreUserCallbackException("cannot find this message " + correlation);
        }
    }

    /**
     * 将消息设置为成功，该条消息必须存在，否则可能就是bug了
     *
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    public void update2Success(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (pikaData != null) {
            pikaData.setStatus(StoreDataStatusEnum.SUCCESS.getValue());
            pikaData.setConsumeTime(costTime);
            pikaData.setInfoMsg(infoMsg);
            pikaDataDao.updateOne(pikaData);
        } else {
            throw new StoreUserCallbackException("cannot find this message " + correlation);
        }

    }

    /**
     * @param correlation
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    public void update2Failed(String correlation, String infoMsg, Long costTime) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(correlation);
        if (pikaData != null) {
            pikaData.setStatus(StoreDataStatusEnum.FAILED.getValue());
            pikaData.setConsumeTime(costTime);
            pikaData.setInfoMsg(infoMsg);
            pikaDataDao.updateOne(pikaData);
        } else {
            throw new StoreUserCallbackException("update2Failed cannot find this message: " + correlation);
        }
    }
}
