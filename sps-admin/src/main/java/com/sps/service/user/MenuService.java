package com.sps.service.user;

import java.util.HashMap;
import java.util.List;

import com.sps.util.MenuUtil;

public interface MenuService {
	/**
	 * 获得菜单
	 * @Title: getMenu   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月22日 下午6:34:45
	 * @return: List<MenuUtil>   
	 * @throws
	 */
	List<MenuUtil> getMenu();
	/**
	 * 获取特定格式的菜单格式
	 * @Title: getSpecificMenu   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月28日 下午6:30:24
	 * @return: List<HashMap<String,Object>>      
	 * @throws
	 */
	List<MenuUtil> getSpecificMenu();
}
