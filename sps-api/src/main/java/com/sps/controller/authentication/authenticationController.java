package com.sps.controller.authentication;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.juzifenqi.core.ServiceResult;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.JzfqAuthQueryApi;
import com.jzfq.auth.core.api.dto.JzfqAuthInfoDto;
import com.jzfq.auth.core.api.entiy.AuthBasicDetail;
import com.jzfq.auth.core.api.entiy.AuthConfig;
import com.jzfq.auth.core.api.entiy.AuthHouseDetail;
import com.jzfq.auth.core.api.entiy.AuthIdentityDetail;
import com.jzfq.auth.core.api.entiy.AuthIousDetail;
import com.jzfq.auth.core.api.entiy.AuthLinkDetail;
import com.jzfq.auth.core.api.entiy.AuthResult;
import com.jzfq.auth.core.api.entiy.AuthStoreDetail;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.AuthStateArray;
import com.jzfq.auth.core.api.vo.AuthStateEntity;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.StringUtil;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperCredit;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.service.shopkeeper.ShopkeeperService;

@RestController
@RequestMapping("/authentication")
public class authenticationController {
/*	@Reference(group = "${dubbo.group}")
	private FaceAuthApi faceAuthApi;*/
	@Resource
	private FaceAuthApi faceAuthApi;
	@Resource
	private JzfqAuthApi jzfqAuthApi;
	@Resource
	private JzfqAuthQueryApi jzfqAuthQueryApi;
	@Resource
	private ShopkeeperService shopkeeperService;
/*	@Resource
	private IUserCardService iUsercardService;*/
	@RequestMapping("/queryStateArray")
	public JsonResult<Map<String, Object>> queryStateArray(String clientNum, String imagePath, String channel, String requestNo, String source, Integer userId){
		
		
		AuthStateArray arg0 = new AuthStateArray();
		arg0.setChannel("3");
		arg0.setUserId(210001000);
		JsonResult<Map<String, Object>> queryStateArray = jzfqAuthQueryApi.queryStateArray(arg0 );
		return queryStateArray;
	}
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
	public JsonResult<AuthFaceIdCard> authBackIdCard(String clientNum, AuthFaceIdCard arg0){
		
		JsonResult<AuthFaceIdCard> backIdCardResult = new JsonResult<AuthFaceIdCard>();
		
		if(!StringUtil.isEmpty(clientNum)){
			
/*			AuthFaceIdCard arg0 = new AuthFaceIdCard();
			
			arg0.setBackImagePath(imagePath);
			
			arg0.setChannel(channel);
			
			arg0.setRequestNo(requestNo);
			
			arg0.setSource(source);
			
			arg0.setUserId(userId);*/
			
			backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
			
			SpsShopkeeperPic pic = new SpsShopkeeperPic();
			
			pic.setPicType(3);
			
			pic.setShopkeeperCustomerid(clientNum);
			
			pic.setPicSrc(arg0.getBackImagePath());
			
			pic.setPicState(0);
			
			shopkeeperService.insertSpsShopkeeperPic(pic );
		}else{
			backIdCardResult.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult<AuthFaceIdCard> authFrontIdCard(String clientNum, AuthFaceIdCard arg0){
		JsonResult<AuthFaceIdCard> backIdCardResult = new JsonResult<AuthFaceIdCard>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthFaceIdCard arg0 = new AuthFaceIdCard();
			
			arg0.setBackImagePath(imagePath);
			
			arg0.setChannel(channel);
			
			arg0.setRequestNo(requestNo);
			
			arg0.setSource(source);
			
			arg0.setUserId(userId);*/
			
			backIdCardResult = faceAuthApi.getFrontIdCardResult(arg0);
			
			SpsShopkeeperPic pic = new SpsShopkeeperPic();
			
			pic.setPicType(2);
			
			pic.setShopkeeperCustomerid(clientNum);
			
			pic.setPicSrc(arg0.getFrontImagePath());
			
			pic.setPicState(0);
			
			shopkeeperService.insertSpsShopkeeperPic(pic);
		}else{
			backIdCardResult.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveLinkDetail(String clientNum, AuthLinkDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthLinkDetail arg0 = new AuthLinkDetail();
			
			arg0.setChannel(channel);
			
			arg0.setLinkInfoF(linkInfoF);
			
			arg0.setLinkInfoT(linkInfoT);
			
			arg0.setProductLine(productLine);
			
			arg0.setSource(source);
			
			arg0.setType(type);
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveLinkDetail(arg0);
			
			SpsShopkeeperContact contact = new SpsShopkeeperContact();
			
			shopkeeperService.insertSpsShopkeeperContact(contact);
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveIousDetail(String clientNum, AuthIousDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthIousDetail arg0 = new AuthIousDetail();
			
			arg0.setChannel(channel);
			
			arg0.setProductLine(productLine);
			
			arg0.setType(type);
			
			arg0.setPlateType(plateType);
			
			arg0.setPlateTypeStr(plateTypeStr);
			
			arg0.setFrameNumber(frameNumber);
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveIousDetail(arg0 );
			
			SpsShopkeeperCarProperty carProperty = new SpsShopkeeperCarProperty();
			
			shopkeeperService.insertsShopkeeperCarProperty(carProperty );
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveHouseDetail(String clientNum, AuthHouseDetail arg0){
		JsonResult saveLinkDetail = new JsonResult<>(); 
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthHouseDetail arg0 = new AuthHouseDetail();
			
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
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveHouseDetail(arg0 );
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveBasicDetail(String clientNum, AuthBasicDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthBasicDetail arg0 = new AuthBasicDetail();
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
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveBasicDetail(arg0);
			/**
			 * 更改信息
			 */
			shopkeeperService.insertSpsShopkeeperPersonal(null);
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveIdentityDetail(String clientNum, AuthIdentityDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthIdentityDetail arg0 = new AuthIdentityDetail();
			
			arg0.setName(name);
			
			arg0.setCertNo(certNo);
			
			arg0.setSigningOrganization(signingOrganization);
			
			arg0.setEffectiveTime(effectiveTime);
			
			arg0.setCertAddress(certAddress);
			
			arg0.setChannel(channel);
			
			arg0.setProductLine(productLine);
			
			arg0.setSource(source);
			
			arg0.setType(type);
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveIdentityDetail(arg0);
			
			SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
			
			shopkeeperService.insertSpsShopkeeperPersonal(personal );
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	public JsonResult saveStoreDetail(String clientNum, AuthStoreDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthStoreDetail arg0 = new AuthStoreDetail();
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
			
			arg0.setUserId(userId);*/
			
			saveLinkDetail = jzfqAuthApi.saveStoreDetail(arg0);
			
			SpsShopkeeperCompany company = new SpsShopkeeperCompany();
			
			shopkeeperService.insertShopkeeperCompany(company);
		}else{
			saveLinkDetail.setMsg("clientNum字段不可为空");
		}
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
	/**
	 * 征信认证
	 * @Title: saveMentionDetail   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param authState
	 * @param: @param authType
	 * @param: @param channel
	 * @param: @param type
	 * @param: @param userId
	 * @param: @param clientNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月15日 上午10:58:12
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("/saveMentionDetail")
	public JsonResult saveMentionDetail(AuthResult arg0, String clientNum){
		
		JsonResult saveMentionDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
/*			AuthResult arg0 = new AuthResult();
			
			arg0.setAuthState(authState);
			
			arg0.setAuthType(authType);
			
			arg0.setChannel(channel);
			
			arg0.setUserId(userId);
			
			arg0.setType(type);*/
			
			saveMentionDetail = jzfqAuthApi.saveMentionDetail(arg0);
			
			SpsShopkeeperCredit credit = new SpsShopkeeperCredit();
			
			shopkeeperService.insertSpsShopkeeperCredit(credit);
		}else{
			saveMentionDetail.setMsg("clientNum字段不可为空");
		}
		return saveMentionDetail;
	}
	@RequestMapping("/savePhonePassword")
	public JsonResult savePhonePassword(String phonePwd, String clientNum){
		
		JsonResult saveMentionDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			
		}else{
			saveMentionDetail.setMsg("clientNum字段不可为空");
		}
		return saveMentionDetail;
	}
}
