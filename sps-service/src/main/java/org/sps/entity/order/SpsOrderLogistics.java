package org.sps.entity.order;

import java.io.Serializable;
import java.util.Date;

public class SpsOrderLogistics implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer logisticsId;

    private String logisticsName;

    private String logisticsCode;

    private String logisticsOther;

    private String logisticsNum;

    private String logisticsVoucher;

    private Date logisticsCreatTime;

    private Date logisticsUpdateTime;

    private String orderId;

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode == null ? null : logisticsCode.trim();
    }

    public String getLogisticsOther() {
        return logisticsOther;
    }

    public void setLogisticsOther(String logisticsOther) {
        this.logisticsOther = logisticsOther == null ? null : logisticsOther.trim();
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    public String getLogisticsVoucher() {
        return logisticsVoucher;
    }

    public void setLogisticsVoucher(String logisticsVoucher) {
        this.logisticsVoucher = logisticsVoucher == null ? null : logisticsVoucher.trim();
    }

    public Date getLogisticsCreatTime() {
        return logisticsCreatTime;
    }

    public void setLogisticsCreatTime(Date logisticsCreatTime) {
        this.logisticsCreatTime = logisticsCreatTime;
    }

    public Date getLogisticsUpdateTime() {
        return logisticsUpdateTime;
    }

    public void setLogisticsUpdateTime(Date logisticsUpdateTime) {
        this.logisticsUpdateTime = logisticsUpdateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}