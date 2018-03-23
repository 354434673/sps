package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelPic;
import org.sps.entity.merchant.SpsChannelPicExample;

public interface SpsChannelPicReadMapper {
    int countByExample(SpsChannelPicExample example);

    List<SpsChannelPic> selectByExample(SpsChannelPicExample example);

    SpsChannelPic selectByPrimaryKey(Integer picId);
}