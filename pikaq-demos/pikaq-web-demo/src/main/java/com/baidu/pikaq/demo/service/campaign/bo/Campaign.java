package com.baidu.pikaq.demo.service.campaign.bo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.demo.service.Columns;
import com.baidu.pikaq.demo.service.DB;
import com.baidu.ub.common.commons.BaseObject;
import com.baidu.unbiz.common.genericdao.annotation.Column;
import com.baidu.unbiz.common.genericdao.annotation.Table;

/**
 *
 */
@Table(db = DB.DB_NAME, name = "campaign", keyColumn = Columns.CAMPAIGN_ID)
public class Campaign extends BaseObject<Long> {

    protected static final Logger LOG = LoggerFactory.getLogger(Campaign.class);

    /**
     *
     */
    private static final long serialVersionUID = -2217832889126331664L;

    /**
     * 价格
     */
    @Column(value = "price")
    private BigDecimal price;

    /**
     * 订单名称
     */
    @Column(value = Columns.NAME)
    private String name;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Campaign campaign = (Campaign) o;

        if (!name.equals(campaign.name)) {
            return false;
        }
        if (!price.equals(campaign.price)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
