package com.sps.entity.bank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsBank  implements Serializable{
    private Integer id;

    private String bName;

    private String bAccounts;

    private String bIdentity;

    private String bPhone;

    private Date bCreatetime;

    private Date bUpdatetime;

    private String bBank;

    private Integer bState;

    private String bRemark;

    private String bUserId;

    private String bUserName;

    private String channlNum;

    private BigDecimal bAvailableBalance;

    private String bTransPassword;

    private String bPasswordState;

    private String standby2;

    private Integer userMark;

    private Integer flag;

    private byte[] bCardType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbAccounts() {
        return bAccounts;
    }

    public void setbAccounts(String bAccounts) {
        this.bAccounts = bAccounts == null ? null : bAccounts.trim();
    }

    public String getbIdentity() {
        return bIdentity;
    }

    public void setbIdentity(String bIdentity) {
        this.bIdentity = bIdentity == null ? null : bIdentity.trim();
    }

    public String getbPhone() {
        return bPhone;
    }

    public void setbPhone(String bPhone) {
        this.bPhone = bPhone == null ? null : bPhone.trim();
    }

    public Date getbCreatetime() {
        return bCreatetime;
    }

    public void setbCreatetime(Date bCreatetime) {
        this.bCreatetime = bCreatetime;
    }

    public Date getbUpdatetime() {
        return bUpdatetime;
    }

    public void setbUpdatetime(Date bUpdatetime) {
        this.bUpdatetime = bUpdatetime;
    }

    public String getbBank() {
        return bBank;
    }

    public void setbBank(String bBank) {
        this.bBank = bBank == null ? null : bBank.trim();
    }

    public Integer getbState() {
        return bState;
    }

    public void setbState(Integer bState) {
        this.bState = bState;
    }

    public String getbRemark() {
        return bRemark;
    }

    public void setbRemark(String bRemark) {
        this.bRemark = bRemark == null ? null : bRemark.trim();
    }

    public String getbUserId() {
        return bUserId;
    }

    public void setbUserId(String bUserId) {
        this.bUserId = bUserId == null ? null : bUserId.trim();
    }

    public String getbUserName() {
        return bUserName;
    }

    public void setbUserName(String bUserName) {
        this.bUserName = bUserName == null ? null : bUserName.trim();
    }

    public String getChannlNum() {
        return channlNum;
    }

    public void setChannlNum(String channlNum) {
        this.channlNum = channlNum == null ? null : channlNum.trim();
    }

    public BigDecimal getbAvailableBalance() {
        return bAvailableBalance;
    }

    public void setbAvailableBalance(BigDecimal bAvailableBalance) {
        this.bAvailableBalance = bAvailableBalance;
    }

    public String getbTransPassword() {
        return bTransPassword;
    }

    public void setbTransPassword(String bTransPassword) {
        this.bTransPassword = bTransPassword == null ? null : bTransPassword.trim();
    }

    public String getbPasswordState() {
        return bPasswordState;
    }

    public void setbPasswordState(String bPasswordState) {
        this.bPasswordState = bPasswordState == null ? null : bPasswordState.trim();
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2 == null ? null : standby2.trim();
    }

    public Integer getUserMark() {
        return userMark;
    }

    public void setUserMark(Integer userMark) {
        this.userMark = userMark;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public byte[] getbCardType() {
        return bCardType;
    }

    public void setbCardType(byte[] bCardType) {
        this.bCardType = bCardType;
    }
}