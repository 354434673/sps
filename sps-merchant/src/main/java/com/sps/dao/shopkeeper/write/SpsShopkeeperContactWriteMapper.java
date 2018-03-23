package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperContact;
import org.sps.entity.shopkeeper.SpsShopkeeperContactExample;

public interface SpsShopkeeperContactWriteMapper {
    int deleteByExample(SpsShopkeeperContactExample example);

    int deleteByPrimaryKey(Integer contactId);

    int insert(SpsShopkeeperContact record);

    int insertSelective(SpsShopkeeperContact record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperContact record, @Param("example") SpsShopkeeperContactExample example);

    int updateByExample(@Param("record") SpsShopkeeperContact record, @Param("example") SpsShopkeeperContactExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperContact record);

    int updateByPrimaryKey(SpsShopkeeperContact record);
}