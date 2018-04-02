package com.sps.service.merchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	HashMap<String,Object> queryMerchantDetail(Integer enterpriseId ,Integer categoryId, String orderType, String goodsName,String shopkeeperCustomerId);

	/**
	 * 修改状态
	 * @param map
	 * @return
	 */
    int updateStatus(Map<String, Object> map);

	/**
	 * 首页搜索
	 * @param shopkeeperCustomerid
	 * @return
	 */
	HashMap<String,Object> homeSearch(String shopkeeperCustomerid, String keyWord);
}
