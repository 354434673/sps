package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelStatistics;
import org.sps.entity.merchant.SpsChannelStatisticsExample;

public interface SpsChannelStatisticsReadMapper {
    int countByExample(SpsChannelStatisticsExample example);

    List<SpsChannelStatistics> selectByExample(SpsChannelStatisticsExample example);

    SpsChannelStatistics selectByPrimaryKey(Integer statisticsId);
}