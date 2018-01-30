package org.sps.entity.shopkeeper;

import java.util.Date;

public class SpsShopkeeperPic {
    private Integer picId;

    private String picSrc;

    private Integer picType;

    private Date picUploadTime;

    private String picOldName;

    private String picNewName;

    private Integer picState;

    private Date picCreatTime;

    private Date picUpdateTime;

    private String shopkeeperCustomerid;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public Date getPicUploadTime() {
        return picUploadTime;
    }

    public void setPicUploadTime(Date picUploadTime) {
        this.picUploadTime = picUploadTime;
    }

    public String getPicOldName() {
        return picOldName;
    }

    public void setPicOldName(String picOldName) {
        this.picOldName = picOldName == null ? null : picOldName.trim();
    }

    public String getPicNewName() {
        return picNewName;
    }

    public void setPicNewName(String picNewName) {
        this.picNewName = picNewName == null ? null : picNewName.trim();
    }

    public Integer getPicState() {
        return picState;
    }

    public void setPicState(Integer picState) {
        this.picState = picState;
    }

    public Date getPicCreatTime() {
        return picCreatTime;
    }

    public void setPicCreatTime(Date picCreatTime) {
        this.picCreatTime = picCreatTime;
    }

    public Date getPicUpdateTime() {
        return picUpdateTime;
    }

    public void setPicUpdateTime(Date picUpdateTime) {
        this.picUpdateTime = picUpdateTime;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }
}