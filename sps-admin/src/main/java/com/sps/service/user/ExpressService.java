package com.sps.service.user;

import java.util.HashMap;

/**
 * 物流
 * @ClassName:  ExpressService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月12日 下午7:47:20
 */
public interface ExpressService {
	/**
	 * 获取全部物流
	 * @Title: getExpress   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午7:49:04
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String,Object> getExpress(String name, Integer page, Integer limit);
}
