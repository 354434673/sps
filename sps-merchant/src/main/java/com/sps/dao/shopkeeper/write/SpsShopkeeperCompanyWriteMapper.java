package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperCompany;
import org.sps.entity.shopkeeper.SpsShopkeeperCompanyExample;

public interface SpsShopkeeperCompanyWriteMapper {

    int deleteByExample(SpsShopkeeperCompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(SpsShopkeeperCompany record);

    int insertSelective(SpsShopkeeperCompany record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperCompany record, @Param("example") SpsShopkeeperCompanyExample example);

    int updateByExample(@Param("record") SpsShopkeeperCompany record, @Param("example") SpsShopkeeperCompanyExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperCompany record);

    int updateByPrimaryKey(SpsShopkeeperCompany record);
}