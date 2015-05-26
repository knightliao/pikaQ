package com.baidu.pikaq.demo.service.campaign.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.demo.service.AbstractDao;
import com.baidu.pikaq.demo.service.Columns;
import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
import com.baidu.pikaq.demo.service.campaign.dao.CampaignDao;
import com.baidu.unbiz.common.genericdao.operator.Match;

/**
 *
 */
@Service
public class CampaignDaoImpl extends AbstractDao<Long, Campaign> implements CampaignDao {

    @Override
    public Campaign getByName(String name) {

        return findOne(new Match(Columns.NAME, name));
    }

    @Override
    public List<Campaign> getByIds(Set<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return findAll();
        }

        return find(match(Columns.CAMPAIGN_ID, ids));
    }

}
