package com.sps.entity.account;

import java.io.Serializable;
import java.util.Date;

public class BindBankTrans implements Serializable{
	private static final long serialVersionUID = 1L;
	private  Integer id;   
	private String name ;     // 用户名
	private String bankName;  //开户行
	private String userId;    //用户ID
	private String loginName; //等登录名
	private String identity ; //身份证号
	private String phone;     //手机号
	private String merchantNo;//商户编号
	private Date   startTime ;   //开始时间
	private Date   stopTime ;   //结束时间
	private String authType;   //认证类型
	private String serialSh;  //请求号
	private String serialYop;  //易宝账号
	private String bankCode;  //银行编号
	private String state  ; //状态
	private String remark;  //备注信息
	private String  channlNum;  //平台商户编号
	private String  cardlast;   //卡的后4位
	private String  cardcardtop; //卡的 前6位


	public String getCardlast() {
		return cardlast;
	}

	public void setCardlast(String cardlast) {
		this.cardlast = cardlast;
	}

	public String getCardcardtop() {
		return cardcardtop;
	}

	public void setCardcardtop(String cardcardtop) {
		this.cardcardtop = cardcardtop;
	}

	public String getChannlNum() {
		return channlNum;
	}
	public void setChannlNum(String channlNum) {
		this.channlNum = channlNum;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSerialSh() {
		return serialSh;
	}
	public void setSerialSh(String serialSh) {
		this.serialSh = serialSh;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getSerialYop() {
		return serialYop;
	}
	public void setSerialYop(String serialYop) {
		this.serialYop = serialYop;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
}
