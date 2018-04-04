package com.sps.dao.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.base.BaseDB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cailing on 2018-02-27.
 * 个人信息的Dao
 */
public interface SpsShopkeeperCarPrppertyDao extends BaseDB<SpsShopkeeperPersonal> {
    /**
     * 根据用户id查询昵称与头像
     * @param car
     * @returnid
     */
    int  saveCarInfo(SpsShopkeeperCarProperty car);
    
    int insertSelective(SpsShopkeeperCarProperty record);

    /**
     * 根据客户编号获取车辆信息
     * @param customerId
     * @return
     */
    List<SpsShopkeeperCarProperty> selectByCustomerId(String customerId);
}
