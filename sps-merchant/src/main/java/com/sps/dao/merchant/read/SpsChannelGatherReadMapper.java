package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGatherExample;

public interface SpsChannelGatherReadMapper {
    int countByExample(SpsChannelGatherExample example);

    int deleteByExample(SpsChannelGatherExample example);

    int deleteByPrimaryKey(Integer gatherId);

    int insert(SpsChannelGather record);

    int insertSelective(SpsChannelGather record);

    List<SpsChannelGather> selectByExample(SpsChannelGatherExample example);

    SpsChannelGather selectByPrimaryKey(Integer gatherId);

    int updateByExampleSelective(@Param("record") SpsChannelGather record, @Param("example") SpsChannelGatherExample example);

    int updateByExample(@Param("record") SpsChannelGather record, @Param("example") SpsChannelGatherExample example);

    int updateByPrimaryKeySelective(SpsChannelGather record);

    int updateByPrimaryKey(SpsChannelGather record);
}