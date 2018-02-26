package org.sps.service.merchant.write;

import java.math.BigDecimal;

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
  Boolean  saveBankTradeInfo(SpsChannelBank bankInfo, BigDecimal amount);
	/**
	 * 更新交易记录信息
	 */
	void   modifyBankTradeInfo(SpsChannelBankTrade bankTrade);
	/**
	 * 删除交易记录信息
	 */
	void   removeBankTradeInfo(String tradeSerialNum);

	/**
	 * 根据申请日期更新状态
	 * @param applicationDate
	 * @return
	 */
	Boolean  modifyBankTradeByApplicateDate(String applicationDate,String status);
}
