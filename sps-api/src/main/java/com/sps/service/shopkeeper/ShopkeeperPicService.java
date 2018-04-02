package com.sps.service.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperPic;

import java.util.List;
import java.util.Map;

public interface ShopkeeperPicService {
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsShopkeeperPic> findList(String shopkeeperNum);


    SpsShopkeeperPic findByCustomerNum(String shopkeeperNum);
}
