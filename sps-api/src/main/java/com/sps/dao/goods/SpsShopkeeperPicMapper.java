package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class SpsShopkeeperPicMapper extends ApiBaseDaoImpl<SpsShopkeeperPic, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsShopkeeperPic";
    }
    public List<SpsShopkeeperPic> findByCustomerNum(String shopkeeperNum) {
        return super.selectList(getStatement("findByNum"),shopkeeperNum);
    }
}