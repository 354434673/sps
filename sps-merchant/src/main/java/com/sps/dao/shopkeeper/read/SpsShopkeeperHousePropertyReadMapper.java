package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperHousePropertyExample;

public interface SpsShopkeeperHousePropertyReadMapper {
    int countByExample(SpsShopkeeperHousePropertyExample example);

    List<SpsShopkeeperHouseProperty> selectByExample(SpsShopkeeperHousePropertyExample example);

    SpsShopkeeperHouseProperty selectByPrimaryKey(Integer houseId);
}