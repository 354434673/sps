package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;

public interface SpsShopkeeperReadMapper {
    int countByExample(SpsShopkeeperExample example);

    List<SpsShopkeeper> selectByExample(SpsShopkeeperExample example);
    
    List<SpsShopkeeper> selectListForJoin(
    		@Param("account")String account, 
    		@Param("shopkeeperName")String shopkeeperName, 
    		@Param("shopkeeperState")Integer shopkeeperState);

    SpsShopkeeper selectByPrimaryKey(Integer shopkeeperId);
}