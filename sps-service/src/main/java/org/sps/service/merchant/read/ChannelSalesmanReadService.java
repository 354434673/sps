package org.sps.service.merchant.read;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.sps.entity.merchant.SpsChannelSalesman;

public interface ChannelSalesmanReadService{
	/**
	 * 获取业务员列表
	 * @Title: getSalesmanList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesman
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午3:05:13
	 * @return: List<SpsChannelSalesman>      
	 * @throws
	 */
	HashMap<String, Object> getSalesmanList(String salesmanName, String salesmanIdcard, 
			String salesmanPhone, String salesmanEmail, String bei1, Integer page, Integer limit);
	/**
	 * 根据身份证查询
	 * @Title: getSalesman   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesmanIdcard
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午3:20:23
	 * @return: SpsChannelSalesman      
	 * @throws
	 */
	SpsChannelSalesman getSalesman(String salesmanIdcard);
}
