package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelFinanceTargetExample;

public interface SpsChannelFinanceTargetWriteMapper {
    int countByExample(SpsChannelFinanceTargetExample example);

    int deleteByExample(SpsChannelFinanceTargetExample example);

    int deleteByPrimaryKey(Integer targetId);

    int insert(SpsChannelFinanceTarget record);

    int insertSelective(SpsChannelFinanceTarget record);

    List<SpsChannelFinanceTarget> selectByExample(SpsChannelFinanceTargetExample example);

    SpsChannelFinanceTarget selectByPrimaryKey(Integer targetId);

    int updateByExampleSelective(@Param("record") SpsChannelFinanceTarget record, @Param("example") SpsChannelFinanceTargetExample example);

    int updateByExample(@Param("record") SpsChannelFinanceTarget record, @Param("example") SpsChannelFinanceTargetExample example);

    int updateByPrimaryKeySelective(SpsChannelFinanceTarget record);

    int updateByPrimaryKey(SpsChannelFinanceTarget record);
}