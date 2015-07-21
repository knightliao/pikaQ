package com.baidu.pikaq.client.test.service.campaign.bo;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.client.test.service.Columns;
import com.baidu.pikaq.client.test.service.DB;
import com.baidu.pikaq.utils.DateUtils;
import com.baidu.ub.common.commons.BaseObject;
import com.baidu.unbiz.common.genericdao.annotation.Column;
import com.baidu.unbiz.common.genericdao.annotation.Table;

/**
 *
 */
@Table(db = DB.DB_NAME, name = "campaign", keyColumn = Columns.CAMPAIGN_ID)
public class Campaign extends BaseObject<Long> {

    protected static final Logger LOG = LoggerFactory.getLogger(Campaign.class);

    public static final String CAMPAIGN_COLUMN_PRICE = "price";
    public static final String CAMPAIGN_COLUMN_UPDATE_TIME = "updateTime";

    /**
     *
     */
    private static final long serialVersionUID = -2217832889126331664L;

    /**
     * 价格
     */
    @Column(value = Campaign.CAMPAIGN_COLUMN_PRICE)
    private BigDecimal price;

    /**
     * 订单名称
     */
    @Column(value = Columns.NAME)
    private String name;

    /**
     * 生成时间
     */
    @Column(value = "createTime")
    private String createTime = "";

    /**
     * 修改时间
     */
    @Column(value = Campaign.CAMPAIGN_COLUMN_UPDATE_TIME)
    private String updateTime = "";

    /**
     * 设置 生成时间
     */
    public void setCurrentCreateTime() {
        this.setCreateTime(DateUtils.formatDate(new Date(), DateUtils.DEFAULT_TIME_FORMAT));
    }

    /**
     * 设置 更新时间
     */
    public void setCurrentUpdateTime() {
        this.setUpdateTime(DateUtils.formatDate(new Date(), DateUtils.DEFAULT_TIME_FORMAT));
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
