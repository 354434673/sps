package org.sps.entity.balance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Balance implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer balanceId;

    private String balanceType;

    private BigDecimal balanceAmount;

    private BigDecimal balanceAmountUsed;

    private BigDecimal balanceAmountUsable;

    private Date balanceExpireDate;

    private Date balanceStartDate;

    private Integer balanceState;

    private String balanceClientNum;

    private Date createTime;

    private Date updateTime;

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType == null ? null : balanceType.trim();
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getBalanceAmountUsed() {
        return balanceAmountUsed;
    }

    public void setBalanceAmountUsed(BigDecimal balanceAmountUsed) {
        this.balanceAmountUsed = balanceAmountUsed;
    }

    public BigDecimal getBalanceAmountUsable() {
        return balanceAmountUsable;
    }

    public void setBalanceAmountUsable(BigDecimal balanceAmountUsable) {
        this.balanceAmountUsable = balanceAmountUsable;
    }

    public Date getBalanceExpireDate() {
        return balanceExpireDate;
    }

    public void setBalanceExpireDate(Date balanceExpireDate) {
        this.balanceExpireDate = balanceExpireDate;
    }

    public Date getBalanceStartDate() {
        return balanceStartDate;
    }

    public void setBalanceStartDate(Date balanceStartDate) {
        this.balanceStartDate = balanceStartDate;
    }

    public Integer getBalanceState() {
        return balanceState;
    }

    public void setBalanceState(Integer balanceState) {
        this.balanceState = balanceState;
    }

    public String getBalanceClientNum() {
        return balanceClientNum;
    }

    public void setBalanceClientNum(String balanceClientNum) {
        this.balanceClientNum = balanceClientNum == null ? null : balanceClientNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}