package com.sps.controller.merchant;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.entity.merchant.SpsChannelBusiness;
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
	public HashMap<String, Object> queryMerchant(@RequestBody String data) {
		
		HashMap<String, Object> queryMerchantList = enterpriseService.queryMerchantList(data);
		
		return queryMerchantList;
	}

}
