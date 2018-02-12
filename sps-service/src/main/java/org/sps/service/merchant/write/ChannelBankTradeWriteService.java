package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;

/***
 *  充值 提现交易
 * @author cailing
 *
 */

public interface ChannelBankTradeWriteService{
	/**
	 * 插入交易记录
	 * 
	 */
    void   saveBankTradeInfo(SpsChannelBankTrade bankTrade, String userName);
	/**
	 * 更新交易记录信息
	 */
	void   modifyBankTradeInfo(SpsChannelBankTrade bankTrade);
	/**
	 * 删除交易记录信息
	 */
	void   removeBankTradeInfo(String tradeSerialNum);
	
}
