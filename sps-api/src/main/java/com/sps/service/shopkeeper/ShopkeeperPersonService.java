package com.sps.service.shopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.vo.SpsShopFindPersonInfoVo;

import java.util.List;
import java.util.Map;

public interface ShopkeeperPersonService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsShopkeeperPersonal spsShopkeeperPersonal);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsShopkeeperPersonal findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsShopkeeperPersonal> findList(Map<String, Object> map);


    SpsShopFindPersonInfoVo findEntityByCustomerNum(String customerNum);
}
