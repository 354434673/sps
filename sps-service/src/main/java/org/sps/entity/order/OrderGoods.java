package org.sps.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderGoods implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.o_id
     *
     * @mbggenerated
     */
    private Integer oId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.orderid
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.sku
     *
     * @mbggenerated
     */
    private String sku;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.skuname
     *
     * @mbggenerated
     */
    private String skuname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.color
     *
     * @mbggenerated
     */
    private String color;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.memory
     *
     * @mbggenerated
     */
    private String memory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.amount
     *
     * @mbggenerated
     */
    private Integer amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.summation
     *
     * @mbggenerated
     */
    private Double summation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.pre_price
     *
     * @mbggenerated
     */
    private BigDecimal prePrice;
    private Integer preAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sps_order_goods.modifytime
     *
     * @mbggenerated
     */
    private Date modifytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.o_id
     *
     * @return the value of sps_order_goods.o_id
     *
     * @mbggenerated
     */
    public Integer getoId() {
        return oId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.o_id
     *
     * @param oId the value for sps_order_goods.o_id
     *
     * @mbggenerated
     */
    public void setoId(Integer oId) {
        this.oId = oId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.orderid
     *
     * @return the value of sps_order_goods.orderid
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.orderid
     *
     * @param orderid the value for sps_order_goods.orderid
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.sku
     *
     * @return the value of sps_order_goods.sku
     *
     * @mbggenerated
     */
    public String getSku() {
        return sku;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.sku
     *
     * @param sku the value for sps_order_goods.sku
     *
     * @mbggenerated
     */
    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.skuname
     *
     * @return the value of sps_order_goods.skuname
     *
     * @mbggenerated
     */
    public String getSkuname() {
        return skuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.skuname
     *
     * @param skuname the value for sps_order_goods.skuname
     *
     * @mbggenerated
     */
    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.color
     *
     * @return the value of sps_order_goods.color
     *
     * @mbggenerated
     */
    public String getColor() {
        return color;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.color
     *
     * @param color the value for sps_order_goods.color
     *
     * @mbggenerated
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.memory
     *
     * @return the value of sps_order_goods.memory
     *
     * @mbggenerated
     */
    public String getMemory() {
        return memory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.memory
     *
     * @param memory the value for sps_order_goods.memory
     *
     * @mbggenerated
     */
    public void setMemory(String memory) {
        this.memory = memory == null ? null : memory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.price
     *
     * @return the value of sps_order_goods.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.price
     *
     * @param price the value for sps_order_goods.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.amount
     *
     * @return the value of sps_order_goods.amount
     *
     * @mbggenerated
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.amount
     *
     * @param amount the value for sps_order_goods.amount
     *
     * @mbggenerated
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.summation
     *
     * @return the value of sps_order_goods.summation
     *
     * @mbggenerated
     */
    public Double getSummation() {
        return summation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.summation
     *
     * @param summation the value for sps_order_goods.summation
     *
     * @mbggenerated
     */
    public void setSummation(Double summation) {
        this.summation = summation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.pre_price
     *
     * @return the value of sps_order_goods.pre_price
     *
     * @mbggenerated
     */
    public BigDecimal getPrePrice() {
        return prePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.pre_price
     *
     * @param prePrice the value for sps_order_goods.pre_price
     *
     * @mbggenerated
     */
    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sps_order_goods.modifytime
     *
     * @return the value of sps_order_goods.modifytime
     *
     * @mbggenerated
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sps_order_goods.modifytime
     *
     * @param modifytime the value for sps_order_goods.modifytime
     *
     * @mbggenerated
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getPreAmount() {
		return preAmount;
	}

	public void setPreAmount(Integer preAmount) {
		this.preAmount = preAmount;
	}

	public OrderGoods() {
		super();
	}

	public OrderGoods(Integer oId, String orderid, String sku, String skuname, String color, String memory,
			BigDecimal price, Integer amount, Double summation, BigDecimal prePrice, Integer preAmount,
			Date modifytime) {
		super();
		this.oId = oId;
		this.orderid = orderid;
		this.sku = sku;
		this.skuname = skuname;
		this.color = color;
		this.memory = memory;
		this.price = price;
		this.amount = amount;
		this.summation = summation;
		this.prePrice = prePrice;
		this.preAmount = preAmount;
		this.modifytime = modifytime;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderGoods other = (OrderGoods) that;
        return (this.getoId() == null ? other.getoId() == null : this.getoId().equals(other.getoId()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getSku() == null ? other.getSku() == null : this.getSku().equals(other.getSku()))
            && (this.getSkuname() == null ? other.getSkuname() == null : this.getSkuname().equals(other.getSkuname()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getMemory() == null ? other.getMemory() == null : this.getMemory().equals(other.getMemory()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getSummation() == null ? other.getSummation() == null : this.getSummation().equals(other.getSummation()))
            && (this.getPrePrice() == null ? other.getPrePrice() == null : this.getPrePrice().equals(other.getPrePrice()))
            && (this.getModifytime() == null ? other.getModifytime() == null : this.getModifytime().equals(other.getModifytime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getoId() == null) ? 0 : getoId().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getSku() == null) ? 0 : getSku().hashCode());
        result = prime * result + ((getSkuname() == null) ? 0 : getSkuname().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getMemory() == null) ? 0 : getMemory().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getSummation() == null) ? 0 : getSummation().hashCode());
        result = prime * result + ((getPrePrice() == null) ? 0 : getPrePrice().hashCode());
        result = prime * result + ((getModifytime() == null) ? 0 : getModifytime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oId=").append(oId);
        sb.append(", orderid=").append(orderid);
        sb.append(", sku=").append(sku);
        sb.append(", skuname=").append(skuname);
        sb.append(", color=").append(color);
        sb.append(", memory=").append(memory);
        sb.append(", price=").append(price);
        sb.append(", amount=").append(amount);
        sb.append(", summation=").append(summation);
        sb.append(", prePrice=").append(prePrice);
        sb.append(", modifytime=").append(modifytime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}