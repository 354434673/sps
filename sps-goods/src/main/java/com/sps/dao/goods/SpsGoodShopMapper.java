package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.entity.goods.SpsGoods;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodShopMapper extends BaseDaoImpl<SpsGoodShop, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodShop";
    }

    public Integer getSpuCount(Map<String, Object> map) {
        return super.selectOne(getStatement("getSpuCount"),map);
    }

    public SpsGoodShop findLastId() {
        return super.selectOne(getStatement("findLastId"),null);
    }

    public List<SpsGoodShop> findAuditGoodsList(Map<String, Object> map) {
        return super.selectList("findAuditGoodsList", map);
    }

    public List<SpsGoodShop> findForceGoodsList(Map<String, Object> map) {
        return super.selectList("findForceGoodsList", map);
    }
}