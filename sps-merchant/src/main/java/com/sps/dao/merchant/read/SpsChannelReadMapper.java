package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelExample;

public interface SpsChannelReadMapper {
    int countByExample(SpsChannelExample example);

    int deleteByExample(SpsChannelExample example);

    int deleteByPrimaryKey(Integer channelId);

    int insert(SpsChannel record);

    int insertSelective(SpsChannel record);

    List<SpsChannel> selectByExample(SpsChannelExample example);

    SpsChannel selectByPrimaryKey(Integer channelId);

    int updateByExampleSelective(@Param("record") SpsChannel record, @Param("example") SpsChannelExample example);

    int updateByExample(@Param("record") SpsChannel record, @Param("example") SpsChannelExample example);

    int updateByPrimaryKeySelective(SpsChannel record);

    int updateByPrimaryKey(SpsChannel record);
}