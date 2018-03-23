package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelLogisticsExample;

public interface SpsChannelLogisticsReadMapper {
    int countByExample(SpsChannelLogisticsExample example);

    List<SpsChannelLogistics> selectByExample(SpsChannelLogisticsExample example);

    SpsChannelLogistics selectByPrimaryKey(Integer logisticsId);
}