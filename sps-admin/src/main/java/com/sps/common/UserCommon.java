package com.sps.common;

import java.util.List;

import javax.annotation.Resource;

import com.sps.dao.user.SpsUserMapper;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;

/**
 * 获取用户相关工具
 * @ClassName:  UserCommon   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月19日 下午4:51:00
 */
public class UserCommon {
	
	@Resource
	private SpsUserMapper userMapper;
	/**
	 * 根据登录账号查询当前用户
	 * @Title: getUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userUserName
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月19日 下午4:53:36
	 * @return: SpsUser      
	 * @throws
	 */
	public SpsUser getUser(String userUserName){
		
		SpsUserExample example = new SpsUserExample();
		
		example.createCriteria().andUserUsernameEqualTo(userUserName);
		
		List<SpsUser> selectByExample = userMapper.selectByExample(example);
		
		return selectByExample.get(0);
	}
}
