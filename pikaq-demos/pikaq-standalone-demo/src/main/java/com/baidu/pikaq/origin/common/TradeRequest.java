package com.baidu.pikaq.origin.common;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 */
public class TradeRequest {

    private String ticker;

    private long quantity;

    private BigDecimal price;

    private String orderType;

    private String accountName;

    private boolean buyRequest;

    private String userName;

    private String requestId;

    private String id = UUID.randomUUID().toString();

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isBuyRequest() {
        return buyRequest;
    }

    public void setBuyRequest(boolean buyRequest) {
        this.buyRequest = buyRequest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
