package com.baidu.pikaq.demo.service.campaign.dao;

import java.util.List;
import java.util.Set;

import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
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

}
