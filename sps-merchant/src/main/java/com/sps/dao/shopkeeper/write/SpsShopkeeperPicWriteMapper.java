package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.sps.entity.shopkeeper.SpsShopkeeperPicExample;

public interface SpsShopkeeperPicWriteMapper {

    int deleteByExample(SpsShopkeeperPicExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(SpsShopkeeperPic record);

    int insertSelective(SpsShopkeeperPic record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperPic record, @Param("example") SpsShopkeeperPicExample example);

    int updateByExample(@Param("record") SpsShopkeeperPic record, @Param("example") SpsShopkeeperPicExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperPic record);

    int updateByPrimaryKey(SpsShopkeeperPic record);
}