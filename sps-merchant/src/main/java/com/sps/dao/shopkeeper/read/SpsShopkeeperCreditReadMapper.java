package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCredit;
import org.sps.entity.shopkeeper.SpsShopkeeperCreditExample;

public interface SpsShopkeeperCreditReadMapper {
    int countByExample(SpsShopkeeperCreditExample example);

    List<SpsShopkeeperCredit> selectByExample(SpsShopkeeperCreditExample example);

    SpsShopkeeperCredit selectByPrimaryKey(Integer creditId);
}