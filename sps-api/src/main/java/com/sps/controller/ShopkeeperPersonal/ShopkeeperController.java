package com.sps.controller.ShopkeeperPersonal;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import org.springframework.web.bind.annotation.*;

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
	 * 风控小B回调接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/shopkeeperCallback", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo orderCallback(@RequestBody Map<String,Object> map) {
		ReturnInfo ri =  Common.validate(map, "approveNo","status","customerId");
		if ("0".equals(ri.getCode())) return ri;
		try {
			shopkeeperService.updateStatus(map);
			ri.setSuccess(Message.SUCCESS_MSG);
			ri.setCode(Message.SUCCESS_CODE);
			ri.setMsg(Message.API_SUCCESS_MSG);
		} catch (Exception e) {
			e.printStackTrace();
			ri.setCode(Message.FAILURE_CODE);
			ri.setMsg(Message.FAILURE_MSG);
			ri.setSuccess(Message.API_ERROR_FLAG);
		}
		return ri;
	}


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
	/**
	 * 查询邀请列表
	 * @Title: queryInvitationList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param salemanPhone
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年3月22日 下午1:36:18
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping("/queryInvitationList")
	public HashMap<String, Object> queryInvitationList(String  salemanPhone){
		
		return shopkeeperService.queryInvitationList(salemanPhone);
	}
}
