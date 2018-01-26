package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoodSku;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodSkuLogMapper extends BaseDaoImpl<SpsGoodSku, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodSkuLog";
    }


}