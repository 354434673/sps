package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelBusinessExample;

public interface SpsChannelBusinessWriteMapper {
    int countByExample(SpsChannelBusinessExample example);

    int deleteByExample(SpsChannelBusinessExample example);

    int deleteByPrimaryKey(Integer businessId);

    int insert(SpsChannelBusiness record);

    int insertSelective(SpsChannelBusiness record);

    List<SpsChannelBusiness> selectByExample(SpsChannelBusinessExample example);

    SpsChannelBusiness selectByPrimaryKey(Integer businessId);

    int updateByExampleSelective(@Param("record") SpsChannelBusiness record, @Param("example") SpsChannelBusinessExample example);

    int updateByExample(@Param("record") SpsChannelBusiness record, @Param("example") SpsChannelBusinessExample example);

    int updateByPrimaryKeySelective(SpsChannelBusiness record);

    int updateByPrimaryKey(SpsChannelBusiness record);
}