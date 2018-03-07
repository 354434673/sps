package com.sps.controller.authentication;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.PropertyUtil;

@RestController
@RequestMapping("/authentication")
public class IdCardController {
	@Reference(group = "auth_dev1")
	private FaceAuthApi faceAuthApi;
	
	@RequestMapping("/authFaceIdCard")
	public JsonResult<AuthFaceIdCard> authBackIdCard(){
		PropertyUtil.getProperty("dubbo.group");
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		arg0.setBackImagePath("OssConstant.FILE_PATH");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
		return backIdCardResult;
	}
}
