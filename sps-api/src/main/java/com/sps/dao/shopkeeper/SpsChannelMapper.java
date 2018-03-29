package com.sps.dao.shopkeeper;

import com.sps.entity.merchant.SpsChannel;
import com.sps.entity.merchant.SpsChannelExample;
import org.apache.ibatis.annotations.Param;

public interface SpsChannelMapper {
    int deleteByExample(SpsChannelExample example);

    int deleteByPrimaryKey(Integer channelId);

    int insert(SpsChannel record);

    int insertSelective(SpsChannel record);

    int updateByExampleSelective(@Param("record") SpsChannel record, @Param("example") SpsChannelExample example);

    int updateByExample(@Param("record") SpsChannel record, @Param("example") SpsChannelExample example);

    int updateByPrimaryKeySelective(SpsChannel record);

    int updateByPrimaryKey(SpsChannel record);
}