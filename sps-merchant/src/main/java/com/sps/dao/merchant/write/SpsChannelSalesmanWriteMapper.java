package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;

public interface SpsChannelSalesmanWriteMapper {
    int deleteByExample(SpsChannelSalesmanExample example);

    int deleteByPrimaryKey(Integer salesmanId);

    int insert(SpsChannelSalesman record);

    int insertSelective(SpsChannelSalesman record);

    int updateByExampleSelective(@Param("record") SpsChannelSalesman record, @Param("example") SpsChannelSalesmanExample example);

    int updateByExample(@Param("record") SpsChannelSalesman record, @Param("example") SpsChannelSalesmanExample example);

    int updateByPrimaryKeySelective(SpsChannelSalesman record);

    int updateByPrimaryKey(SpsChannelSalesman record);
}