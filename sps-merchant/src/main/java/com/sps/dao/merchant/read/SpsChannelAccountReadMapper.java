package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelAccount;
import org.sps.entity.merchant.SpsChannelAccountExample;

public interface SpsChannelAccountReadMapper {
    int countByExample(SpsChannelAccountExample example);

    int deleteByExample(SpsChannelAccountExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(SpsChannelAccount record);

    int insertSelective(SpsChannelAccount record);

    List<SpsChannelAccount> selectByExample(SpsChannelAccountExample example);

    SpsChannelAccount selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") SpsChannelAccount record, @Param("example") SpsChannelAccountExample example);

    int updateByExample(@Param("record") SpsChannelAccount record, @Param("example") SpsChannelAccountExample example);

    int updateByPrimaryKeySelective(SpsChannelAccount record);

    int updateByPrimaryKey(SpsChannelAccount record);
}