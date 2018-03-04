package org.sps.entity.finance;

import org.sps.entity.order.OrderGoodsVo;

import java.math.BigDecimal;
import java.util.Date;

/**
// * Created by cailing on 2018/3/4.
// */
public class OrderDetail {
    private Integer id;
    private Date  createDate;
    private Date  confirm;
    private Date  payDate;
    private Date  faHuoDate;
    private Date tuiHuoDate;
//    物流信息
    private String wuliuName;
    private String wuOderNo;
//    基本信息
    private String orderNo;
    private BigDecimal amount;
    private Double  servicePer;
    private BigDecimal serviceAmount;
    private String unit;
    private Date applicationDate;
    private String companyName;
    private String phone;
    private String addr;
    private String orderRemark;
//    订单项
    private OrderGoodsVo orderGoodsVo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getConfirm() {
        return confirm;
    }

    public void setConfirm(Date confirm) {
        this.confirm = confirm;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getFaHuoDate() {
        return faHuoDate;
    }

    public void setFaHuoDate(Date faHuoDate) {
        this.faHuoDate = faHuoDate;
    }

    public Date getTuiHuoDate() {
        return tuiHuoDate;
    }

    public void setTuiHuoDate(Date tuiHuoDate) {
        this.tuiHuoDate = tuiHuoDate;
    }

    public String getWuliuName() {
        return wuliuName;
    }

    public void setWuliuName(String wuliuName) {
        this.wuliuName = wuliuName;
    }

    public String getWuOderNo() {
        return wuOderNo;
    }

    public void setWuOderNo(String wuOderNo) {
        this.wuOderNo = wuOderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Double getServicePer() {
        return servicePer;
    }

    public void setServicePer(Double servicePer) {
        this.servicePer = servicePer;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public OrderGoodsVo getOrderGoodsVo() {
        return orderGoodsVo;
    }

    public void setOrderGoodsVo(OrderGoodsVo orderGoodsVo) {
        this.orderGoodsVo = orderGoodsVo;
    }
}
