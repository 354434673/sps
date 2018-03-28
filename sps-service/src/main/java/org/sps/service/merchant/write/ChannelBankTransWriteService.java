package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;

import java.util.HashMap;

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
	 * 删除交易记录信息
	 */
	void  removeBankInfo(String serialSh, String serialYop);

	/**
	 * 根据页面绑卡记录 保存绑卡交易信息
	 *
	 */
	HashMap<String,Object> saveBankTansInfos(SpsChannelBankTrans  bankTransInfo, String userName);

	/**
	 * 根据请求号更新绑卡记录表
	 * @param seriNum
	 * @param yopSerNO
	 * @param status
	 * @return
	 */
	Boolean  modifyBankTran(String seriNum, String yopSerNO, String status,String cardtop,String  cardlast, String authtype,String remark);
	
}
