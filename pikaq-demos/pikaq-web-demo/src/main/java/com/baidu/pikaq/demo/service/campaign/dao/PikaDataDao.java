package com.baidu.pikaq.demo.service.campaign.dao;

/**
 * Created by knightliao on 15/7/2.
 */
public interface PikaDataDao {

    /**
     * @param correlation
     * @param data
     */
    void saveData(String correlation, String data);

}
