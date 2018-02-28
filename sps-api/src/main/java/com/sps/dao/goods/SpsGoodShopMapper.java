package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoodShop;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository
public class SpsGoodShopMapper extends ApiBaseDaoImpl<SpsGoodShop, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodShop";
    }

}