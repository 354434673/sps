package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoodSku;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodSkuMapper extends ApiBaseDaoImpl<SpsGoodSku, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodSku";
    }

    public void deleteSku(Integer goodsId) {
        super.selectOne(getStatement("deleteSku"),goodsId);
    }

    public List<SpsGoodSku> findList(Map<String, Object> map) {
        return super.selectList("getGoodList", map);
    }

    public int updateByGoodsId(SpsGoodSku spsGoodSku) {
        return super.updateByValue("updateGoodSkuDelete", spsGoodSku);
    }
}