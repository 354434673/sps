package com.sps.service.risk;

import org.sps.entity.merchant.SpsChannelSalesman;

/**
 * 推向风控接口
 * @ClassName:  RiskService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年4月4日 下午2:58:39
 */
public interface RiskService {
	/**
	 * 邀请业务后推向风控
	 * @Title: salesmanEntry   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesman  
	 * @author YangNingSheng    
	 * @date 2018年4月4日 下午2:59:51
	 * @return: void      
	 * @throws
	 */
	void salesmanEntry(SpsChannelSalesman salesman);
	
	void invitationEntry(String channelNum, String clientNum);
}
