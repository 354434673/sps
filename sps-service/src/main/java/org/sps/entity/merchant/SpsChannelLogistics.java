package org.sps.entity.merchant;

import java.math.BigDecimal;

public class SpsChannelLogistics {
    private Integer logisticsId;

    private String logisticsWay;

    private String logisticsCooperationName;

    private BigDecimal logisticsAllCost;

    private String channelNum;

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsWay() {
        return logisticsWay;
    }

    public void setLogisticsWay(String logisticsWay) {
        this.logisticsWay = logisticsWay == null ? null : logisticsWay.trim();
    }

    public String getLogisticsCooperationName() {
        return logisticsCooperationName;
    }

    public void setLogisticsCooperationName(String logisticsCooperationName) {
        this.logisticsCooperationName = logisticsCooperationName == null ? null : logisticsCooperationName.trim();
    }

    public BigDecimal getLogisticsAllCost() {
        return logisticsAllCost;
    }

    public void setLogisticsAllCost(BigDecimal logisticsAllCost) {
        this.logisticsAllCost = logisticsAllCost;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}