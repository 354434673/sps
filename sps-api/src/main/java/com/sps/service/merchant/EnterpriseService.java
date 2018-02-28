package com.sps.service.merchant;

import java.util.HashMap;
import java.util.List;

import com.sps.entity.merchant.SpsChannelEnterprise;

public interface EnterpriseService {
	/**
	 * app首页商户列表
	 * @Title: queryMerchantList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月11日 下午5:10:04
	 * @return: List<SpsChannelEnterprise>      
	 * @throws
	 */
	HashMap<String, Object> queryMerchantList(String data);
	/**
	 * 商铺详情
	 * @Title: queryMerchantDetail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年2月11日 下午5:10:04
	 * @return: List<SpsChannelEnterprise>
	 * @throws
	 */
	HashMap<String,Object> queryMerchantDetail(String data);
}
