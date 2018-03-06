package com.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SpsOrderGoods implements Serializable {
    private Integer oId;

    private String orderid;

    private String sku;

    private String skuname;

    private String color;

    private String memory;

    private BigDecimal price;

    private Integer amount;

    private Double summation;

    private BigDecimal prePrice;

    private Date modifytime;

    private Integer preAmount;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory == null ? null : memory.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSummation() {
        return summation;
    }

    public void setSummation(Double summation) {
        this.summation = summation;
    }

    public BigDecimal getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getPreAmount() {
        return preAmount;
    }

    public void setPreAmount(Integer preAmount) {
        this.preAmount = preAmount;
    }
}