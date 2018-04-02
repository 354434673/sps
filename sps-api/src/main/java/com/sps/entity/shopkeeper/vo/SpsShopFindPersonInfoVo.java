package com.sps.entity.shopkeeper.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther sunchao
 * @Descript 商户个性信息
 * @DATE 2018/4/2.
 */
public class SpsShopFindPersonInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;


    //头像
    private String url;
    //额度
    private BigDecimal balanceAmount;
    //可用额度
    private BigDecimal amountUsable;
    //余额
    private BigDecimal balance;
    //近三天待还款
    private BigDecimal threeDayRepayment;
    //近七天待还款
    private BigDecimal weekRepayment;
    //待还款金额
    private BigDecimal repayAmount;
    //认证状态
    private Integer shopkeeperState;
    //名称
    private String personalNickname;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getAmountUsable() {
        return amountUsable;
    }

    public void setAmountUsable(BigDecimal amountUsable) {
        this.amountUsable = amountUsable;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getThreeDayRepayment() {
        return threeDayRepayment;
    }

    public void setThreeDayRepayment(BigDecimal threeDayRepayment) {
        this.threeDayRepayment = threeDayRepayment;
    }

    public BigDecimal getWeekRepayment() {
        return weekRepayment;
    }

    public void setWeekRepayment(BigDecimal weekRepayment) {
        this.weekRepayment = weekRepayment;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Integer getShopkeeperState() {
        return shopkeeperState;
    }

    public void setShopkeeperState(Integer shopkeeperState) {
        this.shopkeeperState = shopkeeperState;
    }

    public String getPersonalNickname() {
        return personalNickname;
    }

    public void setPersonalNickname(String personalNickname) {
        this.personalNickname = personalNickname;
    }
}
