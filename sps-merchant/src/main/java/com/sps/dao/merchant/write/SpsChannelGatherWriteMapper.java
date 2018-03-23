package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGatherExample;

public interface SpsChannelGatherWriteMapper {

    int deleteByExample(SpsChannelGatherExample example);

    int deleteByPrimaryKey(Integer gatherId);

    int insert(SpsChannelGather record);

    int insertSelective(SpsChannelGather record);

    int updateByExampleSelective(@Param("record") SpsChannelGather record, @Param("example") SpsChannelGatherExample example);

    int updateByExample(@Param("record") SpsChannelGather record, @Param("example") SpsChannelGatherExample example);

    int updateByPrimaryKeySelective(SpsChannelGather record);

    int updateByPrimaryKey(SpsChannelGather record);
}