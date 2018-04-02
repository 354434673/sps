package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class SpsShopkeeperPersonalMapper extends ApiBaseDaoImpl<SpsShopkeeperPersonal, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsShopkeeperPersonal";
    }

    public SpsShopkeeperPersonal findEntityByCustomerNum(String customerNum)  {
        return super.selectOne(getStatement("findEntityByCustomerNum"),customerNum);
    }

}