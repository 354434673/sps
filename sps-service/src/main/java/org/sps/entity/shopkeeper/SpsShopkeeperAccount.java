package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperAccount implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer accountId;

    private String accountNum;

    private Date accountStartTime;

    private Date accountEndTime;

    private Date accountValidity;

    private Double accountDownPayment;

    private Integer accountState;

    private String shopkeeperCustomerid;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum == null ? null : accountNum.trim();
    }

    public Date getAccountStartTime() {
        return accountStartTime;
    }

    public void setAccountStartTime(Date accountStartTime) {
        this.accountStartTime = accountStartTime;
    }

    public Date getAccountEndTime() {
        return accountEndTime;
    }

    public void setAccountEndTime(Date accountEndTime) {
        this.accountEndTime = accountEndTime;
    }

    public Date getAccountValidity() {
        return accountValidity;
    }

    public void setAccountValidity(Date accountValidity) {
        this.accountValidity = accountValidity;
    }

    public Double getAccountDownPayment() {
        return accountDownPayment;
    }

    public void setAccountDownPayment(Double accountDownPayment) {
        this.accountDownPayment = accountDownPayment;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }
}