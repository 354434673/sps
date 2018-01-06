package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelFinanceTargetExample;

public interface SpsChannelFinanceTargetReadMapper {
    int countByExample(SpsChannelFinanceTargetExample example);

    List<SpsChannelFinanceTarget> selectByExample(SpsChannelFinanceTargetExample example);

    SpsChannelFinanceTarget selectByPrimaryKey(Integer targetId);
}