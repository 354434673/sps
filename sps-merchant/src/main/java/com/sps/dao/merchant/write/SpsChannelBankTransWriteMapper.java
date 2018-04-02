package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBankTrans;

import java.util.Date;

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
     * 更新状态码
     * @param id
     * @param status
     * @param yopSerNO
     * @param endTime
     * @param cardtop
     * @param cardlast
     * @param authtype
     * @param remark
     * @return
     */

    int updateBankTrans(@Param("id") int id,
                        @Param("status") String status,
                        @Param("yopSerNO") String yopSerNO,
                        @Param("endTime") Date endTime,
                        @Param("cardtop") String cardtop,
                        @Param("cardlast") String cardlast,
                        @Param("authtype") String authtype,
                        @Param("remark") String remark );

}