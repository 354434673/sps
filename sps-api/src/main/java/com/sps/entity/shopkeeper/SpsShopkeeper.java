package com.sps.entity.shopkeeper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsShopkeeper implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;


    private BigDecimal shopPayMoney;

	private Integer shopkeeperId;

    private String shopkeeperCity;

    private String shopkeeperCustomerid;

    private String shopkeeperApproveType;

    private String shopkeeperApproveNo;

    private String shopkeeperProduct;

    private String shopkeeperRegisterSource;

    private String shopkeeperClientSource;

    private String shopkeeperChannelType;

    private String shopkeeperDefaultChannelNum;

    private String shopkeeperDefaultChannelName;

    private String shopkeeperSalesmanName;

    private String shopkeeperSalesmanIdcard;

    private String shopkeeperCommodityType;

    private String shopkeeperBusinessModel;

    private String shopkeeperBrand;

    private String shopkeeperBusinessType;

    private Integer shopkeeperState;

    private String shopkeeperReferrer;

    private String shopkeeperUsername;

    private Date shopkeeperCreatTime;

    private Date shopkeeperUpdateTime;


    public BigDecimal getShopPayMoney() {
        return shopPayMoney;
    }

    public void setShopPayMoney(BigDecimal shopPayMoney) {
        this.shopPayMoney = shopPayMoney;
    }

    public Integer getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(Integer shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
    }

    public String getShopkeeperCity() {
        return shopkeeperCity;
    }

    public void setShopkeeperCity(String shopkeeperCity) {
        this.shopkeeperCity = shopkeeperCity == null ? null : shopkeeperCity.trim();
    }

    public String getShopkeeperCustomerid() {
        return shopkeeperCustomerid;
    }

    public void setShopkeeperCustomerid(String shopkeeperCustomerid) {
        this.shopkeeperCustomerid = shopkeeperCustomerid == null ? null : shopkeeperCustomerid.trim();
    }

    public String getShopkeeperApproveType() {
        return shopkeeperApproveType;
    }

    public void setShopkeeperApproveType(String shopkeeperApproveType) {
        this.shopkeeperApproveType = shopkeeperApproveType == null ? null : shopkeeperApproveType.trim();
    }

    public String getShopkeeperApproveNo() {
        return shopkeeperApproveNo;
    }

    public void setShopkeeperApproveNo(String shopkeeperApproveNo) {
        this.shopkeeperApproveNo = shopkeeperApproveNo == null ? null : shopkeeperApproveNo.trim();
    }

    public String getShopkeeperProduct() {
        return shopkeeperProduct;
    }

    public void setShopkeeperProduct(String shopkeeperProduct) {
        this.shopkeeperProduct = shopkeeperProduct == null ? null : shopkeeperProduct.trim();
    }

    public String getShopkeeperRegisterSource() {
        return shopkeeperRegisterSource;
    }

    public void setShopkeeperRegisterSource(String shopkeeperRegisterSource) {
        this.shopkeeperRegisterSource = shopkeeperRegisterSource == null ? null : shopkeeperRegisterSource.trim();
    }

    public String getShopkeeperClientSource() {
        return shopkeeperClientSource;
    }

    public void setShopkeeperClientSource(String shopkeeperClientSource) {
        this.shopkeeperClientSource = shopkeeperClientSource == null ? null : shopkeeperClientSource.trim();
    }

    public String getShopkeeperChannelType() {
        return shopkeeperChannelType;
    }

    public void setShopkeeperChannelType(String shopkeeperChannelType) {
        this.shopkeeperChannelType = shopkeeperChannelType == null ? null : shopkeeperChannelType.trim();
    }

    public String getShopkeeperDefaultChannelNum() {
        return shopkeeperDefaultChannelNum;
    }

    public void setShopkeeperDefaultChannelNum(String shopkeeperDefaultChannelNum) {
        this.shopkeeperDefaultChannelNum = shopkeeperDefaultChannelNum == null ? null : shopkeeperDefaultChannelNum.trim();
    }

    public String getShopkeeperDefaultChannelName() {
        return shopkeeperDefaultChannelName;
    }

    public void setShopkeeperDefaultChannelName(String shopkeeperDefaultChannelName) {
        this.shopkeeperDefaultChannelName = shopkeeperDefaultChannelName == null ? null : shopkeeperDefaultChannelName.trim();
    }

    public String getShopkeeperSalesmanName() {
        return shopkeeperSalesmanName;
    }

    public void setShopkeeperSalesmanName(String shopkeeperSalesmanName) {
        this.shopkeeperSalesmanName = shopkeeperSalesmanName == null ? null : shopkeeperSalesmanName.trim();
    }

    public String getShopkeeperSalesmanIdcard() {
        return shopkeeperSalesmanIdcard;
    }

    public void setShopkeeperSalesmanIdcard(String shopkeeperSalesmanIdcard) {
        this.shopkeeperSalesmanIdcard = shopkeeperSalesmanIdcard == null ? null : shopkeeperSalesmanIdcard.trim();
    }

    public String getShopkeeperCommodityType() {
        return shopkeeperCommodityType;
    }

    public void setShopkeeperCommodityType(String shopkeeperCommodityType) {
        this.shopkeeperCommodityType = shopkeeperCommodityType == null ? null : shopkeeperCommodityType.trim();
    }

    public String getShopkeeperBusinessModel() {
        return shopkeeperBusinessModel;
    }

    public void setShopkeeperBusinessModel(String shopkeeperBusinessModel) {
        this.shopkeeperBusinessModel = shopkeeperBusinessModel == null ? null : shopkeeperBusinessModel.trim();
    }

    public String getShopkeeperBrand() {
        return shopkeeperBrand;
    }

    public void setShopkeeperBrand(String shopkeeperBrand) {
        this.shopkeeperBrand = shopkeeperBrand == null ? null : shopkeeperBrand.trim();
    }

    public String getShopkeeperBusinessType() {
        return shopkeeperBusinessType;
    }

    public void setShopkeeperBusinessType(String shopkeeperBusinessType) {
        this.shopkeeperBusinessType = shopkeeperBusinessType == null ? null : shopkeeperBusinessType.trim();
    }

    public Integer getShopkeeperState() {
        return shopkeeperState;
    }

    public void setShopkeeperState(Integer shopkeeperState) {
        this.shopkeeperState = shopkeeperState;
    }

    public String getShopkeeperReferrer() {
        return shopkeeperReferrer;
    }

    public void setShopkeeperReferrer(String shopkeeperReferrer) {
        this.shopkeeperReferrer = shopkeeperReferrer == null ? null : shopkeeperReferrer.trim();
    }

    public String getShopkeeperUsername() {
        return shopkeeperUsername;
    }

    public void setShopkeeperUsername(String shopkeeperUsername) {
        this.shopkeeperUsername = shopkeeperUsername == null ? null : shopkeeperUsername.trim();
    }

    public Date getShopkeeperCreatTime() {
        return shopkeeperCreatTime;
    }

    public void setShopkeeperCreatTime(Date shopkeeperCreatTime) {
        this.shopkeeperCreatTime = shopkeeperCreatTime;
    }

    public Date getShopkeeperUpdateTime() {
        return shopkeeperUpdateTime;
    }

    public void setShopkeeperUpdateTime(Date shopkeeperUpdateTime) {
        this.shopkeeperUpdateTime = shopkeeperUpdateTime;
    }
    
}