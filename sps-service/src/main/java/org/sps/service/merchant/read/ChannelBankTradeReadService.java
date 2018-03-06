package org.sps.service.merchant.read;

import org.sps.entity.merchant.SpsChannelBankTrade;

import java.util.HashMap;

/***
 *  提现 支付 业务层
 * @author cailing
 *
 */

public interface ChannelBankTradeReadService{
	
	
	/**
	 * 查詢交易記錄
	 * @param page
	 * @param limit
	 * @param applicationStartDate
	 * @param paymentDate
	 * @param tradeStatus
	 * @return
	 */
	public HashMap<String,Object> getBankTradeList(Integer page, Integer limit,
                                                  String applicationStartDate, String
                                                           paymentDate, String tradeStatus, String loginName,String tradeType);

	/**ate
	 * 获取交易详情
	 * @param loginName
	 * @return
	 */

	public SpsChannelBankTrade getTradeDetail(String loginName,String tradeSerialNum);

	SpsChannelBankTrade getTradeInfo(String tradeSerialNum);

	/**
	 * 根据条件查询所有提现申请信息
	 * @param page
	 * @param limit
	 * @param applicationStartDate
	 * @param paymentDate
	 * @param tradeStatus
	 * @param name
	 * @param account
	 * @return
	 */
	HashMap<String, Object> getBankAuditInfo(Integer page, Integer limit, String applicationStartDate, String paymentDate, String tradeStatus, String name, String account);

}
