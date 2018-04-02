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
}
