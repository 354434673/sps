package com.sps.dao.merchant.read;

import java.math.BigDecimal;
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
	 * 按條件查詢查询所有提现记录
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
	SpsChannelBankTrade  selectBankTradeByUsername(@Param("channelNum") String channelNum,@Param("tradeSerialNum") String tradeSerialNum);

	/**获取索索商户的提现申请记录信息
	 *
	 * @param applicationStartDate
	 * @param paymentDate
	 * @param tradeStatus
	 * @param loginName
	 * @return
	 */
	List<SpsChannelBankTrade>  selectListCashAudit(
			@Param("applicationStartDate") String applicationStartDate,
			@Param("paymentDate") String paymentDate,
			@Param("tradeStatus") String tradeStatus,
			@Param("enterpriseCompanyName") String enterpriseCompanyName,
			@Param("loginName") String loginName);

	/**
	 * 查询收支信息
	 * @param startTime
	 * @param endTime
	 * @param minAmount
	 * @param maxAmount
	 * @param payType
	 * @param companyName
	 * @param reamrk
	 * @return
	 */
	List<SpsChannelBankTrade>  selectIncomePaymentList(
			@Param("startTime") String startTime,
			@Param("endTime") String endTime,
			@Param("minAmount") BigDecimal minAmount,
			@Param("maxAmount") BigDecimal maxAmount,
			@Param("payType") String payType,
			@Param("companyName") String companyName,
			@Param("reamrk") String reamrk);


    /**
     * 根据收入查询所有
     * @param startTime
     * @param endTime
     * @param minAmount
     * @param maxAmount
     * @param companyName
     * @param reamrk
     * @return
     */
    List<SpsChannelBankTrade>  selectBankTradeTypeList(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("minAmount") BigDecimal minAmount,
            @Param("maxAmount") BigDecimal maxAmount,
            @Param("payType") String payType,
            @Param("companyName") String companyName,
            @Param("reamrk") String reamrk);


	/**
	 * 根据用户名查询提现记录
	 * @param loginName
	 * @return
	 */
	List<SpsChannelBankTrade>  selectListCashAuditByUserName(String loginName);

	/**
	 * 根据当前用户获取近30天审批通过的所有提现金额
	 * @param userName
	 * @return
	 */
	BigDecimal  selectMoneyAmount(String userName);

	/**
	 * 根据用户名获取所有通过的审核通过的提现金额
	 * @param userName
	 * @return
	 */
	BigDecimal  selectTotalAmount(String userName);

	/**
	 * 根据申请日期查询提现交易信息
	 * @param applicationDate
	 * @return
	 */
	SpsChannelBankTrade selectBankTradeInfo(String  applicationDate);
}