package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelAccount;
import org.sps.entity.merchant.SpsChannelAccountExample;
import org.sps.entity.merchant.SpsChannelBank;

/**  银行卡绑定业务的读操作
 * 
 * @author cailing
 *
 */
public interface SpsChannelBankReadMapper {

    /**
     * 根据用户省份正查询用户信息
     * @param identity
     * @return
     */
    SpsChannelBank  selectByPrimaryKey(String identity);
    /**
     * 
     * @param channelNum
     * @return
     */
    SpsChannelBank  selectByChannelNum(String channelNum);

    /**
     * 根据登录用户交易密码
     * @param loginUser
     * @return
     */
    String   selectByLoginUser(String userName);

    /**
     * 根据用户名查找手机号
     * @param userName
     * @return
     */
    String  selectMobileByLoginUser(String userName);
}