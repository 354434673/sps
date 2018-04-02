package com.sps.dao.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.service.base.ServiceBase;

public interface SpsShopkeeperDao extends ServiceBase<SpsShopkeeperExample, SpsShopkeeper>{
    /**
     * 根据登录用户获取shopkeeperCustomerId
     * @param userName
     * @return
     */
    String selectByLoginName(String userName);
}