package com.sps.controller.authentication;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juzifenqi.capital.entity.UserCard;
import com.juzifenqi.capital.service.IUserCardService;
import com.juzifenqi.core.ServiceResult;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.entiy.AuthBasicDetail;
import com.jzfq.auth.core.api.entiy.AuthHouseDetail;
import com.jzfq.auth.core.api.entiy.AuthIdentityDetail;
import com.jzfq.auth.core.api.entiy.AuthIousDetail;
import com.jzfq.auth.core.api.entiy.AuthLinkDetail;
import com.jzfq.auth.core.api.entiy.AuthStoreDetail;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;


@RestController
@RequestMapping("/authentication")
public class authenticationController {
/*	@Reference(group = "${dubbo.group}")
	private FaceAuthApi faceAuthApi;*/
	@Resource
	private FaceAuthApi faceAuthApi;
	@Resource
	private JzfqAuthApi jzfqAuthApi;
/*	@Resource
	private IUserCardService iUsercardService;*/
	
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
	public JsonResult<AuthFaceIdCard> authBackIdCard(String clientNum, String imagePath, String channel, String requestNo, String source, Integer userId){
		
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		
		arg0.setBackImagePath(imagePath);
		
		arg0.setChannel(channel);
		
		arg0.setRequestNo(requestNo);
		
		arg0.setSource(source);
		
		arg0.setUserId(userId);
		
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
	public JsonResult<AuthFaceIdCard> authFrontIdCard(String clientNum, String imagePath, String channel, String requestNo, String source, Integer userId){
		
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		
		arg0.setBackImagePath(imagePath);
		
		arg0.setChannel(channel);
		
		arg0.setRequestNo(requestNo);
		
		arg0.setSource(source);
		
		arg0.setUserId(userId);
		
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
	public JsonResult saveLinkDetail(String clientNum, String channel, String effectiveTime, 
			String linkInfoF, String linkInfoT, Integer source, 
			String productLine, Integer type, Integer userId){
		AuthLinkDetail arg0 = new AuthLinkDetail();
		
		arg0.setChannel(channel);
		
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
	public JsonResult saveIousDetail(String clientNum, String channel, String plateType, 
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
	 * 房产认证
	 * @Title: saveHouseDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param houseArea
	 * @param: @param houseACode
	 * @param: @param houseAName
	 * @param: @param houseCCode
	 * @param: @param houseCName
	 * @param: @param housePCode
	 * @param: @param housePName
	 * @param: @param productLine
	 * @param: @param houseAddress
	 * @param: @param type
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 下午3:55:57
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("/saveHouseDetail")
	public JsonResult saveHouseDetail(String clientNum, String channel, Integer houseArea, 
			String houseACode, String houseAName,String houseCCode,
			String houseCName,String housePCode, String housePName, 
			String productLine, String houseAddress,Integer type, Integer userId){
		
		AuthHouseDetail arg0 = new AuthHouseDetail();
		
		arg0.setChannel(channel);
		
		arg0.setHouseArea(houseArea);
		
		arg0.setHouseACode(houseACode);
		
		arg0.setHouseAName(houseAName);
		
		arg0.setHouseCCode(houseCCode);
		
		arg0.setHouseCName(houseCName);
		
		arg0.setHousePCode(housePCode);
		
		arg0.setHousePName(housePName);
		
		arg0.setHouseAddress(houseAddress);
		
		arg0.setProductLine(productLine);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveHouseDetail(arg0 );
		
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
	public JsonResult saveBasicDetail(String clientNum, String channel, Integer source, Integer marriage, String liveAddress, 
			String liveA, String liveACode, String liveC, String liveCCode, String liveP, String livePCode, 
			Integer liveState, String productLine, Integer type, Integer userId){
		
		AuthBasicDetail arg0 = new AuthBasicDetail();
		arg0.setChannel(channel);
		
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
		
		arg0.setSource(source);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveBasicDetail(arg0);
		
		return saveLinkDetail;
	}
	/**
	 * 认证保存身份证信息
	 * @Title: saveIdentityDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param source
	 * @param: @param marriage
	 * @param: @param liveAddress
	 * @param: @param liveA
	 * @param: @param liveACode
	 * @param: @param liveC
	 * @param: @param liveCCode
	 * @param: @param liveP
	 * @param: @param livePCode
	 * @param: @param liveState
	 * @param: @param productLine
	 * @param: @param type
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月13日 下午5:16:51
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("/saveIdentityDetail")
	public JsonResult saveIdentityDetail(String clientNum, String channel, Integer source, String certAddress, 
			String effectiveTime, String signingOrganization, String certNo, String name, 
			String productLine, Integer type, Integer userId){
		
		AuthIdentityDetail arg0 = new AuthIdentityDetail();
		
		arg0.setName(name);
		
		arg0.setCertNo(certNo);
		
		arg0.setSigningOrganization(signingOrganization);
		
		arg0.setEffectiveTime(effectiveTime);
		
		arg0.setCertAddress(certAddress);
		
		arg0.setChannel(channel);
		
		arg0.setProductLine(productLine);
		
		arg0.setSource(source);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveIdentityDetail(arg0);
		
		return saveLinkDetail;
	}
	/**
	 * 公司店铺认证
	 * @Title: saveStoreDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param companyName
	 * @param: @param storeName
	 * @param: @param actualACode
	 * @param: @param actualAName
	 * @param: @param actualCCode
	 * @param: @param actualCName
	 * @param: @param actualPCode
	 * @param: @param actualPName
	 * @param: @param ownerShip
	 * @param: @param actualAddress
	 * @param: @param actualArea
	 * @param: @param staffNum
	 * @param: @param operateModel
	 * @param: @param majorBrand
	 * @param: @param majorType
	 * @param: @param majorBusiness
	 * @param: @param type
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 下午3:57:08
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("/saveStoreDetail")
	public JsonResult saveStoreDetail(String clientNum, String channel, String companyName, String storeName,Integer source,  
			String actualACode, String actualAName, String actualCCode, String actualCName, String actualPCode, String actualPName,
			String ownerShip, String actualAddress, Integer actualArea, Integer staffNum, String operateModel,
			String majorBrand, String majorType, String majorBusiness, Integer type, Integer userId){
		
		AuthStoreDetail arg0 = new AuthStoreDetail();
		arg0.setChannel(channel);
		
		arg0.setCompanyName(companyName);
		
		arg0.setStoreName(storeName);
		
		arg0.setActualACode(actualACode);

		arg0.setActualAName(actualAName);
		
		arg0.setActualCCode(actualCCode);
		
		arg0.setActualCName(actualCName);
		
		arg0.setActualPCode(actualPCode);
		
		arg0.setActualPName(actualPName);
		
		arg0.setActualAddress(actualAddress);
		
		arg0.setOwnerShip(ownerShip);
		
		arg0.setActualArea(actualArea);
		
		arg0.setStaffNum(staffNum);
		
		arg0.setOperateModel(operateModel);
		
		arg0.setMajorBrand(majorBrand);
		
		arg0.setMajorType(majorType);
		
		arg0.setMajorBusiness(majorBusiness);
		
		arg0.setSource(source);
		
		arg0.setType(type);
		
		arg0.setUserId(userId);
		
		JsonResult saveLinkDetail = jzfqAuthApi.saveStoreDetail(arg0);
		
		return saveLinkDetail;
	}
/*	@RequestMapping("/saveUserCardByNo")
	public ServiceResult<Integer> saveUserCardByNo(String channel, String companyName, String storeName,Integer source,  
			String actualACode, String actualAName, String actualCCode, String actualCName, String actualPCode, String actualPName,
			String ownerShip, String actualAddress, Integer actualArea, Integer staffNum, String operateModel,
			String majorBrand, String majorType, String majorBusiness, Integer type, Integer userId){
		
		UserCard arg0 = new UserCard();
		
		ServiceResult<Integer> saveUserCardByNo = iUsercardService.saveUserCardByNo(arg0 );
		
		return saveUserCardByNo;
	}*/
}
