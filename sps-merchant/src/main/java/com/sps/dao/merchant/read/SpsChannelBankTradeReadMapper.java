package com.sps.dao.merchant.read;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.entity.shopkeeper.SpsShopkeeper;

/**
 * 提現交易Dao
 * @author 刘彩玲
 *
 */
public interface SpsChannelBankTradeReadMapper {
	/**
	 * 按條件查詢提現記錄
	 * @param applicationStartDate
	 * @param paymentDate
	 * @param tradeStatus
	 * @return
	 */
	List<SpsChannelBankTrade>  selectListBankTrade(
            @Param("applicationStartDate") String applicationStartDate,
            @Param("paymentDate") String paymentDate,
            @Param("tradeStatus") String tradeStatus,
            @Param("channelNum") String channelNum);

	/**
	 * 根据商户编号进行查询
	 * @param channelNum
	 * @return
	 */
	SpsChannelBankTrade  selectBankTradeByUsername(String channelNum);

}