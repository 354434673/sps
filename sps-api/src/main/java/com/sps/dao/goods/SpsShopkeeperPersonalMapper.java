package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.vo.SpsShopFindPersonInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class SpsShopkeeperPersonalMapper extends ApiBaseDaoImpl<SpsShopkeeperPersonal, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsShopkeeperPersonal";
    }

    public SpsShopFindPersonInfoVo findEntityByCustomerNum(String customerNum)  {
        return super.selectOne(getStatement("findEntityByCustomerNum"),customerNum);
    }

    public SpsShopkeeperPersonal findByCustomerNum(String shopkeeperNum) {
        return super.selectOne(getStatement("findByCustomerNum"),shopkeeperNum);
    }
}