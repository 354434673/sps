package com.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsOrderRepayDetail implements Serializable {
    private Integer id;

    private String customeNum;

    private String orderStatus;

    private String orderNo;

    private Date repayDate;

    private BigDecimal repayBenAmount;

    private BigDecimal repayAccrualAmount;

    private BigDecimal rapayPoundage;

    private BigDecimal noRepayBenAmount;

    private BigDecimal noReapayAccrualAmount;

    private BigDecimal noRepayPoundage;

    private BigDecimal repayAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomeNum() {
        return customeNum;
    }

    public void setCustomeNum(String customeNum) {
        this.customeNum = customeNum == null ? null : customeNum.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayBenAmount() {
        return repayBenAmount;
    }

    public void setRepayBenAmount(BigDecimal repayBenAmount) {
        this.repayBenAmount = repayBenAmount;
    }

    public BigDecimal getRepayAccrualAmount() {
        return repayAccrualAmount;
    }

    public void setRepayAccrualAmount(BigDecimal repayAccrualAmount) {
        this.repayAccrualAmount = repayAccrualAmount;
    }

    public BigDecimal getRapayPoundage() {
        return rapayPoundage;
    }

    public void setRapayPoundage(BigDecimal rapayPoundage) {
        this.rapayPoundage = rapayPoundage;
    }

    public BigDecimal getNoRepayBenAmount() {
        return noRepayBenAmount;
    }

    public void setNoRepayBenAmount(BigDecimal noRepayBenAmount) {
        this.noRepayBenAmount = noRepayBenAmount;
    }

    public BigDecimal getNoReapayAccrualAmount() {
        return noReapayAccrualAmount;
    }

    public void setNoReapayAccrualAmount(BigDecimal noReapayAccrualAmount) {
        this.noReapayAccrualAmount = noReapayAccrualAmount;
    }

    public BigDecimal getNoRepayPoundage() {
        return noRepayPoundage;
    }

    public void setNoRepayPoundage(BigDecimal noRepayPoundage) {
        this.noRepayPoundage = noRepayPoundage;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }
}