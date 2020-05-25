package com.sc.entity;

public class ExchangeRecord {
    private int exchangeRecordId;
    private String productName;
    private int productNum;//数量
    private String exchangerId;//兑换人
    private String exchangeTime;

    public int getExchangeRecordId() {
        return exchangeRecordId;
    }

    public void setExchangeRecordId(int exchangeRecordId) {
        this.exchangeRecordId = exchangeRecordId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public String getExchangerId() {
        return exchangerId;
    }

    public void setExchangerId(String exchangerId) {
        this.exchangerId = exchangerId;
    }

    public String getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(String exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    @Override
    public String toString() {
        return "ExchangeRecord{" +
                "exchangeRecordId=" + exchangeRecordId +
                ", productName='" + productName + '\'' +
                ", productNum=" + productNum +
                ", exchangerId='" + exchangerId + '\'' +
                ", exchangeTime='" + exchangeTime + '\'' +
                '}';
    }
}
