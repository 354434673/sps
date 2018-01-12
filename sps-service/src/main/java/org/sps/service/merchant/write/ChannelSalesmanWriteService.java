package org.sps.service.merchant.write;

import java.util.HashMap;

import org.sps.entity.merchant.SpsChannelSalesman;

public interface ChannelSalesmanWriteService {
	/**
	 * 添加业务员
	 * @Title: insertSalesman   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesman
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午2:59:24
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> insertSalesman(SpsChannelSalesman salesman);
}
