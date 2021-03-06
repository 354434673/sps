package com.sps.dao.shopkeeper;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;
import com.sps.service.base.BaseDB;

import java.util.Date;

public interface SpsShopkeeperPersonalDao extends BaseDB<SpsShopkeeperPersonal> {

 /* SpsShopkeeperPersonal getByPersonId(@Param("customerId") String customerId);*/

  /**
   * 根据客户户编号获取客户名称
   * @param customerId
   * @return
   */
  SpsShopkeeperPersonal   selectByPersonId(@Param("customerId") String customerId);
    int updateNickName(@Param("customerId") String customerId, @Param("nickName") String nickName,@Param("updateTime") Date updateTime);
    int insertSelective(SpsShopkeeperPersonal personal);
    int updateByExampleSelective(@Param("record") SpsShopkeeperPersonal record, @Param("example") SpsShopkeeperPersonalExample example);
    SpsShopkeeperPersonal selectById(@Param("id") Integer id);

}
