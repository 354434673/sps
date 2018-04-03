package com.sps.service.shopkeeper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperCredit;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import com.sps.entity.shopkeeper.SpsShopkeeperTaking;

import io.swagger.models.auth.In;

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
	 * 根据业务员的手机号查询相关的
	 * @Title: queryInvitationList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salemanPhone
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月19日 下午6:33:19
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> queryInvitationList(String salemanPhone);
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
	
	int insertSpsShopkeeperPicForEach(String clientNum, String pic, Integer type);
	
	HashMap<String, Object> insertShopkeeperInvitation(SpsShopkeeperInvitation invitation);
	
	SpsShopkeeperInvitation queryInvitation(String phone);

	/**
	 * 根据登录用户获取shopkeeperCustomerid
	 * @param loginName
	 * @return
	 */
	String queryByLoginName(String loginName);


	int updateStatus(Map<String, Object> map);
	/**
	 * 根据客户编号和卡号查询是否存在
	 * @Title: queryRepayment   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param clientNum
	 * @param: @param bankId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月3日 下午2:36:13
	 * @return: SpsShopkeeperRepayment      
	 * @throws
	 */
	HashMap<String, Object> queryRepayment(String clientNum, String bankId);
}
