/*package com.sps.service.merchant;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.entity.merchant.SpsChannelBusiness;
*//**
 * 商户相关api
 * @ClassName:  MerchantApi   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年2月8日 上午11:56:46
 *//*
@RestController
@RequestMapping("/api/merchant")
public class MerchantApi{
	@Reference
	private ChannelReadService channelRead;
	*//**
	 * 获得商户列表(目前只有一个)
	 * @Title: queryMerchant   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param businessProduct
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月8日 上午11:57:02
	 * @return: HashMap<String,Object>      
	 * @throws
	 *//*
	@RequestMapping(value = "/queryMerchant", method = RequestMethod.POST)
	public HashMap<String, Object> queryMerchant(List<String> businessProduct, Integer picType) {
		HashMap<String, Object> queryBusinessForApi = new HashMap<String, Object>() ;
		try {
			queryBusinessForApi = channelRead.queryBusinessForApi(businessProduct, picType);
		} catch (Exception e) {
			queryBusinessForApi.put("code", 1);
			queryBusinessForApi.put("msg", "异常");
			queryBusinessForApi.put("state", FinalData.STATE_ERROR);
			queryBusinessForApi.put("count", 0);
			e.printStackTrace();
		}
		return queryBusinessForApi;
	}

}
*/