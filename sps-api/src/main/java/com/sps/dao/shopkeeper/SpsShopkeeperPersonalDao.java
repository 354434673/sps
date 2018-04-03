package com.sps.dao.shopkeeper;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;
import com.sps.service.base.BaseDB;

public interface SpsShopkeeperPersonalDao extends BaseDB<SpsShopkeeperPersonal> {

  SpsShopkeeperPersonal getByPersonId(@Param("id") Integer id);

  /**
   * 根据客户户编号获取客户名称
   * @param customerId
   * @return
   */
  SpsShopkeeperPersonal   selectByPersonId(@Param("customerId") String customerId);

    int  saveSrc(@Param("id") Integer id, @Param("src") String src);
    int updateNickName(@Param("id") Integer id, @Param("nickName") String nickName);
    
    int insertSelective(SpsShopkeeperPersonal personal);
    
    int updateByExampleSelective(@Param("record") SpsShopkeeperPersonal record, @Param("example") SpsShopkeeperPersonalExample example);

    SpsShopkeeperPersonal selectById(@Param("id") Integer id);

}
