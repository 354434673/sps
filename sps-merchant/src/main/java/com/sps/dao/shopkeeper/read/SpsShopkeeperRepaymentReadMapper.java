package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import org.sps.entity.shopkeeper.SpsShopkeeperRepaymentExample;

public interface SpsShopkeeperRepaymentReadMapper {
    int countByExample(SpsShopkeeperRepaymentExample example);

    List<SpsShopkeeperRepayment> selectByExample(SpsShopkeeperRepaymentExample example);

    SpsShopkeeperRepayment selectByPrimaryKey(Integer repaymentId);
}