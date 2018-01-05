package com.sps.service.user;

import java.util.List;

import com.sps.entity.areas.Areas;

public interface AreasService {
	/**
	 * 获得省市级
	 * @Title: getAreasList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param parentId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月5日 下午5:37:49
	 * @return: List<Areas>      
	 * @throws
	 */
	List<Areas> getAreasList(String parentId);
}