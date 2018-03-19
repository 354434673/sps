package com.sps.dao.merchant.read;

import org.sps.entity.merchant.SpsChannelBank;

/**  银行卡绑定业务的读操作
 * 
 * @author cailing
 *
 */
public interface SpsChannelBankReadMapper {

    /**
     * 根據身份証查询用户信息
     * @param identity
     * @return
     */
    SpsChannelBank  selectByPrimaryKey(String userName);
    /**
     * 根據登陸用戶查询用户信息
     * @param userName
     * @return
     */
    SpsChannelBank  selectByLoginName(String userName);
    /**
     * 
     * @param channelNum
     * @return
     */
    SpsChannelBank  selectByChannelNum(String channelNum);

    /**
     * 根据登录用户交易密码
     * @param userName
     * @return
     */
    String   selectByLoginUser(String userName);

    /**
     * 根据用户名查找手机号
     * @param userName
     * @return
     */
    String  selectMobileByLoginUser(String userName);
    /**
     * 根据用户名获取盐
     * @param userName
     * @return
     */
    String  selectSalt(String userName);


}