package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCompany;
import org.sps.entity.shopkeeper.SpsShopkeeperCompanyExample;

public interface SpsShopkeeperCompanyReadMapper {
    int countByExample(SpsShopkeeperCompanyExample example);

    List<SpsShopkeeperCompany> selectByExample(SpsShopkeeperCompanyExample example);

    SpsShopkeeperCompany selectByPrimaryKey(Integer companyId);
}