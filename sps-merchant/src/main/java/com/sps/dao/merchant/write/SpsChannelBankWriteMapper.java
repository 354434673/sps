package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBank;

import java.math.BigDecimal;

public interface SpsChannelBankWriteMapper {

	int deleteByPrimaryKey(String userName);

    int insertBank(SpsChannelBank bank);

    int updateBank(SpsChannelBank bank);
    int updateTradePsw(@Param("userId") String userId,@Param("psw") String psw);
    int updateAblance(@Param("userId") String userId, @Param("availableBalance") BigDecimal availableBalance);
}