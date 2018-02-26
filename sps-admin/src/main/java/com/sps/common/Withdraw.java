package com.sps.common;

import java.util.Date;

/**
 * Created by Administrator on 18/2/8.
 */
public class Withdraw {
    private Integer id;
    private Date applyTime;
    private Double amountBefore;
    private Double amountAfter;
    private Double amount;
    private Integer withDrawState;
    private Date passTime;
    private Date incomeTime;

    public Date getPassTime() {
        return passTime;
    }

    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Double getAmountBefore() {
        return amountBefore;
    }

    public void setAmountBefore(Double amountBefore) {
        this.amountBefore = amountBefore;
    }

    public Double getAmountAfter() {
        return amountAfter;
    }

    public void setAmountAfter(Double amountAfter) {
        this.amountAfter = amountAfter;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getWithDrawState() {
        return withDrawState;
    }

    public void setWithDrawState(Integer withDrawState) {
        this.withDrawState = withDrawState;
    }
}
