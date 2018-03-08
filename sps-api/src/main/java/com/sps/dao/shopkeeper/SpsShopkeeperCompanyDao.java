package com.sps.dao.shopkeeper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperCompanyExample;
import com.sps.service.base.ServiceBase;

public interface SpsShopkeeperCompanyDao extends ServiceBase<SpsShopkeeperCompanyExample, SpsShopkeeperCompany>{
	/**
	 * 根据客户编号查询用户收货相关信息
	 * @Title: queryCompanyJoin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param customerId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月5日 下午2:36:07
	 * @return: SpsShopkeeperCompany      
	 * @throws
	 */
	SpsShopkeeperCompany queryCompanyJoin(@Param("customerId")String customerId);
}