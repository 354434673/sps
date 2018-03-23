package com.sps.httpclient.merchant;

import java.math.BigDecimal;

public interface MerchantService {
	
	/**
	 * 商户开户认证
	 * @Title: init   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param businessId
	 * @param: @param totalQuota 授信总额度
	 * @param: @param monthQuota 每月授信额度
	 * @param: @param firstMonthQuota 首月授信额度
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月6日 下午2:04:35
	 * @return: String      
	 * @throws
	 */
	String init(String businessId, Double totalQuota, Double monthQuota, Double firstMonthQuota);
}
