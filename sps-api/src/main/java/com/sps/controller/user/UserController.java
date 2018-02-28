package com.sps.controller.user;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	/**
	 * 用户认证,调核心接口
	 * @Title: authentication   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月28日 下午4:35:32
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/authentication")
	public HashMap<String, Object> authentication(){
		//TODO : 核心方接口
		return null;
	}
}
