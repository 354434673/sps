package org.sps.entity.merchant;

import java.math.BigDecimal;

public class SpsChannelAccount {
    private Integer accountId;

    private BigDecimal accountCreditLine;

    private BigDecimal accountCreditPresent;

    private BigDecimal accountDeposit;

    private BigDecimal accountDepositPresent;

    private String channelNum;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAccountCreditLine() {
        return accountCreditLine;
    }

    public void setAccountCreditLine(BigDecimal accountCreditLine) {
        this.accountCreditLine = accountCreditLine;
    }

    public BigDecimal getAccountCreditPresent() {
        return accountCreditPresent;
    }

    public void setAccountCreditPresent(BigDecimal accountCreditPresent) {
        this.accountCreditPresent = accountCreditPresent;
    }

    public BigDecimal getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(BigDecimal accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public BigDecimal getAccountDepositPresent() {
        return accountDepositPresent;
    }

    public void setAccountDepositPresent(BigDecimal accountDepositPresent) {
        this.accountDepositPresent = accountDepositPresent;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}