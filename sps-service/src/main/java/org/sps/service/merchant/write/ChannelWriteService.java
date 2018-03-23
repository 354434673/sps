package org.sps.service.merchant.write;

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
/*
 * 写相关
 */
public interface ChannelWriteService{
	
	HashMap<String, String> insertAll(SpsChannel channel, 
			SpsChannelEnterprise enterprise, 
			SpsChannelBusiness business, 
			SpsChannelGuarantee guarantee,
			SpsChannelFinanceTarget financeTarget,
			SpsChannelLogistics logistics , 
			SpsChannelOpenAccount openAccount);
	/**
	 * 添加商户基本信息
	 * @Title: insertChanel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel 
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 上午10:48:59
	 * @return: int      
	 * @throws
	 */
	HashMap<String, String> insertChanel(SpsChannel channel);
	/**
	 * 添加企业基本信息
	 * @Title: insertEnterprise   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param enterprise
	 * @param: @param channelNum 外键
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 上午10:48:07
	 * @return: int      
	 * @throws
	 */
	HashMap<String, String> insertEnterprise(SpsChannelEnterprise enterprise, String channelNum);
	/**
	 * 添加业务信息
	 * @Title: insertBusiness   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param business
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午4:47:07
	 * @return: int      
	 * @throws
	 */
	HashMap<String, String> insertBusiness(SpsChannelBusiness business, String channelNum);
	/**
	 * 添加收款信息
	 * @Title: insertGather   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param gather 
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 上午10:59:33
	 * @return: int      
	 * @throws
	 */
	HashMap<String, Object> insertGather(SpsChannelGather gather);
	/**
	 * 添加物流信息
	 * @Title: insertLogistics   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param logistics
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午4:51:33
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> insertLogistics(SpsChannelLogistics logistics, String channelNum);
	/**
	 * 添加担保信息
	 * @Title: insertGuarantee   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param guarantee
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午4:54:24
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> insertGuarantee(SpsChannelGuarantee guarantee, String channelNum);
	/**
	 * 添加财务指标
	 * @Title: insertFinanceTarget   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param financeTarget
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午4:56:06
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> insertFinanceTarget(SpsChannelFinanceTarget financeTarget, String channelNum);
	/**
	 * 开户信息
	 * @Title: insertOpenAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param account
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月8日 下午5:23:24
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> insertOpenAccount(SpsChannelOpenAccount account, String channelNum);
	/**
	 * 删除商户(逻辑删除)
	 * @Title: deleteChannel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月25日 下午5:07:26
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> deleteChannel(String channelNum, Integer state);
}
