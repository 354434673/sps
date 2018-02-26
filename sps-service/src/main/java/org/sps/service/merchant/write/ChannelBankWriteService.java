package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannelBank;

/***
 *  绑卡业务层
 * @author cailing
 *
 */

public interface ChannelBankWriteService{
	/**
	 * 插入绑卡信息
	 * 
	 */
	Boolean  saveBankInfo(SpsChannelBank bankinfo, String loginName);
	/**
	 * 更新绑卡信息
	 */
	Boolean  modifyBankInfo(SpsChannelBank bankinfo);
	/**
	 * 删除绑卡信息
	 */
	Boolean removeBankInfo(String userId);
	/**
	 * 
	 */
	Boolean  removeBankInfoOrNo(String userId);

	/**
	 * 设置交易密码
	 * @param psw
	 * @return
	 */
	Boolean  modifyTradePsw(String userId,String psw);
}
