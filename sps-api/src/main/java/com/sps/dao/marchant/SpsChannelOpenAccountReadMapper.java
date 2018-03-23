package com.sps.dao.marchant;


public interface SpsChannelOpenAccountReadMapper {
   //根据登录用户名 获取 渠道编号
    String selectByOpenAdminNum(String openAdminNum);
    
}