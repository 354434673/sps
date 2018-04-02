package com.sps.controller.merchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import org.springframework.web.bind.annotation.*;
import com.sps.service.merchant.EnterpriseService;
/**
 * 商户相关api
 * @ClassName:  MerchantApi   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年2月8日 上午11:56:46
 */
@RestController
@RequestMapping("/api/merchant")
public class MerchantApi{
	@Resource
	private EnterpriseService enterpriseService;



	/**
	 * 风控小B回调接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/channelCallback", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo orderCallback(@RequestBody Map<String,Object> map) {
		ReturnInfo ri =  Common.validate(map, "status","customerId");
		if ("0".equals(ri.getCode())) return ri;
		try {
			enterpriseService.updateStatus(map);
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
	 * 获得商户列表(目前只有一个)
	 * @Title: queryMerchant
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param businessProduct
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月8日 上午11:57:02
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/queryMerchant", method = RequestMethod.POST)
		public HashMap<String, Object> queryMerchant(String shopkeeperCustomerid) {
		
		HashMap<String, Object> queryMerchantList = enterpriseService.queryMerchantList(shopkeeperCustomerid);
		
		return queryMerchantList;
	}


	/**
	 * 首页搜索(目前只有一个)
	 * @Title: queryMerchant
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param businessProduct
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年2月8日 上午11:57:02
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value = "/homeSearch", method = RequestMethod.POST)
	public HashMap<String, Object> homeSearch(String shopkeeperCustomerid,String keyWord) {

		HashMap<String, Object> queryMerchantList = enterpriseService.homeSearch(shopkeeperCustomerid,keyWord);

		return queryMerchantList;
	}
	/**
	 * 获得商户列表(目前只有一个)
	 * @Title: queryMerchant
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param businessProduct
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年2月8日 上午11:57:02
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value = "/queryMerchantDetail", method = RequestMethod.POST)
	public HashMap<String, Object> queryMerchantDetail(Integer enterpriseId ,Integer categoryId, String orderType, String goodsName,String shopkeeperCustomerId) {

		HashMap<String, Object> queryMerchantDetail = enterpriseService.queryMerchantDetail(enterpriseId, categoryId, orderType, goodsName,shopkeeperCustomerId);

		return queryMerchantDetail;
	}

}
