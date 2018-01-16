package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoodShopSku;
import org.sps.entity.goods.SpsGoods;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodShopSkuMapper extends BaseDaoImpl<SpsGoodShopSku, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodShopSku";
    }

    public void deleteSku(Integer goodsId) {
        super.selectOne(getStatement("deleteSku"),goodsId);
    }
}