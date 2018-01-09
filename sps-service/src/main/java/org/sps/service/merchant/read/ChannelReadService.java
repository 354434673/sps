package org.sps.service.merchant.read;

import java.util.HashMap;

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
			Integer page, Integer limit);
}
