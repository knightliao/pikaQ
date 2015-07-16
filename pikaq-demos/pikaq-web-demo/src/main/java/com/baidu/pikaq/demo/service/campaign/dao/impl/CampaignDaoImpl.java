package com.baidu.pikaq.demo.service.campaign.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.demo.service.AbstractDao;
import com.baidu.pikaq.demo.service.Columns;
import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
import com.baidu.pikaq.demo.service.campaign.dao.CampaignDao;
import com.baidu.unbiz.common.genericdao.operator.Match;
import com.baidu.unbiz.common.genericdao.operator.Modify;

/**
 *
 */
@Service
public class CampaignDaoImpl extends AbstractDao<Long, Campaign> implements CampaignDao {

    /**
     * @param name
     *
     * @return
     */
    @Override
    public Campaign getByName(String name) {

        return findOne(new Match(Columns.NAME, name));
    }

    /**
     * @param ids
     *
     * @return
     */
    @Override
    public List<Campaign> getByIds(Set<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return findAll();
        }

        return find(match(Columns.CAMPAIGN_ID, ids));
    }

    /**
     * @param id
     *
     * @return
     */
    @Override
    public Campaign getById(Long id) {

        return findOne(match(Columns.CAMPAIGN_ID, id));
    }

    /**
     * @param id
     * @param price
     */
    @Override
    public void updatePriceById(Long id, BigDecimal price) {

        super.update(new Modify(Campaign.CAMPAIGN_COLUMN_PRICE, price), new Match(Columns.CAMPAIGN_ID, id));
    }

    /**
     * @param name
     * @param price
     *
     * @return
     */
    @Override
    public Campaign create(String name, BigDecimal price) {

        Campaign campaign = new Campaign();
        campaign.setPrice(price);
        campaign.setName(name);

        return super.create(campaign);
    }

}
