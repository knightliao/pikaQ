package com.baidu.pikaq.demo.service.pikadata.dao;

import com.baidu.pikaq.demo.service.pikadata.bo.PikaData;

/**
 * Created by knightliao on 15/7/2.
 */
public interface PikaDataDao {

    /**
     * @param correlation
     * @param data
     */
    void createOne(String correlation, String data);

    /**
     */
    void updateOne(PikaData pikaData);

    /**
     * @param correlation
     */
    PikaData getByCorrelation(String correlation);

}
