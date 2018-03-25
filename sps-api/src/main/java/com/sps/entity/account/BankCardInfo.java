package com.sps.entity.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BankCardInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
//	主键id
	private  Integer id;
//	账户名
	private String name ;
//	银行账号
	private String accounts ;
//	身份证
	private String identity ;
//	预留手机号
	private String phone;
//	创建时间
	private Date createtime ;
//	更新时间
	private Date  updatetime ;
//	开户行
	private String bank;
//	卡的状态  0，绑卡，1解绑
	private Integer state;
//	备注信息
	private String remark ;
	private String salt;
//	用户id
	private String userId;
//	当前登录用户名
	private String userName;
//	平台商户编号
	private String channlNum ;
//	当前可用金额
	private BigDecimal   availableBalance;
//	交易密码
	private String  transPassword   ;
//	随机盐
	private String standby2;
//	用户标识
	private Integer userMark;
//	删除标记 0 为有效，1 为删除
	private  Integer flag;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getUserMark() {
		return userMark;
	}

	public void setUserMark(Integer userMark) {
		this.userMark = userMark;
	}

	public String getStandby2() {
		return standby2;
	}

	public void setStandby2(String standby2) {
		this.standby2 = standby2;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getTransPassword() {
		return transPassword;
	}
	public void setTransPassword(String transPassword) {
		this.transPassword = transPassword;
	}
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChannlNum() {
		return channlNum;
	}
	public void setChannlNum(String channlNum) {
		this.channlNum = channlNum;
	}
	
	
	
	
}
