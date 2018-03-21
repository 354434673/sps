package com.sps.controller.ShopkeeperPersonal;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.service.shopkeeper.ShopkeeperService;
/**
 * 店主相关接口
 * @ClassName:  ShopkeeperController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月19日 下午4:06:26
 */
@RestController
@RequestMapping("/shopeeker")
public class ShopkeeperController {
	@Resource
	private ShopkeeperService shopkeeperService;
	/**
	 * @return 
	 * 业务员邀请店主
	 * @Title: invitationShopkeeper   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:   
	 * @author YangNingSheng    
	 * @date 2018年3月19日 下午4:08:48
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/invitation")
	public HashMap<String, Object> invitationShopkeeper(SpsShopkeeperInvitation invitation){
		
		return shopkeeperService.insertShopkeeperInvitation(invitation);
	}
	@RequestMapping("/queryInvitationList")
	public HashMap<String, Object> queryInvitationList(String  salemanPhone){
		
		return shopkeeperService.queryInvitationList(salemanPhone);
	}
}
