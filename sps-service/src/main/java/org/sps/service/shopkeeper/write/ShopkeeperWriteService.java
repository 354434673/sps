package org.sps.service.shopkeeper.write;

import java.util.HashMap;

import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;

public interface ShopkeeperWriteService {
	/**
	 * 修改账户信息
	 * @Title: updateAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @param account
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月31日 下午2:11:41
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	public HashMap<String, Object> updateAccount(String shopkeeperCustomerid, SpsShopkeeperAccount account);
	/**
	 * 修改店主状态
	 * @Title: updateState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月2日 上午11:50:30
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	public HashMap<String, Object> updateState(String shopkeeperCustomerid, Integer state);
	/**
	 * @throws Exception 
	 * 店主邀请增加功能
	 * @Title: insertInvitation   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param invitation
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月3日 下午2:32:11
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	public HashMap<String, Object> insertInvitation(SpsShopkeeperInvitation invitation, String channelNum);
	/**
	 * 添加多次店主
	 * @Title: insertManyInvitation   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param invitation
	 * @param: @return
	 * @param: @throws Exception  
	 * @author YangNingSheng    
	 * @date 2018年2月3日 下午2:37:08
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	public HashMap<String, Object> insertManyInvitation(SpsShopkeeperInvitation invitation) throws Exception;
}
