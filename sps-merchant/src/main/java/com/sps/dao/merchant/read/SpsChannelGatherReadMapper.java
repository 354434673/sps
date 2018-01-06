package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGatherExample;

public interface SpsChannelGatherReadMapper {
    int countByExample(SpsChannelGatherExample example);

    List<SpsChannelGather> selectByExample(SpsChannelGatherExample example);

    SpsChannelGather selectByPrimaryKey(Integer gatherId);
}