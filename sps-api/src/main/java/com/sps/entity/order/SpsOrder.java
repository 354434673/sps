package com.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SpsOrder implements Serializable {

    private String customerId;

    private BigDecimal shopPayMoney;

    private Integer oId;

    private String orderid;

    private String shopkeeper;

    private String shopkeepername;

    private String selfemployed;

    private String selfname;

    private Integer scale;

    private Date createtime;

    private Integer flag;

    private BigDecimal payment;

    private Integer isdelete;

    private String remark;

    private Double money;

    private Double servicescale;

    private Double servicemoney;

    private String phone;

    private String address;

    private Date modifytime;

    private BigDecimal sumMoney;

    private String name;

    private String unit;

    private List<SpsOrderGoods>  orderGoodsList;


    public List<SpsOrderGoods> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<SpsOrderGoods> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public BigDecimal getShopPayMoney() {
        return shopPayMoney;
    }

    public void setShopPayMoney(BigDecimal shopPayMoney) {
        this.shopPayMoney = shopPayMoney;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public String getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(String shopkeeper) {
        this.shopkeeper = shopkeeper == null ? null : shopkeeper.trim();
    }

    public String getShopkeepername() {
        return shopkeepername;
    }

    public void setShopkeepername(String shopkeepername) {
        this.shopkeepername = shopkeepername == null ? null : shopkeepername.trim();
    }

    public String getSelfemployed() {
        return selfemployed;
    }

    public void setSelfemployed(String selfemployed) {
        this.selfemployed = selfemployed == null ? null : selfemployed.trim();
    }

    public String getSelfname() {
        return selfname;
    }

    public void setSelfname(String selfname) {
        this.selfname = selfname == null ? null : selfname.trim();
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }



    public Double getServicescale() {
        return servicescale;
    }

    public void setServicescale(Double servicescale) {
        this.servicescale = servicescale;
    }

    public Double getServicemoney() {
        return servicemoney;
    }

    public void setServicemoney(Double servicemoney) {
        this.servicemoney = servicemoney;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}