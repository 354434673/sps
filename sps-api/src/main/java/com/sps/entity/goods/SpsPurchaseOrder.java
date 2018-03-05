package com.sps.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsPurchaseOrder implements Serializable {
    private Integer groundingFlag;
    private Integer platGoodsId;
    private String goodsName;
    private BigDecimal price;
    private String color;
    private Integer quantity;
    private Integer size;
    private String url;
    private Integer skuFlag;
    private Integer goodsFlag;
    private Integer stock;

    //分割线
    private Integer orderId;

    private Integer orderGoodsNum;

    private Integer orderSkuId;

    private Integer orderGoodsId;

    private String orderCustomerNum;

    private Integer orderDeleteFlag;

    private Date orderCreateTime;

    private Date orderUpdateTime;


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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
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