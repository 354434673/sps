package org.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易流水类
 * @author cailing
 *
 */
public class SpsChannelBankTrade implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3873446556082669316L;

	private Integer id;  				//	主键id
	//	交易用户名
	private String  tradeName ;
	//	交易序列号
	private String tradeSerialNum;
	//	交易人的身份证
	private String identity ;
	//	交易申请日期
	private Date applicationStartDate ;
	//	交易结束日期
	private Date  applicationStopDate ;
	//	交易审批通过日期
	private Date  auditDate ;
	//	到账日期
	private Date paymentDate ;
	//	交易类型  0 为支出，1 为收入
	private String tradeType ;
	//	收入类型
	private String incomeType ;
	//	支出类型
	private String expenditureType ;
	//	交易前余额
	private BigDecimal tradeBeforeBalanc ;
	//	交易后余额
	private BigDecimal tradeAfterBalanc ;
	//	交易金额
	private BigDecimal tradeAmount ;
	//	交易状态
	private String tradeStatus  ;
	//	交易用户sps_bank的id
	private String userId  ;
	//	备注信息 提现还是充值
	private String standby1;
	//	备注拒绝信息
	private String  standby2;
	//	核心传来的交易编号
	private String   tradeNo;
	//	订单编号
	private String   orderId;
	// 商品价格
	private  BigDecimal  goodsAmount;
	//每日服务费
	private  BigDecimal serviceMoney;
	//每日服务费总额
	private  BigDecimal  sumServiceMoney;
	//首付金额
	private  BigDecimal  firstMoney;
	//店付金额
	private  BigDecimal   shopPayMoney;
	//充值状态（0失败1成功2充值中）
	private  Integer   rechargeStatus;

	private SpsChannelBank cahnnelBank;
	private SpsChannel  channel;
	private SpsChannelEnterprise  enterprise;

	public Integer getRechargeStatus() {
		return rechargeStatus;
	}

	public void setRechargeStatus(Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public BigDecimal getServiceMoney() {
		return serviceMoney;
	}

	public void setServiceMoney(BigDecimal serviceMoney) {
		this.serviceMoney = serviceMoney;
	}

	public BigDecimal getSumServiceMoney() {
		return sumServiceMoney;
	}

	public void setSumServiceMoney(BigDecimal sumServiceMoney) {
		this.sumServiceMoney = sumServiceMoney;
	}

	public BigDecimal getFirstMoney() {
		return firstMoney;
	}

	public void setFirstMoney(BigDecimal firstMoney) {
		this.firstMoney = firstMoney;
	}

	public BigDecimal getShopPayMoney() {
		return shopPayMoney;
	}

	public void setShopPayMoney(BigDecimal shopPayMoney) {
		this.shopPayMoney = shopPayMoney;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStandby2() {
		return standby2;
	}

	public void setStandby2(String standby2) {
		this.standby2 = standby2;
	}

	public SpsChannelEnterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(SpsChannelEnterprise enterprise) {
		this.enterprise = enterprise;
	}

	/**
	 * @return the channel
	 */
	public SpsChannel getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(SpsChannel channel) {
		this.channel = channel;
	}
	public SpsChannelBank getCahnnelBank() {
		return cahnnelBank;
	}
	public void setCahnnelBank(SpsChannelBank cahnnelBank) {
		this.cahnnelBank = cahnnelBank;
	}
	public String getStandby1() {
		return standby1;
	}
	public void setStandby1(String standby1) {
		this.standby1 = standby1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getTradeSerialNum() {
		return tradeSerialNum;
	}
	public void setTradeSerialNum(String tradeSerialNum) {
		this.tradeSerialNum = tradeSerialNum;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Date getApplicationStartDate() {
		return applicationStartDate;
	}

	public void setApplicationStartDate(Date applicationStartDate) {
		this.applicationStartDate = applicationStartDate;
	}

	public Date getApplicationStopDate() {
		return applicationStopDate;
	}

	public void setApplicationStopDate(Date applicationStopDate) {
		this.applicationStopDate = applicationStopDate;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getExpenditureType() {
		return expenditureType;
	}
	public void setExpenditureType(String expenditureType) {
		this.expenditureType = expenditureType;
	}
	public BigDecimal getTradeBeforeBalanc() {
		return tradeBeforeBalanc;
	}
	public void setTradeBeforeBalanc(BigDecimal tradeBeforeBalanc) {
		this.tradeBeforeBalanc = tradeBeforeBalanc;
	}
	public BigDecimal getTradeAfterBalanc() {
		return tradeAfterBalanc;
	}
	public void setTradeAfterBalanc(BigDecimal tradeAfterBalanc) {
		this.tradeAfterBalanc = tradeAfterBalanc;
	}
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
