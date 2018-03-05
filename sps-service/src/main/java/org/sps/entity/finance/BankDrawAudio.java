package org.sps.entity.finance;

import java.io.Serializable;
import java.math.BigDecimal;

/** 提现申请记录表
 * Created by Administrator on 2018-02-23.
 */
public class BankDrawAudio implements Serializable {
    private Integer id;       
    private String  userName;
    private String  auditSerialNum;
    private String  applicationDate;
    private String  payDate;
    private BigDecimal amount    ;
    private BigDecimal  totalAmount  ;
    private BigDecimal  moneyAmount  ;
    private BigDecimal  balance       ;
    private String  bankCard     ;
    private String  companyName  ;
    private String  status  ;
    private String  advice  ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuditSerialNum() {
        return auditSerialNum;
    }

    public void setAuditSerialNum(String auditSerialNum) {
        this.auditSerialNum = auditSerialNum;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}