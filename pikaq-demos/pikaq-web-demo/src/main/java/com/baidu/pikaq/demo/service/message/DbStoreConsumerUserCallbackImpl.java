package com.baidu.pikaq.demo.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.core.db.store.StoreDataStatusEnum;
import com.baidu.pikaq.core.db.store.callback.DbStoreConsumerUserCallback;
import com.baidu.pikaq.core.db.store.exception.StoreException;
import com.baidu.pikaq.core.db.store.exception.StoreUserCallbackException;
import com.baidu.pikaq.demo.service.campaign.bo.PikaData;
import com.baidu.pikaq.demo.service.campaign.dao.PikaDataDao;

/**
 * 保存 pika data
 */
@Service
public class DbStoreConsumerUserCallbackImpl implements DbStoreConsumerUserCallback<PikaData> {

    @Autowired
    private PikaDataDao pikaDataDao;

    /**
     * @param message
     *
     * @return
     */
    public boolean exist(PikaData message) {

        PikaData pikaData = pikaDataDao.getByCorrelation(message.getCorrelation());
        if (null != pikaData) {
            return true;
        }
        return false;
    }

    /**
     * @param message
     *
     * @return
     *
     * @throws StoreException
     */
    public boolean isProcessing(PikaData message) throws StoreException {
        PikaData pikaData = pikaDataDao.getByCorrelation(message.getCorrelation());
        if (null != pikaData) {
            return pikaData.getStatus().equals(StoreDataStatusEnum.PROCESS.getValue());
        }
        throw new StoreUserCallbackException("cannot find this message " + message.toString());
    }

    /**
     * 将消息设置为处理中
     *
     * @param message
     *
     * @throws StoreUserCallbackException
     */
    public void update2Processing(PikaData message) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(message.getCorrelation());
        if (null != pikaData) {
            pikaData.setStatus(StoreDataStatusEnum.PROCESS.getValue());
            pikaDataDao.createOne(pikaData);
        } else {
            message.setStatus(StoreDataStatusEnum.PROCESS.getValue());
            pikaDataDao.createOne(message);
        }
    }

    /**
     * 将消息设置为成功，该条消息必须存在，否则可能就是bug了
     *
     * @param message
     *
     * @throws StoreUserCallbackException
     */
    public void update2Success(PikaData message, String infoMsg) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(message.getCorrelation());
        if (pikaData != null) {
            pikaData.setStatus(StoreDataStatusEnum.SUCCESS.getValue());
            pikaData.setInfoMsg(infoMsg);
            pikaDataDao.createOne(pikaData);
        } else {
            throw new StoreUserCallbackException("update2Success cannot find this message: " + message.toString());
        }

    }

    /**
     * @param message
     * @param infoMsg
     *
     * @throws StoreUserCallbackException
     */
    public void update2Failed(PikaData message, String infoMsg) throws StoreUserCallbackException {

        PikaData pikaData = pikaDataDao.getByCorrelation(message.getCorrelation());
        if (pikaData != null) {
            pikaData.setStatus(StoreDataStatusEnum.FAILED.getValue());
            pikaData.setInfoMsg(infoMsg);
            pikaDataDao.createOne(pikaData);
        } else {
            throw new StoreUserCallbackException("update2Failed cannot find this message: " + message.toString());
        }
    }
}
