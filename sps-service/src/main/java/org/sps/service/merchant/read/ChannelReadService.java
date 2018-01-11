package org.sps.service.merchant.read;

import java.util.HashMap;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelGather;

public interface ChannelReadService {
	/**
	 * 获得所有核心商户
	 * @Title: getChannelList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午8:15:44
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> getChannelList(String channelNum, Integer channelState, 
			Integer channelFlowState, Integer page, Integer limit);
	/**
	 * 根据营业执照编号查询
	 * @Title: getChannel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param enterprise
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月10日 下午5:46:37
	 * @return: SpsChannel      
	 * @throws
	 */
	SpsChannelEnterprise getChannel(SpsChannelEnterprise enterprise);
	/**
	 * 获得收款信息列表
	 * @Title: getGatherList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月9日 下午8:36:22
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> getGatherList(Integer page, Integer limit, String channelNum);
	/**
	 * 根据身份证,银行卡和外键查询是否添加过
	 * @Title: getGather   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param gather
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月10日 下午5:46:46
	 * @return: SpsChannelGather      
	 * @throws
	 */
	SpsChannelGather getGather(SpsChannelGather gather);
}
