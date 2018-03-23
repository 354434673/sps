package org.sps.service.shopkeeper.read;

import java.util.HashMap;
import java.util.List;

import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;

public interface ShopkeeperReadService {
	/**
	 * 查询符合条件的店主集合
	 * @Title: getShopkeeperList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param paeg
	 * @param: @param limit
	 * @param: @param account
	 * @param: @param shopkeeperName
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午3:11:29
	 * @return: List<SpsShopkeeper>      
	 * @throws
	 */
	HashMap<String,Object>  getShopkeeperList(Integer page, Integer limit, String account,
			String shopkeeperName, Integer shopkeeperState);
	/**
	 * 查找申请信息
	 * @Title: getShopkeeper   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:22:14
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeper(String shopkeeperCustomerid);
	/**
	 * 查找公司信息
	 * @Title: getShopkeeperCompany   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:22:27
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperCompany(String shopkeeperCustomerid);
	/**
	 * 查找联系人信息
	 * @Title: getShopkeeperContact   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:22:36
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperContact(String shopkeeperCustomerid, Integer page, Integer limit);
	/**
	 * 查找征信信息
	 * @Title: getShopkeeperCredit   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:23:07
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperCredit(String shopkeeperCustomerid);
	/**
	 * 查找房产信息
	 * @Title: getShopkeeperHouseProperty   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:23:19
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperHouseProperty(String shopkeeperCustomerid);
	/**
	 * 查找个人信息
	 * @Title: getShopkeeperPersonal   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:23:28
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperPersonal(String shopkeeperCustomerid);
	/**
	 * 查找车产信息
	 * @Title: getShopkeeperCarProperty   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:23:39
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperCarProperty(String shopkeeperCustomerid);
	/**
	 * 查找收人信息
	 * @Title: getShopkeeperRepayment   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:23:50
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperRepayment(String shopkeeperCustomerid);
	/**
	 * 无
	 * @Title: getShopkeeperTaking   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:24:02
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperTaking(String shopkeeperCustomerid);
	/**
	 * 查找图片信息
	 * @Title: getShopkeeperPic   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:24:26
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperPic(String shopkeeperCustomerid);
	/**
	 * 查询账户信息
	 * @Title: getShopkeeperAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月31日 下午2:03:04
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getShopkeeperAccount(String shopkeeperCustomerid);
	/**
	 * 查询店主邀请列表
	 * @Title: queryInvitationList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param name
	 * @param: @param phone
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月3日 下午2:58:38
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> queryInvitationList(Integer page, Integer limit, String name, String phone, String state);
	
	SpsShopkeeperInvitation queryInvitation(String name, String phone, String state);
	
	
	
	
}
