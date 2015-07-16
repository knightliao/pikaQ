package com.baidu.pikaq.demo.service.pikadata.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.demo.service.AbstractDao;
import com.baidu.pikaq.demo.service.pikadata.bo.PikaData;
import com.baidu.pikaq.demo.service.pikadata.dao.PikaDataDao;
import com.baidu.unbiz.common.genericdao.operator.Match;

/**
 * Created by knightliao on 15/7/2.
 */
@Service
public class PikaDataDaoImpl extends AbstractDao<Long, PikaData> implements PikaDataDao {

    /**
     * @param correlation
     * @param data
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void createOne(String correlation, String data) {

        PikaData pikaData = new PikaData();

        pikaData.setCorrelation(correlation);
        pikaData.setCurrentCreateTime();
        pikaData.setCurrentUpdateTime();
        pikaData.setData(data);

        this.create(pikaData);
    }

    @Override
    public void updateOne(PikaData item) {

        item.setCurrentUpdateTime();
        this.update(item);
    }

    @Override
    public PikaData getByCorrelation(String correlation) {

        return this.findOne(new Match(PikaData.PIKA_DATA_COLUMN_CORRELATION, correlation));
    }

}
