package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelLogisticsExample;

public interface SpsChannelLogisticsWriteMapper {

    int deleteByExample(SpsChannelLogisticsExample example);

    int deleteByPrimaryKey(Integer logisticsId);

    int insert(SpsChannelLogistics record);

    int insertSelective(SpsChannelLogistics record);

    int updateByExampleSelective(@Param("record") SpsChannelLogistics record, @Param("example") SpsChannelLogisticsExample example);

    int updateByExample(@Param("record") SpsChannelLogistics record, @Param("example") SpsChannelLogisticsExample example);

    int updateByPrimaryKeySelective(SpsChannelLogistics record);

    int updateByPrimaryKey(SpsChannelLogistics record);
}