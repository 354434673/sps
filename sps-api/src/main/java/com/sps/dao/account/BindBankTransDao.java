package com.sps.dao.account;

import com.sps.entity.account.BindBankTrans;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 绑卡交易流水帐号的DAO
 * @author 刘彩玲
 *
 */

public interface BindBankTransDao {
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
    int insertBankTrans(BindBankTrans trans);

    /**
     * 更新流水帐号
     * @param status
     * @param yopSerNO
     * @return
     */
    int updateBankTrans(@Param("id") int id, @Param("status") String status,@Param("yopSerNO") String yopSerNO,@Param("endTime") Date endTime);

     BindBankTrans selectOne(@Param("requestno") String requestno, @Param("yborderid") String yborderid);
     BindBankTrans selectByRequestNo(String requestno);


}