package org.sps.entity.finance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 提现申请记录表
 * Created by Administrator on 2018-02-23.
 */
public class LoanInfo implements Serializable {
  private Integer id;
    private String  orderNo;
    private String  LoanName;
    private String  status;
    private String  loanNo;
    private Date loanStartDate;
    private Date loanEndDate;
    private BigDecimal loanAmount;
    private  BigDecimal loanBalancel;
    private  Double  shouXuFeiByDate;
    private  BigDecimal  incomeShouXuFei;
    private  Double   daiXiaoFeilv;
    private  BigDecimal daiXiaoFei;
    public Integer getId() {
        return id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLoanName() {
        return LoanName;
    }

    public void setLoanName(String loanName) {
        LoanName = loanName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public Date getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(Date loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanBalancel() {
        return loanBalancel;
    }

    public void setLoanBalancel(BigDecimal loanBalancel) {
        this.loanBalancel = loanBalancel;
    }

    public Double getShouXuFeiByDate() {
        return shouXuFeiByDate;
    }

    public void setShouXuFeiByDate(Double shouXuFeiByDate) {
        this.shouXuFeiByDate = shouXuFeiByDate;
    }

    public BigDecimal getIncomeShouXuFei() {
        return incomeShouXuFei;
    }

    public void setIncomeShouXuFei(BigDecimal incomeShouXuFei) {
        this.incomeShouXuFei = incomeShouXuFei;
    }

    public Double getDaiXiaoFeilv() {
        return daiXiaoFeilv;
    }

    public void setDaiXiaoFeilv(Double daiXiaoFeilv) {
        this.daiXiaoFeilv = daiXiaoFeilv;
    }

    public BigDecimal getDaiXiaoFei() {
        return daiXiaoFei;
    }

    public void setDaiXiaoFei(BigDecimal daiXiaoFei) {
        this.daiXiaoFei = daiXiaoFei;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
