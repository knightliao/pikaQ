package com.baidu.pikaq.client.test.service.campaign.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.baidu.pikaq.client.test.service.campaign.bo.Campaign;
import com.baidu.unbiz.common.genericdao.dao.BaseDao;

/**
 *
 */
public interface CampaignDao extends BaseDao<Long, Campaign> {

    /**
     * @param name
     *
     * @return
     */
    Campaign getByName(String name);

    /**
     * @param ids
     *
     * @return
     */
    List<Campaign> getByIds(Set<Long> ids);

    /**
     * @param name
     * @param price
     *
     * @return
     */
    Campaign create(String name, BigDecimal price);

    /**
     * @param id
     *
     * @return
     */
    Campaign getById(Long id);

    /**
     * @param id
     * @param price
     */
    void updatePriceById(Long id, BigDecimal price);

}
