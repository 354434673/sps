package com.sps.service.area;

import java.util.List;

import com.sps.entity.areas.Areas;
/**
 * 获得省市级service接口
 * @ClassName:  AreasService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月20日 下午4:42:17
 */
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
