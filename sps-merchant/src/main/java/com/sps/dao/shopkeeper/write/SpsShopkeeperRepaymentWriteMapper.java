package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import org.sps.entity.shopkeeper.SpsShopkeeperRepaymentExample;

public interface SpsShopkeeperRepaymentWriteMapper {
    int deleteByExample(SpsShopkeeperRepaymentExample example);

    int deleteByPrimaryKey(Integer repaymentId);

    int insert(SpsShopkeeperRepayment record);

    int insertSelective(SpsShopkeeperRepayment record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperRepayment record, @Param("example") SpsShopkeeperRepaymentExample example);

    int updateByExample(@Param("record") SpsShopkeeperRepayment record, @Param("example") SpsShopkeeperRepaymentExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperRepayment record);

    int updateByPrimaryKey(SpsShopkeeperRepayment record);
}