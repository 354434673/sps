package org.sps.service.merchant.read;

import java.util.HashMap;

import org.sps.entity.merchant.SpsChannelBank;

/***
 *  绑卡业务层
 * @author cailing
 *
 */

public interface ChannelBankReadService{
	
	/**
	 *  根据用户名身份證查询交易记录
	 */
	SpsChannelBank  getBankInfo(String indentify);
	/**
	 *  根据用户名身份證查询交易记录
	 */
	SpsChannelBank  getBankInfoByUserName(String userName);
	/**
	 * 获取请求号
	 * @return
	 */
	public String  generateRequestNo();

	/**
	 * 根据登录用户名查询交易密码
	 * @param userName
	 * @return
	 */
	Boolean  findTradePassword(String userName);

	/***
	 * 根据用户名查询手机号
	 * @param userName
	 * @return
	 */
	String  findMobileByUserName(String userName);
	
}
