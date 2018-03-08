package com.sps.controller.authentication;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.entiy.AuthLinkDetail;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.PropertyUtil;

@RestController
@RequestMapping("/authentication")
public class IdCardController {
/*	@Reference(group = "${dubbo.group}")
	private FaceAuthApi faceAuthApi;*/
	@Resource
	private FaceAuthApi faceAuthApi;
/*	@Resource
	private JzfqAuthApi jzfqAuthApi;*/
	/**
	 * 身份证反面认证
	 * @Title: authBackIdCard   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月7日 下午4:56:02
	 * @return: JsonResult<AuthFaceIdCard>      
	 * @throws
	 */
	@RequestMapping("/authBackIdCard")
	public JsonResult<AuthFaceIdCard> authBackIdCard(){
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		arg0.setBackImagePath("http://img.zcool.cn/community/01638059302785a8012193a36096b8.jpg@2o.jpg");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
		return backIdCardResult;
	}
	/**
	 * 身份证正面认证
	 * @Title: authFrontIdCard   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月7日 下午4:56:57
	 * @return: JsonResult<AuthFaceIdCard>      
	 * @throws
	 */
	@RequestMapping("/authFrontIdCard")
	public JsonResult<AuthFaceIdCard> authFrontIdCard(){
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		arg0.setBackImagePath("http://img.zcool.cn/community/01638059302785a8012193a36096b8.jpg@2o.jpg");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getFrontIdCardResult(arg0);
		return backIdCardResult;
	}
/*	@RequestMapping("/saveLinkDetail")
	public JsonResult<AuthFaceIdCard> saveLinkDetail(){
		AuthLinkDetail arg0 = new AuthLinkDetail();
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveLinkDetail(arg0);
		return saveLinkDetail;
	}*/
}
