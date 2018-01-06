package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelBusinessExample;

public interface SpsChannelBusinessReadMapper {
    int countByExample(SpsChannelBusinessExample example);

    List<SpsChannelBusiness> selectByExample(SpsChannelBusinessExample example);

    SpsChannelBusiness selectByPrimaryKey(Integer businessId);
}