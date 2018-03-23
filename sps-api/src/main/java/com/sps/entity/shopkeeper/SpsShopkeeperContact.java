package com.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperContact implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer contactId;

    private String contactName;

    private String contactRelation;

    private String contactPhone;

    private String shopkeeperCustomerid;

    private String contactUsername;

    private Date contactCreatTime;

    private Date contactUpdateTime;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactRelation() {
        return contactRelation;
    }

    public void setContactRelation(String contactRelation) {
        this.contactRelation = contactRelation == null ? null : contactRelation.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getContactUsername() {
        return contactUsername;
    }

    public void setContactUsername(String contactUsername) {
        this.contactUsername = contactUsername == null ? null : contactUsername.trim();
    }

    public Date getContactCreatTime() {
        return contactCreatTime;
    }

    public void setContactCreatTime(Date contactCreatTime) {
        this.contactCreatTime = contactCreatTime;
    }

    public Date getContactUpdateTime() {
        return contactUpdateTime;
    }

    public void setContactUpdateTime(Date contactUpdateTime) {
        this.contactUpdateTime = contactUpdateTime;
    }
}