package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelStatistics;
import org.sps.entity.merchant.SpsChannelStatisticsExample;

public interface SpsChannelStatisticsWriteMapper {
    int countByExample(SpsChannelStatisticsExample example);

    int deleteByExample(SpsChannelStatisticsExample example);

    int deleteByPrimaryKey(Integer statisticsId);

    int insert(SpsChannelStatistics record);

    int insertSelective(SpsChannelStatistics record);

    List<SpsChannelStatistics> selectByExample(SpsChannelStatisticsExample example);

    SpsChannelStatistics selectByPrimaryKey(Integer statisticsId);

    int updateByExampleSelective(@Param("record") SpsChannelStatistics record, @Param("example") SpsChannelStatisticsExample example);

    int updateByExample(@Param("record") SpsChannelStatistics record, @Param("example") SpsChannelStatisticsExample example);

    int updateByPrimaryKeySelective(SpsChannelStatistics record);

    int updateByPrimaryKey(SpsChannelStatistics record);
}