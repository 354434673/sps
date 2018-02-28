package com.sps.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.merchant.SpsChannelBusiness;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.entity.merchant.SpsChannelEnterpriseExample;
import com.sps.service.base.ServiceBase;

public interface ChannelEnterpriseDao extends ServiceBase<SpsChannelEnterpriseExample, SpsChannelEnterprise>{
	/**
	 * 根据登陆店主的主营业务,获得相对应的商户,提供api接口
	 * @Title: queryBusinessForApi   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param businessProduct 主营业务集合
	 * @param: @param picType 图片类型
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月27日 下午2:17:15
	 * @return: List<SpsChannelEnterprise>      
	 * @throws
	 */
    List<SpsChannelEnterprise> queryBusinessForApi(
		    		@Param("businessProduct") List<String> businessProduct, 
		    		@Param("picType")Integer picType,
		    		@Param("enterpriseId") Integer enterpriseId);
}
