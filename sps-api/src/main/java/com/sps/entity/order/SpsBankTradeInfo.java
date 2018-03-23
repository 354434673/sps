package com.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsBankTradeInfo implements Serializable {
    private Integer id;

    private String btTradeName;

    private String btTradeSerialNum;

    private String btIdentity;

    private Date btApplicationStartDate;

    private Date btApplicationStopDate;

    private Date btAuditDate;

    private Date btPaymentDate;

    private String btTradeType;

    private String btIncomeType;

    private String btExpenditureType;

    private BigDecimal btTradeBeforeBalanc;

    private BigDecimal btTradeAfterBalanc;

    private BigDecimal btTradeAmount;

    private String btTradeStatus;

    private String btUserId;

    private String standby1;

    private String standby2;

    private String standby3;

    private String btTradeNo;

    private String orderid;

    private BigDecimal firstMoney;

    private BigDecimal shopPayMoney;

    private BigDecimal serviceMoney;

    private BigDecimal sumServiceMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBtTradeName() {
        return btTradeName;
    }

    public void setBtTradeName(String btTradeName) {
        this.btTradeName = btTradeName == null ? null : btTradeName.trim();
    }

    public String getBtTradeSerialNum() {
        return btTradeSerialNum;
    }

    public void setBtTradeSerialNum(String btTradeSerialNum) {
        this.btTradeSerialNum = btTradeSerialNum == null ? null : btTradeSerialNum.trim();
    }

    public String getBtIdentity() {
        return btIdentity;
    }

    public void setBtIdentity(String btIdentity) {
        this.btIdentity = btIdentity == null ? null : btIdentity.trim();
    }

    public Date getBtApplicationStartDate() {
        return btApplicationStartDate;
    }

    public void setBtApplicationStartDate(Date btApplicationStartDate) {
        this.btApplicationStartDate = btApplicationStartDate;
    }

    public Date getBtApplicationStopDate() {
        return btApplicationStopDate;
    }

    public void setBtApplicationStopDate(Date btApplicationStopDate) {
        this.btApplicationStopDate = btApplicationStopDate;
    }

    public Date getBtAuditDate() {
        return btAuditDate;
    }

    public void setBtAuditDate(Date btAuditDate) {
        this.btAuditDate = btAuditDate;
    }

    public Date getBtPaymentDate() {
        return btPaymentDate;
    }

    public void setBtPaymentDate(Date btPaymentDate) {
        this.btPaymentDate = btPaymentDate;
    }

    public String getBtTradeType() {
        return btTradeType;
    }

    public void setBtTradeType(String btTradeType) {
        this.btTradeType = btTradeType == null ? null : btTradeType.trim();
    }

    public String getBtIncomeType() {
        return btIncomeType;
    }

    public void setBtIncomeType(String btIncomeType) {
        this.btIncomeType = btIncomeType == null ? null : btIncomeType.trim();
    }

    public String getBtExpenditureType() {
        return btExpenditureType;
    }

    public void setBtExpenditureType(String btExpenditureType) {
        this.btExpenditureType = btExpenditureType == null ? null : btExpenditureType.trim();
    }

    public BigDecimal getBtTradeBeforeBalanc() {
        return btTradeBeforeBalanc;
    }

    public void setBtTradeBeforeBalanc(BigDecimal btTradeBeforeBalanc) {
        this.btTradeBeforeBalanc = btTradeBeforeBalanc;
    }

    public BigDecimal getBtTradeAfterBalanc() {
        return btTradeAfterBalanc;
    }

    public void setBtTradeAfterBalanc(BigDecimal btTradeAfterBalanc) {
        this.btTradeAfterBalanc = btTradeAfterBalanc;
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
        this.btTradeStatus = btTradeStatus == null ? null : btTradeStatus.trim();
    }

    public String getBtUserId() {
        return btUserId;
    }

    public void setBtUserId(String btUserId) {
        this.btUserId = btUserId == null ? null : btUserId.trim();
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

    public String getBtTradeNo() {
        return btTradeNo;
    }

    public void setBtTradeNo(String btTradeNo) {
        this.btTradeNo = btTradeNo == null ? null : btTradeNo.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public BigDecimal getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(BigDecimal firstMoney) {
        this.firstMoney = firstMoney;
    }

    public BigDecimal getShopPayMoney() {
        return shopPayMoney;
    }

    public void setShopPayMoney(BigDecimal shopPayMoney) {
        this.shopPayMoney = shopPayMoney;
    }

    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public BigDecimal getSumServiceMoney() {
        return sumServiceMoney;
    }

    public void setSumServiceMoney(BigDecimal sumServiceMoney) {
        this.sumServiceMoney = sumServiceMoney;
    }
}