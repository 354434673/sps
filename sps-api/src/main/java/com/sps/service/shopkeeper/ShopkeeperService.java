package com.sps.service.shopkeeper;

import java.util.HashMap;
import java.util.List;

import com.sps.entity.shopkeeper.SpsShopkeeper;

public interface ShopkeeperService {
	/**
	 * 根据关联键查询
	 * @Title: queryShopkeeperList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月12日 下午3:59:51
	 * @return: List<SpsShopkeeper>      
	 * @throws
	 */
	SpsShopkeeper queryShopkeeperList(String shopkeeperCustomerid);
	/**
	 * 判断用户状态
	 * @Title: queryAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param customerId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月3日 下午3:59:16
	 * @return: boolean      
	 * @throws
	 */
	boolean queryAccount(String customerId);
	
	
	
}
