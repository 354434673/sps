package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelBusinessExample;

public interface SpsChannelBusinessWriteMapper {

    int deleteByExample(SpsChannelBusinessExample example);

    int deleteByPrimaryKey(Integer businessId);

    int insert(SpsChannelBusiness record);

    int insertSelective(SpsChannelBusiness record);

    int updateByExampleSelective(@Param("record") SpsChannelBusiness record, @Param("example") SpsChannelBusinessExample example);

    int updateByExample(@Param("record") SpsChannelBusiness record, @Param("example") SpsChannelBusinessExample example);

    int updateByPrimaryKeySelective(SpsChannelBusiness record);

    int updateByPrimaryKey(SpsChannelBusiness record);
}