package com.sps.service.shopkeeper;

import java.util.HashMap;
import java.util.List;

import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperCredit;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import com.sps.entity.shopkeeper.SpsShopkeeperTaking;

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
	/**
	 * 更改店主邀请状态
	 * @Title: updateShopkeeperState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param customerId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月14日 下午5:18:30
	 * @return: int      
	 * @throws
	 */
	int updateShopkeeperState(Integer state, String customerId);
	/**
	 * 更改店主状态
	 * @Title: updateShopkeeperInvitationState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param phone
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月14日 下午5:18:39
	 * @return: int      
	 * @throws
	 */
	int updateShopkeeperInvitationState(String state, String phone);
	
	int insertShopkeeper(SpsShopkeeper shopkeeper);
	
	int insertsShopkeeperCarProperty(SpsShopkeeperCarProperty carProperty);
	
	int insertShopkeeperCompany(SpsShopkeeperCompany company);
	
	int insertSpsShopkeeperContact(SpsShopkeeperContact contact);
	
	int insertSpsShopkeeperCredit(SpsShopkeeperCredit credit);
	
	int insertSpsShopkeeperHouseProperty(SpsShopkeeperHouseProperty houseProperty);
	
	int insertSpsShopkeeperPersonal(SpsShopkeeperPersonal personal);
	
	int insertSpsShopkeeperPic(SpsShopkeeperPic pic);
	
	int insertSpsShopkeeperRepayment(SpsShopkeeperRepayment repayment);
	
	int insertSpsShopkeeperTaking(SpsShopkeeperTaking taking);
	
	int updateSpsShopkeeperPersonal(SpsShopkeeperPersonal personal);
	
	int updateShopkeeper(SpsShopkeeper shopkeeper);
}
