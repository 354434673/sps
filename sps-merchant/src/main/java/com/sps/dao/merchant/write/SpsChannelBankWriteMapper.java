package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBank;

import java.math.BigDecimal;

public interface SpsChannelBankWriteMapper {

    int deleteByPrimaryKey(String userName);

    /**
     * 保存交易记录
     * @param bank
     * @return
     */
    int insertBank(SpsChannelBank bank);

    /**
     * 根据登录用户名更新可用余额
     * @param userName
     * @param balance
     * @return
     */
    int updateBalance(@Param("userName") String userName,@Param("balance") BigDecimal balance);

    int updateBank(SpsChannelBank bank);
    int updateTradePsw(@Param("userId") String userId,@Param("psw") String psw,@Param("salt") String salt);
    int updateAblance(@Param("userId") String userId, @Param("availableBalance") BigDecimal availableBalance);
}