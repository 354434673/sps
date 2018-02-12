package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrans;
/**
 * 绑卡交易流水帐号的DAO
 * @author 刘彩玲
 *
 */

public interface SpsChannelBankTransWriteMapper {
	/**
	 * 根据用户id删除信息
	 * @param
	 * @return
	 */
    int deleteByPrimaryKey(@Param("serialSh") String serialSh, @Param("serialYop") String serialYop);
    /**
     * 插入流水账号
     * @param trans
     * @return
     */
    int insertBankTrans(SpsChannelBankTrans trans);
    /**
     * 更新流水帐号
     * @param trans
     * @return
     */
    int updateBankTrans(SpsChannelBankTrans trans);
}