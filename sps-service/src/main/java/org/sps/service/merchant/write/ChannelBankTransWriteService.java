package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;

/***
 *  绑卡流水账号
 * @author cailing
 *
 */

public interface ChannelBankTransWriteService{
	
	    
	/**
	 * 插入交易记录卡信息
	 * 
	 */
	void  saveBankTansInfo(SpsChannelBankTrans bankTransInfo);
	/**
	 * 更新交易记录信息
	 */
	void  modifyBankInfo(SpsChannelBankTrans bankTransInfo);
	/**
	 * 删除交易记录信息
	 */
	void  removeBankInfo(String serialSh, String serialYop);
	
	
	
}
