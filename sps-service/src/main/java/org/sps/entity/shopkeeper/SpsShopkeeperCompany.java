package org.sps.entity.shopkeeper;

import java.io.Serializable;
import java.util.Date;

public class SpsShopkeeperCompany implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer companyId;

    private String companyName;

    private String companyShopName;

    private String companyCorpName;

    private String companyBusinessProvinceName;

    private String companyBusinessProvinceCode;

    private String companyBusinessCityName;

    private String companyBusinessCityCode;

    private String companyBusinessAreaName;

    private String companyBusinessAreaCode;

    private String companyBusinessLng;

    private String companyBusinessLat;

    private String companyBusinessAddr;

    private String companyGpsAddr;

    private String companyBusinessAddrOwnership;

    private Integer companyOperatioTime;

    private Integer companyEmployeeNum;

    private Double companyBusinessArea;

    private String shopkeeperCustomerid;

    private String companyUsername;

    private Date companyCreatTime;

    private Date companyUpdateTime;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyShopName() {
        return companyShopName;
    }

    public void setCompanyShopName(String companyShopName) {
        this.companyShopName = companyShopName == null ? null : companyShopName.trim();
    }

    public String getCompanyCorpName() {
        return companyCorpName;
    }

    public void setCompanyCorpName(String companyCorpName) {
        this.companyCorpName = companyCorpName == null ? null : companyCorpName.trim();
    }

    public String getCompanyBusinessProvinceName() {
        return companyBusinessProvinceName;
    }

    public void setCompanyBusinessProvinceName(String companyBusinessProvinceName) {
        this.companyBusinessProvinceName = companyBusinessProvinceName == null ? null : companyBusinessProvinceName.trim();
    }

    public String getCompanyBusinessProvinceCode() {
        return companyBusinessProvinceCode;
    }

    public void setCompanyBusinessProvinceCode(String companyBusinessProvinceCode) {
        this.companyBusinessProvinceCode = companyBusinessProvinceCode == null ? null : companyBusinessProvinceCode.trim();
    }

    public String getCompanyBusinessCityName() {
        return companyBusinessCityName;
    }

    public void setCompanyBusinessCityName(String companyBusinessCityName) {
        this.companyBusinessCityName = companyBusinessCityName == null ? null : companyBusinessCityName.trim();
    }

    public String getCompanyBusinessCityCode() {
        return companyBusinessCityCode;
    }

    public void setCompanyBusinessCityCode(String companyBusinessCityCode) {
        this.companyBusinessCityCode = companyBusinessCityCode == null ? null : companyBusinessCityCode.trim();
    }

    public String getCompanyBusinessAreaName() {
        return companyBusinessAreaName;
    }

    public void setCompanyBusinessAreaName(String companyBusinessAreaName) {
        this.companyBusinessAreaName = companyBusinessAreaName == null ? null : companyBusinessAreaName.trim();
    }

    public String getCompanyBusinessAreaCode() {
        return companyBusinessAreaCode;
    }

    public void setCompanyBusinessAreaCode(String companyBusinessAreaCode) {
        this.companyBusinessAreaCode = companyBusinessAreaCode == null ? null : companyBusinessAreaCode.trim();
    }

    public String getCompanyBusinessLng() {
        return companyBusinessLng;
    }

    public void setCompanyBusinessLng(String companyBusinessLng) {
        this.companyBusinessLng = companyBusinessLng == null ? null : companyBusinessLng.trim();
    }

    public String getCompanyBusinessLat() {
        return companyBusinessLat;
    }

    public void setCompanyBusinessLat(String companyBusinessLat) {
        this.companyBusinessLat = companyBusinessLat == null ? null : companyBusinessLat.trim();
    }

    public String getCompanyBusinessAddr() {
        return companyBusinessAddr;
    }

    public void setCompanyBusinessAddr(String companyBusinessAddr) {
        this.companyBusinessAddr = companyBusinessAddr == null ? null : companyBusinessAddr.trim();
    }

    public String getCompanyGpsAddr() {
        return companyGpsAddr;
    }

    public void setCompanyGpsAddr(String companyGpsAddr) {
        this.companyGpsAddr = companyGpsAddr == null ? null : companyGpsAddr.trim();
    }

    public String getCompanyBusinessAddrOwnership() {
        return companyBusinessAddrOwnership;
    }

    public void setCompanyBusinessAddrOwnership(String companyBusinessAddrOwnership) {
        this.companyBusinessAddrOwnership = companyBusinessAddrOwnership == null ? null : companyBusinessAddrOwnership.trim();
    }

    public Integer getCompanyOperatioTime() {
        return companyOperatioTime;
    }

    public void setCompanyOperatioTime(Integer companyOperatioTime) {
        this.companyOperatioTime = companyOperatioTime;
    }

    public Integer getCompanyEmployeeNum() {
        return companyEmployeeNum;
    }

    public void setCompanyEmployeeNum(Integer companyEmployeeNum) {
        this.companyEmployeeNum = companyEmployeeNum;
    }

    public Double getCompanyBusinessArea() {
        return companyBusinessArea;
    }

    public void setCompanyBusinessArea(Double companyBusinessArea) {
        this.companyBusinessArea = companyBusinessArea;
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getCompanyUsername() {
        return companyUsername;
    }

    public void setCompanyUsername(String companyUsername) {
        this.companyUsername = companyUsername == null ? null : companyUsername.trim();
    }

    public Date getCompanyCreatTime() {
        return companyCreatTime;
    }

    public void setCompanyCreatTime(Date companyCreatTime) {
        this.companyCreatTime = companyCreatTime;
    }

    public Date getCompanyUpdateTime() {
        return companyUpdateTime;
    }

    public void setCompanyUpdateTime(Date companyUpdateTime) {
        this.companyUpdateTime = companyUpdateTime;
    }
}