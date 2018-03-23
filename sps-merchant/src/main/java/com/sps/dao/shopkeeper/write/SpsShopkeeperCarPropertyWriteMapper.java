package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperCarPropertyExample;

public interface SpsShopkeeperCarPropertyWriteMapper {

    int deleteByExample(SpsShopkeeperCarPropertyExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(SpsShopkeeperCarProperty record);

    int insertSelective(SpsShopkeeperCarProperty record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperCarProperty record, @Param("example") SpsShopkeeperCarPropertyExample example);

    int updateByExample(@Param("record") SpsShopkeeperCarProperty record, @Param("example") SpsShopkeeperCarPropertyExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperCarProperty record);

    int updateByPrimaryKey(SpsShopkeeperCarProperty record);
}