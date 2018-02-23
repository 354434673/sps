package org.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private String applicationStartDate ;
//	交易结束日期
	private String applicationStopDate ;
//	交易审批通过日期
	private String auditDate ;
//	到账日期
	private String paymentDate ;
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
	private String userid  ;
//	备注信息
	private String standby1;
	
	private SpsChannelBank cahnnelBank;
	private SpsChannel  channel;

	@Override
	public String toString() {
		return "SpsChannelBankTrade{" +
				"id=" + id +
				", tradeName='" + tradeName + '\'' +
				", tradeSerialNum='" + tradeSerialNum + '\'' +
				", identity='" + identity + '\'' +
				", applicationStartDate='" + applicationStartDate + '\'' +
				", applicationStopDate='" + applicationStopDate + '\'' +
				", auditDate='" + auditDate + '\'' +
				", paymentDate='" + paymentDate + '\'' +
				", tradeType='" + tradeType + '\'' +
				", incomeType='" + incomeType + '\'' +
				", expenditureType='" + expenditureType + '\'' +
				", tradeBeforeBalanc=" + tradeBeforeBalanc +
				", tradeAfterBalanc=" + tradeAfterBalanc +
				", tradeAmount=" + tradeAmount +
				", tradeStatus='" + tradeStatus + '\'' +
				", userid='" + userid + '\'' +
				", standby1='" + standby1 + '\'' +
				", cahnnelBank=" + cahnnelBank +
				", channel=" + channel +
				'}';
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

	/**
	 * @return the applicationStartDate
	 */
	public String getApplicationStartDate() {
		return applicationStartDate;
	}
	/**
	 * @param applicationStartDate the applicationStartDate to set
	 */
	public void setApplicationStartDate(String applicationStartDate) {
		this.applicationStartDate = applicationStartDate;
	}
	/**
	 * @return the applicationStopDate
	 */
	public String getApplicationStopDate() {
		return applicationStopDate;
	}
	/**
	 * @param applicationStopDate the applicationStopDate to set
	 */
	public void setApplicationStopDate(String applicationStopDate) {
		this.applicationStopDate = applicationStopDate;
	}
	/**
	 * @return the auditDate
	 */
	public String getAuditDate() {
		return auditDate;
	}
	/**
	 * @param auditDate the auditDate to set
	 */
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	

}
