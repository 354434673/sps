package com.sps.service.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;

import java.util.List;
import java.util.Map;

public interface ShopkeeperCompanyService {
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsShopkeeperCompany> findList(Map<String, Object> map);

    SpsShopkeeperCompany findByCustomerNum(String shopkeeperNum);
}
