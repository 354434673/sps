package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;

import java.math.BigDecimal;

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
	String  saveBankTradeInfo(SpsChannelBank bankInfo, BigDecimal amount,String tradeType,Integer userId,Integer userMark);
	/**
	 * 插入充值记录
	 *
	 */
	Boolean  saveBankRechangeTradeInfo(SpsChannelBankTrade spsChannelBankTrade);

	/**
	 * 更新充值状态
	 * @param spsChannelBankTrade
	 * @return
	 */
	Boolean  modifyRechangeStatus(SpsChannelBankTrade spsChannelBankTrade);

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
	 * @param id
	 * @return
	 */
	Boolean  modifyBankTradeByApplicateDate(int  id,String status,String content);
}
