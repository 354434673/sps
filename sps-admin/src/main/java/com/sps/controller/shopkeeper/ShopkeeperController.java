package com.sps.controller.shopkeeper;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
/**
 * 店主相关控制层
 * @ClassName:  ShopkeeperController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月30日 下午5:37:03
 */
@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController {
	@Reference(group="dianfu-dev")
	private ShopkeeperReadService readService;
	@Reference(group="dianfu-dev")
	private ShopkeeperWriteService writeService;
	/**
	 * 查询店主列表
	 * @Title: getShopkeeperList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param account
	 * @param: @param shopkeeperName
	 * @param: @param shopkeeperState
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午5:37:00
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperList.json")
	public @ResponseBody HashMap<String, Object> getShopkeeperList(Integer page, Integer limit, 
			String account, String shopkeeperName, Integer shopkeeperState){
		
		HashMap<String, Object> shopkeeperList = readService.getShopkeeperList(
				page, limit, account, shopkeeperName, shopkeeperState);
		
		return shopkeeperList;
	}
	/**
	 * 查找申请信息
	 * @Title: getShopkeeper   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月30日 下午8:26:39
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeper")
	public @ResponseBody HashMap<String, Object> getShopkeeper(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeper(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperCompany")
	public @ResponseBody HashMap<String, Object> getShopkeeperCompany(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperCompany(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperCarProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperCarProperty(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperCarProperty(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperContact")
	public @ResponseBody HashMap<String, Object> getShopkeeperContact(String shopkeeperCustomerid, Integer page, Integer limit){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperContact(shopkeeperCustomerid, page, limit);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperCredit")
	public @ResponseBody HashMap<String, Object> getShopkeeperCredit(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperCredit(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperHouseProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperHouseProperty(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperHouseProperty(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperPersonal")
	public @ResponseBody HashMap<String, Object> getShopkeeperPersonal(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperPersonal(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperRepayment")
	public @ResponseBody HashMap<String, Object> getShopkeeperRepayment(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperRepayment(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperPic")
	public @ResponseBody HashMap<String, Object> getShopkeeperPic(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperPic(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/getShopkeeperAccount")
	public @ResponseBody HashMap<String, Object> getShopkeeperAccount(String shopkeeperCustomerid){
		
		HashMap<String, Object> shopkeeper = readService.getShopkeeperAccount(shopkeeperCustomerid);
		
		return shopkeeper;
	}
	@RequestMapping("/updateAccount")
	public @ResponseBody HashMap<String, Object> updateAccount(String shopkeeperCustomerid, SpsShopkeeperAccount account){
		
		HashMap<String, Object> updateAccount = writeService.updateAccount(shopkeeperCustomerid, account);
		
		return updateAccount;
	}
}
