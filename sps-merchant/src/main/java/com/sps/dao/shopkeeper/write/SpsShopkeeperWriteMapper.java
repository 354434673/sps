package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;

public interface SpsShopkeeperWriteMapper {
    int deleteByExample(SpsShopkeeperExample example);

    int deleteByPrimaryKey(Integer shopkeeperId);

    int insert(SpsShopkeeper record);

    int insertSelective(SpsShopkeeper record);

    int updateByExampleSelective(@Param("record") SpsShopkeeper record, @Param("example") SpsShopkeeperExample example);

    int updateByExample(@Param("record") SpsShopkeeper record, @Param("example") SpsShopkeeperExample example);

    int updateByPrimaryKeySelective(SpsShopkeeper record);

    int updateByPrimaryKey(SpsShopkeeper record);
}