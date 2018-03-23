package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.sps.entity.shopkeeper.SpsShopkeeperPicExample;

public interface SpsShopkeeperPicReadMapper {
    int countByExample(SpsShopkeeperPicExample example);

    List<SpsShopkeeperPic> selectByExample(SpsShopkeeperPicExample example);

    SpsShopkeeperPic selectByPrimaryKey(Integer picId);
}