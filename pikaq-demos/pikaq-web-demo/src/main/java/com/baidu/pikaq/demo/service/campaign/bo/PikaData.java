package com.baidu.pikaq.demo.service.campaign.bo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.pikaq.core.db.store.StoreDataStatusEnum;
import com.baidu.pikaq.demo.service.DB;
import com.baidu.pikaq.utils.DateUtils;
import com.baidu.ub.common.commons.BaseObject;
import com.baidu.unbiz.common.genericdao.annotation.Column;
import com.baidu.unbiz.common.genericdao.annotation.Table;

/**
 *
 */
@Table(db = DB.DB_NAME, name = "pikaq_data", keyColumn = "id")
public class PikaData extends BaseObject<Long> {

    protected static final Logger LOG = LoggerFactory.getLogger(Campaign.class);

    /**
     * 业务逻辑ID
     */
    @Column(value = "correlation")
    private String correlation;

    /**
     * 生成时间
     */
    @Column(value = "create_time")
    private String createTime;

    /**
     * data
     */
    @Column(value = "data")
    private String data;

    /**
     * status
     */
    @Column(value = "status")
    private Integer status = StoreDataStatusEnum.INIT.getValue();

    /**
     * 设置 生成时间
     */
    public void setCurrentCreateTime() {
        this.setCreateTime(DateUtils.formatDate(new Date(), DateUtils.DEFAULT_TIME_FORMAT));
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
