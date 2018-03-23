package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCredit;
import org.sps.entity.shopkeeper.SpsShopkeeperCreditExample;

public interface SpsShopkeeperCreditWriteMapper {
    int deleteByExample(SpsShopkeeperCreditExample example);

    int deleteByPrimaryKey(Integer creditId);

    int insert(SpsShopkeeperCredit record);

    int insertSelective(SpsShopkeeperCredit record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperCredit record, @Param("example") SpsShopkeeperCreditExample example);

    int updateByExample(@Param("record") SpsShopkeeperCredit record, @Param("example") SpsShopkeeperCreditExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperCredit record);

    int updateByPrimaryKey(SpsShopkeeperCredit record);
}