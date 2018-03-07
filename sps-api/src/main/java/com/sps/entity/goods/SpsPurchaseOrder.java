package com.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsPurchaseOrder implements Serializable {


    //订单所需
    private BigDecimal payment;
    private BigDecimal money;
    private BigDecimal serviceMoney;
    private BigDecimal shopPayMoney;
    private Integer scale;
    private String selfName;
    private String phone;
    private String address;
    private String unit;
    private String name;
    private String remark;





    private String customerId;
    private Integer groundingFlag;
    private Integer platGoodsId;
    private String goodsName;
    private BigDecimal price;
    private String color;
    private Integer quantity;
    private String size;
    private String url;
    private Integer skuFlag;
    private Integer goodsFlag;
    private Integer stock;
    private BigDecimal totalPrice;

    //分割线
    private Integer orderId;

    private Integer orderGoodsNum;

    private Integer orderSkuId;

    private Integer orderGoodsId;

    private String orderCustomerNum;

    private Integer orderDeleteFlag;

    private Date orderCreateTime;

    private Date orderUpdateTime;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getShopPayMoney() {
        return shopPayMoney;
    }

    public void setShopPayMoney(BigDecimal shopPayMoney) {
        this.shopPayMoney = shopPayMoney;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGroundingFlag() {
        return groundingFlag;
    }

    public void setGroundingFlag(Integer groundingFlag) {
        this.groundingFlag = groundingFlag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSkuFlag() {
        return skuFlag;
    }

    public void setSkuFlag(Integer skuFlag) {
        this.skuFlag = skuFlag;
    }

    public Integer getGoodsFlag() {
        return goodsFlag;
    }

    public void setGoodsFlag(Integer goodsFlag) {
        this.goodsFlag = goodsFlag;
    }

    public Integer getPlatGoodsId() {
        return platGoodsId;
    }

    public void setPlatGoodsId(Integer platGoodsId) {
        this.platGoodsId = platGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderGoodsNum() {
        return orderGoodsNum;
    }

    public void setOrderGoodsNum(Integer orderGoodsNum) {
        this.orderGoodsNum = orderGoodsNum;
    }

    public Integer getOrderSkuId() {
        return orderSkuId;
    }

    public void setOrderSkuId(Integer orderSkuId) {
        this.orderSkuId = orderSkuId;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String getOrderCustomerNum() {
        return orderCustomerNum;
    }

    public void setOrderCustomerNum(String orderCustomerNum) {
        this.orderCustomerNum = orderCustomerNum == null ? null : orderCustomerNum.trim();
    }

    public Integer getOrderDeleteFlag() {
        return orderDeleteFlag;
    }

    public void setOrderDeleteFlag(Integer orderDeleteFlag) {
        this.orderDeleteFlag = orderDeleteFlag;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }
}