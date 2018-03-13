package org.sps.entity.finance;

import org.sps.entity.order.OrderGoodsVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
// * Created by cailing on 2018/3/4.
// */
public class OrderDetail implements Serializable{


/**
 *  物流信息
  */
//   物流名称
    private String wuliuName;
//    物流编号
    private String wuOderNo;
    /**
     * 订单基本信息
     */
//    表id
    private Integer oId;
//    订单编号
    private String orderid;
//    核心商户账号
    private String shopkeeper;
//    核心商户名称
    private String shopkeepername;
//    小B账号
    private String selfemployed;
//    店铺名称
    private String selfname;
//    首付比例
    private Integer scale;
//    创建时间
    private Date createtime;
//    订单状态\r\n1:待确认：订单提交后待核心商户确认\r\n2:已拒绝：核心商户拒绝订单\r\n3:运营审核中：订单在风控审核中\r\n4:运营审核不通过：订单在风控审核不通过\r\n5:待支付：风控审核通过，待店主支付\r\n6:待发货：店主签约成功，待核心商户发货\r\n7:发货审核中：核心商户发货，风控审核物流信息中（规则配置中需要审核则展示）\r\n8:发货审核不通过：风控审核物流信息不通过（规则配置中需要审核则展示）\r\n9:已放款：核心系统放款\r\n10:已退货：订单退货退款成功\r\n11:待还款\r\n12已结清',
    private Integer flag;
//    首付金额（订单金额*首付比例）
    private BigDecimal payment;
//    是否删除
    private Integer isdelete;
//
    private String remark;
//    店付金额
    private BigDecimal payMoney;
//订单金额（店付金额+首付金额）
    private BigDecimal money;
//    服务费率
    private Double servicescale;
//    服务费（订单金额*服务费率）
    private BigDecimal servicemoney;
//    店主电话
    private String phone;
//    收货地址
    private String address;
//   修改时间
    private Date modifytime;
//    实销金额(订单金额-代销服务费)
    private BigDecimal sumMoney;
//    店主
    private String name;
//    单位
    private String unit;
//    借据编号
    private String loanCode;
//    借款开始时间
    private String loanStartTime;
//    借款结束时间
    private String loanEndTime;
//    手续费率
    private Double formalityRate;
//    手续费
    private BigDecimal serviceCharge;
//    借款余额
    private BigDecimal loanBalance;

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
        this.orderid = orderid;
    }

    public String getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(String shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public String getShopkeepername() {
        return shopkeepername;
    }

    public void setShopkeepername(String shopkeepername) {
        this.shopkeepername = shopkeepername;
    }

    public String getSelfemployed() {
        return selfemployed;
    }

    public void setSelfemployed(String selfemployed) {
        this.selfemployed = selfemployed;
    }

    public String getSelfname() {
        return selfname;
    }

    public void setSelfname(String selfname) {
        this.selfname = selfname;
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
        this.remark = remark;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Double getServicescale() {
        return servicescale;
    }

    public void setServicescale(Double servicescale) {
        this.servicescale = servicescale;
    }

    public BigDecimal getServicemoney() {
        return servicemoney;
    }

    public void setServicemoney(BigDecimal servicemoney) {
        this.servicemoney = servicemoney;
    }

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

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getLoanStartTime() {
        return loanStartTime;
    }

    public void setLoanStartTime(String loanStartTime) {
        this.loanStartTime = loanStartTime;
    }

    public String getLoanEndTime() {
        return loanEndTime;
    }

    public void setLoanEndTime(String loanEndTime) {
        this.loanEndTime = loanEndTime;
    }

    public Double getFormalityRate() {
        return formalityRate;
    }

    public void setFormalityRate(Double formalityRate) {
        this.formalityRate = formalityRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }
}
