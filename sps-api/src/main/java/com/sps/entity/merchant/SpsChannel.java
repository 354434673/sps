package com.sps.entity.merchant;

import java.io.Serializable;
import java.util.Date;

public class SpsChannel implements Serializable {
	
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer channelId;

    private String channelCity;

    private String channelSalesmanNum;

    private String channelSalesmanName;

    private String channelNum;

    private Integer channelState;

    private Integer channelFlowState;

    private Date channelUpTime;

    private Date channelFreezeTime;

    private String standby1;

    private String standby2;

    private String standby3;

    private String standby4;
    
    private SpsChannelEnterprise enterprise;
    
    private SpsChannelBusiness business;
    
    private SpsChannelGuarantee guarantee;
    
    private SpsChannelLogistics logistics;
    
    private SpsChannelSalesman salesman;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelCity() {
        return channelCity;
    }

    public void setChannelCity(String channelCity) {
        this.channelCity = channelCity == null ? null : channelCity.trim();
    }

    public String getChannelSalesmanNum() {
        return channelSalesmanNum;
    }

    public void setChannelSalesmanNum(String channelSalesmanNum) {
        this.channelSalesmanNum = channelSalesmanNum == null ? null : channelSalesmanNum.trim();
    }

    public String getChannelSalesmanName() {
        return channelSalesmanName;
    }

    public void setChannelSalesmanName(String channelSalesmanName) {
        this.channelSalesmanName = channelSalesmanName == null ? null : channelSalesmanName.trim();
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }

    public Integer getChannelState() {
        return channelState;
    }

    public void setChannelState(Integer channelState) {
        this.channelState = channelState;
    }

    public Integer getChannelFlowState() {
        return channelFlowState;
    }

    public void setChannelFlowState(Integer channelFlowState) {
        this.channelFlowState = channelFlowState;
    }

    public Date getChannelUpTime() {
        return channelUpTime;
    }

    public void setChannelUpTime(Date channelUpTime) {
        this.channelUpTime = channelUpTime;
    }

    public Date getChannelFreezeTime() {
        return channelFreezeTime;
    }

    public void setChannelFreezeTime(Date channelFreezeTime) {
        this.channelFreezeTime = channelFreezeTime;
    }

    public String getStandby1() {
        return standby1;
    }

    public void setStandby1(String standby1) {
        this.standby1 = standby1 == null ? null : standby1.trim();
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2 == null ? null : standby2.trim();
    }

    public String getStandby3() {
        return standby3;
    }

    public void setStandby3(String standby3) {
        this.standby3 = standby3 == null ? null : standby3.trim();
    }

    public String getStandby4() {
        return standby4;
    }

    public void setStandby4(String standby4) {
        this.standby4 = standby4 == null ? null : standby4.trim();
    }
}