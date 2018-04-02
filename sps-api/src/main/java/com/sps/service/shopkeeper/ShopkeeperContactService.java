package com.sps.service.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;

import java.util.List;
import java.util.Map;

public interface ShopkeeperContactService {
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsShopkeeperContact> findList(String shopkeeperNum);


    SpsShopkeeperContact findByCustomerNum(String shopkeeperNum);
}
