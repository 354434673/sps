package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsShopkeeperCompanyMapper extends ApiBaseDaoImpl<SpsShopkeeperCompany, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsShopkeeperCompany";
    }

    public SpsShopkeeperCompany findByCustomerNum(String shopkeeperNum) {
        return super.selectOne(getStatement("findByNum"),shopkeeperNum);
    }
}