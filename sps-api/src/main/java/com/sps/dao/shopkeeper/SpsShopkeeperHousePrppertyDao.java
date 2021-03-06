package com.sps.dao.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.base.BaseDB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cailing on 2018-02-27.
 * 个人信息的Dao
 */
public interface SpsShopkeeperHousePrppertyDao extends BaseDB<SpsShopkeeperPersonal> {
    /**
     * 保存房屋基本信息的方法
     * @param hourse
     * @return
     */
    int  saveHouseInfo(SpsShopkeeperHouseProperty hourse);
    
    int insertSelective(SpsShopkeeperHouseProperty record);

    /**根据客户编号获取房子信息
     * @param customerId
     * @return
     */
    List<SpsShopkeeperHouseProperty> selectByCustomerId(String customerId);
}
