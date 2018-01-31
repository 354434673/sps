package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;

public interface SpsShopkeeperAccountWriteMapper {
    int deleteByExample(SpsShopkeeperAccountExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(SpsShopkeeperAccount record);

    int insertSelective(SpsShopkeeperAccount record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperAccount record, @Param("example") SpsShopkeeperAccountExample example);

    int updateByExample(@Param("record") SpsShopkeeperAccount record, @Param("example") SpsShopkeeperAccountExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperAccount record);

    int updateByPrimaryKey(SpsShopkeeperAccount record);
}