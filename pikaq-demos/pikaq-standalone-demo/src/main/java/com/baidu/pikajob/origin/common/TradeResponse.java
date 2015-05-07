package com.baidu.pikajob.origin.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class TradeResponse {

    private String ticker;

    private long quantity;

    private BigDecimal price;

    private String orderType;

    private String confirmationNumber;

    private boolean error;

    private String errorMessage;

    private String accountName;

    private long timestamp = new Date().getTime();

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

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

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TradeResponse [accountName=" + accountName + ", requestId=" + requestId + ", confirmationNumber=" +
                   confirmationNumber + ", error=" + error + ", errorMessage=" + errorMessage + ", orderType=" +
                   orderType + ", price=" + price + ", quantity=" + quantity + ", ticker=" + ticker + "]";
    }

}
