package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperHousePropertyExample;

public interface SpsShopkeeperHousePropertyWriteMapper {

    int deleteByExample(SpsShopkeeperHousePropertyExample example);

    int deleteByPrimaryKey(Integer houseId);

    int insert(SpsShopkeeperHouseProperty record);

    int insertSelective(SpsShopkeeperHouseProperty record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperHouseProperty record, @Param("example") SpsShopkeeperHousePropertyExample example);

    int updateByExample(@Param("record") SpsShopkeeperHouseProperty record, @Param("example") SpsShopkeeperHousePropertyExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperHouseProperty record);

    int updateByPrimaryKey(SpsShopkeeperHouseProperty record);
}