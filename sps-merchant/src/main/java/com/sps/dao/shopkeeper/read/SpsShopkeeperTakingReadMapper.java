package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperTaking;
import org.sps.entity.shopkeeper.SpsShopkeeperTakingExample;

public interface SpsShopkeeperTakingReadMapper {
    int countByExample(SpsShopkeeperTakingExample example);

    List<SpsShopkeeperTaking> selectByExample(SpsShopkeeperTakingExample example);

    SpsShopkeeperTaking selectByPrimaryKey(Integer takingId);
}