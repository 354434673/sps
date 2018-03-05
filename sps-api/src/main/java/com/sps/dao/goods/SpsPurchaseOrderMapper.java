package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsPurchaseOrder;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsPurchaseOrderMapper extends ApiBaseDaoImpl<SpsPurchaseOrder, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsPurchaseOrder";
    }
}