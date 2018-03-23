package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;

public interface SpsShopkeeperPersonalWriteMapper {
    int deleteByExample(SpsShopkeeperPersonalExample example);

    int deleteByPrimaryKey(Integer personalId);

    int insert(SpsShopkeeperPersonal record);

    int insertSelective(SpsShopkeeperPersonal record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperPersonal record, @Param("example") SpsShopkeeperPersonalExample example);

    int updateByExample(@Param("record") SpsShopkeeperPersonal record, @Param("example") SpsShopkeeperPersonalExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperPersonal record);

    int updateByPrimaryKey(SpsShopkeeperPersonal record);
}