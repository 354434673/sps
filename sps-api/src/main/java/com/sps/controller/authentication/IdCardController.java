package com.sps.controller.authentication;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.entiy.AuthBasicDetail;
import com.jzfq.auth.core.api.entiy.AuthHouseDetail;
import com.jzfq.auth.core.api.entiy.AuthIousDetail;
import com.jzfq.auth.core.api.entiy.AuthLinkDetail;
import com.jzfq.auth.core.api.entiy.AuthStoreDetail;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;


@RestController
@RequestMapping("/authentication")
public class IdCardController {
/*	@Reference(group = "${dubbo.group}")
	private FaceAuthApi faceAuthApi;*/
	@Resource
	private FaceAuthApi faceAuthApi;
	@Resource
	private JzfqAuthApi jzfqAuthApi;
	
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
	public JsonResult<AuthFaceIdCard> authBackIdCard(String imagePath, String channel, String requestNo, String source, String userId){
		
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
	public JsonResult<AuthFaceIdCard> authFrontIdCard(String imagePath, String channel, String requestNo, String source, String userId){
		
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		
		arg0.setBackImagePath("http://img.zcool.cn/community/01638059302785a8012193a36096b8.jpg@2o.jpg");
		
		arg0.setChannel("DF");
		
		arg0.setRequestNo("12321312");
		
		arg0.setSource("h5");
		
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getFrontIdCardResult(arg0);
		
		return backIdCardResult;
	}
	/** 认证保存通讯录信息
	 * @Title: saveLinkDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 下午1:49:43
	 * @return: JsonResult<AuthFaceIdCard>      
	 * @throws   
	 */  
	@RequestMapping("/saveLinkDetail")
	public JsonResult saveLinkDetail(String channel, String effectiveTime, 
			String linkInfoF, String linkInfoT, Integer source, 
			String productLine, Integer type, Integer userId){
		AuthLinkDetail arg0 = new AuthLinkDetail();
		
		arg0.setChannel(channel);
		
		arg0.setEffectiveTime(effectiveTime);
		
		arg0.setLinkInfoF(linkInfoF);
		
		arg0.setLinkInfoT(linkInfoT);
		
		arg0.setProductLine(productLine);
		
		arg0.setSource(source);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveLinkDetail(arg0);
		
		return saveLinkDetail;
	}
	/**
	 * 认证保存车辆信息
	 * @Title: saveIousDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param effectiveTime
	 * @param: @param linkInfoF
	 * @param: @param linkInfoT
	 * @param: @param source
	 * @param: @param productLine
	 * @param: @param type
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 下午2:07:42
	 * @return: JsonResult<AuthFaceIdCard>      
	 * @throws
	 */
	@RequestMapping("/saveIousDetail")
	public JsonResult saveIousDetail(String channel, String plateType, 
			String plateTypeStr, String frameNumber, Integer source, 
			String productLine, Integer type, Integer userId){
		
		AuthIousDetail arg0 = new AuthIousDetail();
		
		arg0.setChannel(channel);
		
		arg0.setProductLine(productLine);
		
		arg0.setType(type);
		
		arg0.setPlateType(plateType);
		
		arg0.setPlateTypeStr(plateTypeStr);
		
		arg0.setFrameNumber(frameNumber);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveIousDetail(arg0 );
		
		return saveLinkDetail;
	}
	/**
	 * @return 
	 * 认证保存基本信息
	 * @Title: saveIousDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param plateType
	 * @param: @param plateTypeStr
	 * @param: @param frameNumber
	 * @param: @param source
	 * @param: @param productLine
	 * @param: @param type
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 下午2:16:06
	 * @return: JsonResult<AuthFaceIdCard>      
	 * @throws
	 */
	@RequestMapping("/saveBasicDetail")
	public JsonResult saveBasicDetail(Integer marriage, String liveAddress, 
			String liveA, String liveACode, String liveC, String liveCCode, String liveP, String livePCode, 
			Integer liveState, String productLine, Integer type, Integer userId){
		
		AuthBasicDetail arg0 = new AuthBasicDetail();
		
		arg0.setMarriage(marriage);
		
		arg0.setLiveState(liveState);
		
		arg0.setLiveAddress(liveAddress);
		
		arg0.setLiveA(liveA);
		
		arg0.setLiveACode(liveACode);
		
		arg0.setLiveC(liveC);
		
		arg0.setLiveCCode(liveCCode);
		
		arg0.setLiveP(liveP);

		arg0.setLivePCode(livePCode);
		
		arg0.setProductLine(productLine);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveBasicDetail(arg0);
		
		return saveLinkDetail;
	}
	@RequestMapping("/saveHouseDetail")
	public JsonResult saveHouseDetail(String companyName, 
			String storeName, String actualACode, String actualAName, String actualCCode, String actualCName, String actualPCode, 
			Integer liveState, String actualPName, Integer type, Integer userId){
		
		AuthStoreDetail arg0 = new AuthStoreDetail();
		
		arg0.setCompanyName(companyName);
		
		arg0.setStoreName(storeName);
		
		arg0.setActualACode(actualACode);

		arg0.setActualAName(actualAName);
		arg0.setActualCCode(actualCCode);
		arg0.setActualCName(actualCName);
		arg0.setActualPCode(actualPCode);
		arg0.setActualPName(actualPName);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveStoreDetail(arg0);
		
		return saveLinkDetail;
	}
}
