package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelPic;
import org.sps.entity.merchant.SpsChannelPicExample;

public interface SpsChannelPicWriteMapper {
    int deleteByExample(SpsChannelPicExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(SpsChannelPic record);

    int insertSelective(SpsChannelPic record);

    int updateByExampleSelective(@Param("record") SpsChannelPic record, @Param("example") SpsChannelPicExample example);

    int updateByExample(@Param("record") SpsChannelPic record, @Param("example") SpsChannelPicExample example);

    int updateByPrimaryKeySelective(SpsChannelPic record);

    int updateByPrimaryKey(SpsChannelPic record);
}