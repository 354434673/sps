package com.sps.dao.merchant.read;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrans;

/**
 * 绑卡交易Dao
 * @author 刘彩玲
 *
 */
public interface SpsChannelBankTransReadMapper {
	//根据请求号与易宝订单号查询
	public SpsChannelBankTrans selectOne(@Param("requestno") String requestno, @Param("yborderid") String yborderid);
	//   生成请求号
	public String generateNo();
}