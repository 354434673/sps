package com.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperCredit implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer creditId;

    private String creditUsername;

    private String creditPassword;

    private String creditVerify;

    private Date creditCreatTime;

    private Date creditUpdateTime;

    private String shopkeeperCustomerid;

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public String getCreditUsername() {
        return creditUsername;
    }

    public void setCreditUsername(String creditUsername) {
        this.creditUsername = creditUsername == null ? null : creditUsername.trim();
    }

    public String getCreditPassword() {
        return creditPassword;
    }

    public void setCreditPassword(String creditPassword) {
        this.creditPassword = creditPassword == null ? null : creditPassword.trim();
    }

    public String getCreditVerify() {
        return creditVerify;
    }

    public void setCreditVerify(String creditVerify) {
        this.creditVerify = creditVerify == null ? null : creditVerify.trim();
    }

    public Date getCreditCreatTime() {
        return creditCreatTime;
    }

    public void setCreditCreatTime(Date creditCreatTime) {
        this.creditCreatTime = creditCreatTime;
    }

    public Date getCreditUpdateTime() {
        return creditUpdateTime;
    }

    public void setCreditUpdateTime(Date creditUpdateTime) {
        this.creditUpdateTime = creditUpdateTime;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }
}