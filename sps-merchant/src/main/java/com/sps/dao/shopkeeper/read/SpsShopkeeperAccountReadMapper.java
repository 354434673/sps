package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;

public interface SpsShopkeeperAccountReadMapper {
    int countByExample(SpsShopkeeperAccountExample example);

    List<SpsShopkeeperAccount> selectByExample(SpsShopkeeperAccountExample example);

    SpsShopkeeperAccount selectByPrimaryKey(Integer accountId);
}