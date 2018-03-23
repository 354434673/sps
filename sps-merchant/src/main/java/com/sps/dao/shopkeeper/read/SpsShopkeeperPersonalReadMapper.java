package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;

public interface SpsShopkeeperPersonalReadMapper {
    int countByExample(SpsShopkeeperPersonalExample example);

    List<SpsShopkeeperPersonal> selectByExample(SpsShopkeeperPersonalExample example);

    SpsShopkeeperPersonal selectByPrimaryKey(Integer personalId);
}