package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelAccount;
import org.sps.entity.merchant.SpsChannelAccountExample;

public interface SpsChannelAccountReadMapper {
    int countByExample(SpsChannelAccountExample example);

    List<SpsChannelAccount> selectByExample(SpsChannelAccountExample example);

    SpsChannelAccount selectByPrimaryKey(Integer accountId);

}