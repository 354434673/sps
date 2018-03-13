package org.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-03-05.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public class OrderRepayDetail implements Serializable {
    private Integer id;
//    订单编号
    private String  orderNo;
//    还款日期
    private String  repayDate;
//    还本金金额
    private BigDecimal repayBenAmount;
//    还利息金额
    private BigDecimal  repayAccrualAmount;
//    还逾期手续费金额
    private BigDecimal  rapayPoundage;
//   剩余未还本金
    private BigDecimal  noRepayBenAmount;

//   剩余未还利息
    private BigDecimal  noReapayAccrualAmount;
//   剩余未还利息
    private BigDecimal  noRepayPoundage;
    private BigDecimal repayAmount;

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayBenAmount() {
        return repayBenAmount;
    }

    public void setRepayBenAmount(BigDecimal repayBenAmount) {
        this.repayBenAmount = repayBenAmount;
    }

    public BigDecimal getRepayAccrualAmount() {
        return repayAccrualAmount;
    }

    public void setRepayAccrualAmount(BigDecimal repayAccrualAmount) {
        this.repayAccrualAmount = repayAccrualAmount;
    }

    public BigDecimal getRapayPoundage() {
        return rapayPoundage;
    }

    public void setRapayPoundage(BigDecimal rapayPoundage) {
        this.rapayPoundage = rapayPoundage;
    }

    public BigDecimal getNoRepayBenAmount() {
        return noRepayBenAmount;
    }

    public void setNoRepayBenAmount(BigDecimal noRepayBenAmount) {
        this.noRepayBenAmount = noRepayBenAmount;
    }

    public BigDecimal getNoReapayAccrualAmount() {
        return noReapayAccrualAmount;
    }

    public void setNoReapayAccrualAmount(BigDecimal noReapayAccrualAmount) {
        this.noReapayAccrualAmount = noReapayAccrualAmount;
    }

    public BigDecimal getNoRepayPoundage() {
        return noRepayPoundage;
    }

    public void setNoRepayPoundage(BigDecimal noRepayPoundage) {
        this.noRepayPoundage = noRepayPoundage;
    }
}
