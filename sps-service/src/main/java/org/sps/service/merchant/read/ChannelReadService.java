package org.sps.service.merchant.read;

import java.io.Serializable;
import java.util.HashMap;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelOpenAccount;

public interface ChannelReadService{
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
	HashMap<String, Object> getChannelList(String channelNum, String name, Integer channelState, 
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
	/**
	 * 获得该商户的基本信息
	 * @Title: getChannelOne   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午5:07:00
	 * @return: SpsChannelEnterprise      
	 * @throws
	 */
	SpsChannelEnterprise getChannelOne(String channelNum, String state);
	/**
	 * 查询该商户的担保信息
	 * @Title: getGuarantee   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:03:00
	 * @return: SpsChannelGuarantee      
	 * @throws
	 */
	SpsChannelGuarantee getGuarantee(String channelNum);
	/**
	 * 查询该商户的财务指标
	 * @Title: getFinanceTarget   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:06:14
	 * @return: SpsChannelFinanceTarget      
	 * @throws
	 */
	SpsChannelFinanceTarget getFinanceTarget(String channelNum);
	/**
	 * 查询该商户的物流配送
	 * @Title: getLogistics   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:06:24
	 * @return: SpsChannelLogistics      
	 * @throws
	 */
	SpsChannelLogistics getLogistics(String channelNum);
	/**
	 * 查询该用户的开户信息
	 * @Title: getOpenAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:07:09
	 * @return: SpsChannelOpenAccount      
	 * @throws
	 */
	SpsChannelOpenAccount getOpenAccount(String channelNum,String username);
	/**
	 * 查询该商户的业务信息
	 * @Title: getBusiness   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月18日 下午7:57:29
	 * @return: SpsChannelBusiness      
	 * @throws
	 */
	SpsChannelBusiness getBusiness(String channelNum);
}
