package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;

public interface SpsShopkeeperReadMapper {
    int countByExample(SpsShopkeeperExample example);

    List<SpsShopkeeper> selectByExample(SpsShopkeeperExample example);

    SpsShopkeeper selectByPrimaryKey(Integer shopkeeperId);
}