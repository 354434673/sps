package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class SpsShopkeeperContactMapper extends ApiBaseDaoImpl<SpsShopkeeperContact, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsShopkeeperContact";
    }
    public List<SpsShopkeeperContact> findByCustomerNum(String shopkeeperNum) {
        return super.selectList(getStatement("findByNum"),shopkeeperNum);
    }
}