package com.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperHouseProperty implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer houseId;

    private Integer houseIsHave;

    private Double houseArea;

    private  String  houseProvinceName;

    private  String  houseProvinceCode;

    private  String  houseCityName;

    private  String  houseCityCode;

    private  String  houseAreaName;

    private  String   houseAreaCode;

    private String houseAddr;

    private String shopkeeperCustomerid;

    private String houseUsername;

    private Date houseCreatTime;

    private Date houseUpdateTime;

    public String getHouseProvinceName() {
        return houseProvinceName;
    }

    public void setHouseProvinceName(String houseProvinceName) {
        this.houseProvinceName = houseProvinceName;
    }

    public String getHouseProvinceCode() {
        return houseProvinceCode;
    }

    public void setHouseProvinceCode(String houseProvinceCode) {
        this.houseProvinceCode = houseProvinceCode;
    }

    public String getHouseCityName() {
        return houseCityName;
    }

    public void setHouseCityName(String houseCityName) {
        this.houseCityName = houseCityName;
    }

    public String getHouseCityCode() {
        return houseCityCode;
    }

    public void setHouseCityCode(String houseCityCode) {
        this.houseCityCode = houseCityCode;
    }

    public String getHouseAreaName() {
        return houseAreaName;
    }

    public void setHouseAreaName(String houseAreaName) {
        this.houseAreaName = houseAreaName;
    }

    public String getHouseAreaCode() {
        return houseAreaCode;
    }

    public void setHouseAreaCode(String houseAreaCode) {
        this.houseAreaCode = houseAreaCode;
    }



    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseIsHave() {
        return houseIsHave;
    }

    public void setHouseIsHave(Integer houseIsHave) {
        this.houseIsHave = houseIsHave;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getHouseUsername() {
        return houseUsername;
    }

    public void setHouseUsername(String houseUsername) {
        this.houseUsername = houseUsername == null ? null : houseUsername.trim();
    }

    public Date getHouseCreatTime() {
        return houseCreatTime;
    }

    public void setHouseCreatTime(Date houseCreatTime) {
        this.houseCreatTime = houseCreatTime;
    }

    public Date getHouseUpdateTime() {
        return houseUpdateTime;
    }

    public void setHouseUpdateTime(Date houseUpdateTime) {
        this.houseUpdateTime = houseUpdateTime;
    }
}