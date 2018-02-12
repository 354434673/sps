package com.sps.common;

/**
 * Created by Administrator on 18/2/8.
 */
public class Account {
    private String userName;
    private String bankCard;
    private String bankName;
    private Double withdrawAmt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getWithdrawAmt() {
        return withdrawAmt;
    }

    public void setWithdrawAmt(Double withdrawAmt) {
        this.withdrawAmt = withdrawAmt;
    }
}
