package org.sps.service.merchant.read;

import java.util.HashMap;

import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;

/***
 *  绑卡业务层
 * @author cailing
 *
 */

public interface ChannelBankTransReadService{
	
	/**
	 *  根据用户名和银行账号进行查询
	 */
	SpsChannelBankTrans  getBankInfo(String userName);
	
	/***
	 * 根据请求好与易宝号进行查询
	 * @param requestNo
	 * @param yborderid
	 * @return
	 */
	SpsChannelBankTrans findBankState(String requestNo, String yborderid);
	
	
}
