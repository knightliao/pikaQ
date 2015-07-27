package com.baidu.pikaq.demo.service.pikadata.bo;

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

    protected static final Logger LOG = LoggerFactory.getLogger(PikaData.class);

    public static final String PIKA_DATA_COLUMN_CORRELATION = "correlation";

    /**
     * 业务逻辑ID
     */
    @Column(value = PIKA_DATA_COLUMN_CORRELATION)
    private String correlation;

    /**
     * 生成时间
     */
    @Column(value = "createTime")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(value = "updateTime")
    private String updateTime;

    /**
     * data
     */
    @Column(value = "data")
    private String data;

    /**
     * status
     */
    @Column(value = "status")
    private Integer status = StoreDataStatusEnum.PRODUCE_INIT.getValue();

    /**
     * err_msg
     */
    @Column(value = "infoMsg")
    private String infoMsg = "";

    /**
     * consumeTime
     */
    @Column(value = "consumeTime")
    private Long consumeTime = 0L;

    /**
     * consumeTime
     */
    @Column(value = "retryCount")
    private Integer retryCount = 0;

    /**
     * exchange
     */
    @Column(value = "exchange")
    private String exchange = "";

    /**
     * routerKey
     */
    @Column(value = "routerKey")
    private String routerKey = "";

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

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfoMsg() {
        return infoMsg;
    }

    public void setInfoMsg(String infoMsg) {
        this.infoMsg = infoMsg;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRouterKey() {
        return routerKey;
    }

    public void setRouterKey(String routerKey) {
        this.routerKey = routerKey;
    }

    @Override
    public String toString() {
        return "PikaData{" +
                   "correlation='" + correlation + '\'' +
                   ", createTime='" + createTime + '\'' +
                   ", updateTime='" + updateTime + '\'' +
                   ", data='" + data + '\'' +
                   ", status=" + status +
                   ", infoMsg='" + infoMsg + '\'' +
                   ", consumeTime=" + consumeTime +
                   ", retryCount=" + retryCount +
                   ", exchange='" + exchange + '\'' +
                   ", routerKey='" + routerKey + '\'' +
                   '}';
    }
}
