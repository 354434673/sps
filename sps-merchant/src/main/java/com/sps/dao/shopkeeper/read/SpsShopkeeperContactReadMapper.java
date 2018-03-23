package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperContact;
import org.sps.entity.shopkeeper.SpsShopkeeperContactExample;

public interface SpsShopkeeperContactReadMapper {
    int countByExample(SpsShopkeeperContactExample example);

    List<SpsShopkeeperContact> selectByExample(SpsShopkeeperContactExample example);

    SpsShopkeeperContact selectByPrimaryKey(Integer contactId);
}