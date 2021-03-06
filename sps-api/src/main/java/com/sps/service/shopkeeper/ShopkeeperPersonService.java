package com.sps.service.shopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;

import java.util.HashMap;
import java.util.List;
import com.sps.entity.shopkeeper.vo.SpsShopFindPersonInfoVo;import java.util.HashMap;import java.util.List;
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

    /**
     * 根据客户编号获取个人信息
     * @param consumerId
     * @return
     */
    SpsShopkeeperPersonal  findPerson(String  consumerId);
    Boolean  saveSrc(String  consumerId,String src);
    Boolean  updateNickName(String consumerId,String nickName);
    /**
     * 客户编号获取用户昵称与头像
     * @param consumerId
     * @return
     */
    SpsShopkeeperPersonal getByPersonId(String consumerId);
    /**
     * 根据客户编号获取车辆信息
     */
    List<SpsShopkeeperCarProperty> getCardInfo(String consumerId);
    /**根据客户编号获取房子信息
     *
     */
   List<SpsShopkeeperHouseProperty>  getHouseInfo(String consumerId);
    /**
     * 保存车辆信息
     * @param spsShopkeeperCarProperty
     * @return
     */
    Boolean  saveCarInfo(SpsShopkeeperCarProperty spsShopkeeperCarProperty,String src);

    /**
     * 保存房屋信息
     * @param spsShopkeeperHouseProperty
     * @return
     */
    Boolean  saveHouseInfo(SpsShopkeeperHouseProperty spsShopkeeperHouseProperty,List<String> lists);

    SpsShopkeeperPersonal findByCustomerNum(String shopkeeperNum);
}
