package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoodShopSku;
import org.sps.entity.goods.SpsGoods;

import java.util.List;
import java.util.Map;

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

    public List<SpsGoodShopSku> findList(Map<String, Object> map) {
        return super.selectList("findSkuList", map);
    }
}