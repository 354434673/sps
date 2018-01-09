package org.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class SpsChannelLogistics implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer logisticsId;

    private String logisticsWay;

    private String logisticsCooperationName;

    private String logisticsOther;

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

    public String getLogisticsOther() {
        return logisticsOther;
    }

    public void setLogisticsOther(String logisticsOther) {
        this.logisticsOther = logisticsOther == null ? null : logisticsOther.trim();
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