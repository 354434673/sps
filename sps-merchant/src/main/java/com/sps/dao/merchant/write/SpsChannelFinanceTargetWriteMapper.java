package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelFinanceTargetExample;

public interface SpsChannelFinanceTargetWriteMapper {

    int deleteByExample(SpsChannelFinanceTargetExample example);

    int deleteByPrimaryKey(Integer targetId);

    int insert(SpsChannelFinanceTarget record);

    int insertSelective(SpsChannelFinanceTarget record);

    int updateByExampleSelective(@Param("record") SpsChannelFinanceTarget record, @Param("example") SpsChannelFinanceTargetExample example);

    int updateByExample(@Param("record") SpsChannelFinanceTarget record, @Param("example") SpsChannelFinanceTargetExample example);

    int updateByPrimaryKeySelective(SpsChannelFinanceTarget record);

    int updateByPrimaryKey(SpsChannelFinanceTarget record);
}