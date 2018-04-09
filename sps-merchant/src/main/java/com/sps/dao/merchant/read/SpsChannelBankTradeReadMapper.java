package com.sps.dao.merchant.read;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrade;

import java.math.BigDecimal;
import java.util.List;

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
            @Param("channelNum") String channelNum,
					@Param("tradeType") String tradeType);

	/**
	 * 根据登录用户名查询交易记录
	 * @param channelNum
	 * @param startTime
	 * @param endTime
	 * @param minAmount
	 * @param maxAmount
	 * @param payType
	 * @param companyName
	 * @param reamrk
	 * @return
	 */

	List<SpsChannelBankTrade>  selectBankTradeTypeListByLoginName(
			@Param("channelNum") String channelNum,
			@Param("startTime") String startTime,
			@Param("endTime") String endTime,
			@Param("minAmount") BigDecimal minAmount,
			@Param("maxAmount") BigDecimal maxAmount,
			@Param("payType") String payType,
			@Param("companyName") String companyName,
			@Param("reamrk") String reamrk);

	/**
	 * 根据商户编号进行查询
	 * @param channelNum
	 * @return
	 */
	SpsChannelBankTrade  selectBankTradeByUsername(@Param("channelNum") String channelNum,@Param("tradeSerialNum") String tradeSerialNum);

	/**
	 * 充值交易流水号进行查询
	 * @param tradeSerialNum
	 * @return
	 */
	SpsChannelBankTrade  selectBankTradeBySeriNum(@Param("tradeSerialNum") String tradeSerialNum);

	/**
	 * 提现交易流水号进行查询
	 * @param tradeSerialNum
	 * @return
	 */
	SpsChannelBankTrade  selectBankTradeAuditBySeriNum(@Param("tradeSerialNum") String tradeSerialNum);


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
	 * @param id
	 * @return
	 */
	SpsChannelBankTrade selectBankTradeInfo(int   id);

	/**
	 * 根据交易号查询订单号
	 * @param tradeSeriNum
	 * @return
	 */
	SpsChannelBankTrade selectOrderByTradeSeriNum(String  tradeSeriNum);
}