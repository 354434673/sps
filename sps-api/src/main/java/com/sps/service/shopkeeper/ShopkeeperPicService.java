package com.sps.service.shopkeeper;

import com.sps.entity.shopkeeper.SpsShopkeeperPic;

import java.util.List;
import java.util.Map;

public interface ShopkeeperPicService {
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsShopkeeperPic> findList(String shopkeeperNum);
    /**
     * 根据客户编号和类型查图片集合
     * @Title: queryListForTypeAndId   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param shopkeeperNum
     * @param: @return  
     * @author YangNingSheng    
     * @date 2018年4月3日 下午1:53:25
     * @return: List<SpsShopkeeperPic>      
     * @throws
     */
    List<SpsShopkeeperPic> queryListForTypeAndId(String shopkeeperNum, Integer type);


    SpsShopkeeperPic findByCustomerNum(String shopkeeperNum);
    
    
}
