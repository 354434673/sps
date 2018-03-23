package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelExample;

public interface SpsChannelReadMapper {
    int countByExample(SpsChannelExample example);

    List<SpsChannel> selectByExample(SpsChannelExample example);

    SpsChannel selectByPrimaryKey(Integer channelId);
}