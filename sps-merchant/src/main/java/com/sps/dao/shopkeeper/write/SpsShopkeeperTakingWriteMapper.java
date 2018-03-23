package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperTaking;
import org.sps.entity.shopkeeper.SpsShopkeeperTakingExample;

public interface SpsShopkeeperTakingWriteMapper {
    int deleteByExample(SpsShopkeeperTakingExample example);

    int deleteByPrimaryKey(Integer takingId);

    int insert(SpsShopkeeperTaking record);

    int insertSelective(SpsShopkeeperTaking record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperTaking record, @Param("example") SpsShopkeeperTakingExample example);

    int updateByExample(@Param("record") SpsShopkeeperTaking record, @Param("example") SpsShopkeeperTakingExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperTaking record);

    int updateByPrimaryKey(SpsShopkeeperTaking record);
}