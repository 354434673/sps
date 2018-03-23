package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.entity.merchant.SpsChannelOpenAccountExample;

public interface SpsChannelOpenAccountWriteMapper {

    int deleteByExample(SpsChannelOpenAccountExample example);

    int deleteByPrimaryKey(Integer openId);

    int insert(SpsChannelOpenAccount record);

    int insertSelective(SpsChannelOpenAccount record);

    int updateByExampleSelective(@Param("record") SpsChannelOpenAccount record, @Param("example") SpsChannelOpenAccountExample example);

    int updateByExample(@Param("record") SpsChannelOpenAccount record, @Param("example") SpsChannelOpenAccountExample example);

    int updateByPrimaryKeySelective(SpsChannelOpenAccount record);

    int updateByPrimaryKey(SpsChannelOpenAccount record);
}