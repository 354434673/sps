package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperCarPropertyExample;

public interface SpsShopkeeperCarPropertyReadMapper {
    int countByExample(SpsShopkeeperCarPropertyExample example);

    List<SpsShopkeeperCarProperty> selectByExample(SpsShopkeeperCarPropertyExample example);

    SpsShopkeeperCarProperty selectByPrimaryKey(Integer carId);
}