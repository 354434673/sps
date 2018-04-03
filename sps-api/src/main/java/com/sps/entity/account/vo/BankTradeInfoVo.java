package com.sps.entity.account.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther sunchao
 * @Descript 交易信息展示实体
 * @DATE 2018/4/2.
 */
public class BankTradeInfoVo implements Serializable{

    //申请时间
    private String btApplicationStartDate;
    //发生金额
    private BigDecimal btTradeAmount;
    //审核状态
    private String btTradeStatus;
    //操作类型
    private String btTradeType;
    //年月日
    private String dateDesc;
    //id
    private Integer id;
    //状态
    private Integer rechargeStatus;
    //银行名
    private String bankCardName;
    //银行卡号
    private String bankCardNumber;
    //收入类型 0 微信支付，1 支付宝支付，2 银行卡充值，3商品退款，4平添增加
    private String btIncomeType;
    //支出类型 0 体现，1支付订单首付，2 还款，3 平台减少
    private String btExpenditureType;

    public String getBtApplicationStartDate() {
        return btApplicationStartDate;
    }

    public void setBtApplicationStartDate(String btApplicationStartDate) {
        this.btApplicationStartDate = btApplicationStartDate;
    }

    public BigDecimal getBtTradeAmount() {
        return btTradeAmount;
    }

    public void setBtTradeAmount(BigDecimal btTradeAmount) {
        this.btTradeAmount = btTradeAmount;
    }

    public String getBtTradeStatus() {
        return btTradeStatus;
    }

    public void setBtTradeStatus(String btTradeStatus) {
        this.btTradeStatus = btTradeStatus;
    }

    public String getBtTradeType() {
        return btTradeType;
    }

    public void setBtTradeType(String btTradeType) {
        this.btTradeType = btTradeType;
    }

    public String getDateDesc() {
        return dateDesc;
    }

    public void setDateDesc(String dateDesc) {
        this.dateDesc = dateDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBtIncomeType() {
        return btIncomeType;
    }

    public void setBtIncomeType(String btIncomeType) {
        this.btIncomeType = btIncomeType;
    }

    public String getBtExpenditureType() {
        return btExpenditureType;
    }

    public void setBtExpenditureType(String btExpenditureType) {
        this.btExpenditureType = btExpenditureType;
    }
}
