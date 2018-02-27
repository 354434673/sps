package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoodShopSku;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodShopSkuMapper extends ApiBaseDaoImpl<SpsGoodShopSku, Integer> {
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

    public int updateByGoodsId(SpsGoodShopSku spsGoodShopSku) {
        return super.updateByValue("updateGoodShopSkuDelete", spsGoodShopSku);
    }
}