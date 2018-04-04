package com.sps.dao.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperPicExample;
import com.sps.service.base.ServiceBase;
import org.apache.ibatis.annotations.Param;

public interface SpsShopkeeperPicDao extends ServiceBase<SpsShopkeeperPicExample, SpsShopkeeperPic>{
    int insertHouseUrl(SpsShopkeeperPic spsShopkeeperPic);
    //根据客户编号查询呢头像信息
    SpsShopkeeperPic selectByCustomerId(String customerId);
    int  saveSrc(@Param("id") Integer id, @Param("src") String src);
}