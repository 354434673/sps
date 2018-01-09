package com.sps.dao.merchant.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.entity.merchant.SpsChannelOpenAccountExample;

public interface SpsChannelOpenAccountReadMapper {
    int countByExample(SpsChannelOpenAccountExample example);

    List<SpsChannelOpenAccount> selectByExample(SpsChannelOpenAccountExample example);

    SpsChannelOpenAccount selectByPrimaryKey(Integer openId);
}