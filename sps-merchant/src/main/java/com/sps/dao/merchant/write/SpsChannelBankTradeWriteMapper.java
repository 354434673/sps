package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrade;
/**
 * 交易流水账号的DAO
 * @author liucialing 
 *
 */
public interface SpsChannelBankTradeWriteMapper {
	/**
	 * 保存交易的方法
	 * @param bankTrade
	 * @return
	 */
	int insertBankTrade(SpsChannelBankTrade bankTrade);
	/**
	 * 更新交易的方法
	 * @param bankTrade
	 * @return
	 */
	int updateBankTrade(SpsChannelBankTrade bankTrade);
	/**
	 * 根据流水号删除交易信息的方法
	 * @param tradeSerialNum
	 * @return
	 */
	int deleteBankTrade(String tradeSerialNum);


	/**
	 * 根据申请日期与状态更新，审核状态
	 * @param applicationDate
	 * @param status
	 * @return
	 */
	int updateStatus(@Param("applicationDate") String applicationDate, @Param("status") String status,@Param("content")String content);
}