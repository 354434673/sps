package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;

import java.math.BigDecimal;

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
	Boolean  saveBankInfo(SpsChannelBank bankinfo, Integer userId, Integer userMark);

	/**
	 * 更新可用余额
	 * @param userName
	 * @param balance
	 * @return
	 */
	Boolean modifyBalance(String userName, BigDecimal balance);
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
	Boolean  modifyTradePsw(String userId,String psw,String salt);
}
