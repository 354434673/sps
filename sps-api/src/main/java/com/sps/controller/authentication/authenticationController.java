package com.sps.controller.authentication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.JzfqAuthQueryApi;
import com.jzfq.auth.core.api.entiy.AuthBasicDetail;
import com.jzfq.auth.core.api.entiy.AuthHouseDetail;
import com.jzfq.auth.core.api.entiy.AuthIdentityDetail;
import com.jzfq.auth.core.api.entiy.AuthIousDetail;
import com.jzfq.auth.core.api.entiy.AuthLinkDetail;
import com.jzfq.auth.core.api.entiy.AuthResult;
import com.jzfq.auth.core.api.entiy.AuthStoreDetail;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.AuthStateArray;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.HttpClientUtil;
import com.sps.common.IdcardUtil;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperCredit;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
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
	public JsonResult<Map<String, Object>> queryStateArray(AuthStateArray arg0){
		
		JsonResult<Map<String, Object>> queryStateArray = jzfqAuthQueryApi.queryStateArray(arg0 );
		
		queryStateArray.setCode(queryStateArray.getCode().equals("SUCCESS") ? "1":"0");
		
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
			
			backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
			
			if(backIdCardResult.getCode().equals("SUCCESS")){
				SpsShopkeeperPic pic = new SpsShopkeeperPic();
				
				pic.setPicType(3);
				
				pic.setShopkeeperCustomerid(clientNum);
				
				pic.setPicSrc(arg0.getBackImagePath());
				
				pic.setPicState(0);
				
				shopkeeperService.insertSpsShopkeeperPic(pic );
				
				backIdCardResult.setCode(Message.SUCCESS_CODE);
			}
		}else{
			backIdCardResult.setCode(Message.FAILURE_CODE);
			backIdCardResult.setMsg(Message.FAILURE_CLIENTNUM);
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
			
			backIdCardResult = faceAuthApi.getFrontIdCardResult(arg0);
			
			if(backIdCardResult.getCode().equals("SUCCESS")){
				SpsShopkeeperPic pic = new SpsShopkeeperPic();
				
				pic.setPicType(2);
				
				pic.setShopkeeperCustomerid(clientNum);
				
				pic.setPicSrc(arg0.getFrontImagePath());
				
				pic.setPicState(0);
				
				shopkeeperService.insertSpsShopkeeperPic(pic);
				
				backIdCardResult.setCode(Message.SUCCESS_CODE);
			}
		}else{
			backIdCardResult.setCode(Message.FAILURE_CODE);
			backIdCardResult.setMsg(Message.FAILURE_CLIENTNUM);
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
			
			saveLinkDetail = jzfqAuthApi.saveLinkDetail(arg0);
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				
				String linkInfoF = arg0.getLinkInfoF();
				
				String[] first = linkInfoF.split("||");
				
				SpsShopkeeperContact contact = null;
				
				contact = new SpsShopkeeperContact();
				
				contact.setContactCreatTime(new Date());
				
				contact.setContactUpdateTime(new Date());
				
				contact.setContactRelation(first[0]);
				
				contact.setContactName(first[1]);
				
				contact.setContactPhone(first[1]);
				
				contact.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperContact(contact);
				
				String linkInfoT = arg0.getLinkInfoT();
				
				String[] sec = linkInfoT.split("||");
				
				contact = new SpsShopkeeperContact();
				
				contact.setContactCreatTime(new Date());
				
				contact.setContactUpdateTime(new Date());
				
				contact.setContactRelation(sec[0]);
				
				contact.setContactName(sec[1]);
				
				contact.setContactPhone(sec[1]);
				
				contact.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperContact(contact);
				
				saveLinkDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
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
	public String saveIousDetail(String clientNum, String idCard, AuthIousDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			
			saveLinkDetail = jzfqAuthApi.saveIousDetail(arg0 );
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				
				SpsShopkeeperCarProperty carProperty = new SpsShopkeeperCarProperty();
				
				carProperty.setCarChassisNum(arg0.getFrameNumber());//车架号
				
				carProperty.setCarPlateNum(arg0.getPlateTypeStr());//车牌号
				
				carProperty.setCarBrand(arg0.getPlateType());//号牌种类
				
				carProperty.setShopkeeperCustomerid(clientNum);
				//状态码,除了100000都是失败
				shopkeeperService.insertsShopkeeperCarProperty(carProperty );
				//进行个人信用初始化
				String accountInit = accountInit(new BigDecimal(10000.00), "dianfu", idCard);
				
				JSONObject parseObject = JSON.parseObject(accountInit);
				
				parseObject.put("code", "1");
				
				String jsonString = JSON.toJSONString(parseObject);
				//进行个人资金初始化
				customerAccountInit("店付", idCard);
				
				return jsonString;
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return null;
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
			
			saveLinkDetail = jzfqAuthApi.saveHouseDetail(arg0 );
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				SpsShopkeeperHouseProperty houseProperty = new SpsShopkeeperHouseProperty();
				
				houseProperty.setHouseArea((double)arg0.getHouseArea());
				
				houseProperty.setHouseAddr(arg0.getHousePName()+arg0.getHouseCName()+arg0.getHouseAName()+arg0.getHouseAddress());
				
				houseProperty.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperHouseProperty(houseProperty );
				
				saveLinkDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
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
			
			saveLinkDetail = jzfqAuthApi.saveBasicDetail(arg0);
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				/**
				 * 更改信息
				 */
				SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
				
				personal.setPersonalLivingAddress(arg0.getLiveP()+arg0.getLiveC()+arg0.getLiveA()+arg0.getLiveAddress());
				
				personal.setPersonalMaritalStatus(arg0.getMarriage()+"");
				
				personal.setPersonalLivingCondition(arg0.getLiveState()+"");
				
				personal.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.updateSpsShopkeeperPersonal(personal);
				
				saveLinkDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
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
			
			saveLinkDetail = jzfqAuthApi.saveIdentityDetail(arg0);
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				
				SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
				
				personal.setPersonalClientName(arg0.getName());
				
				personal.setPersonalSex(IdcardUtil.getSex(arg0.getCertNo()));
				
				personal.setPersonalIdcard(arg0.getCertNo());

				String effectiveTime = arg0.getEffectiveTime();
				
				String[] split = effectiveTime.split("-");
				
				personal.setPersonalIdcardValidityStart(split[0]);
				
				personal.setPersonalIdcardValidityEnd(split[1]);
				
				personal.setPersonalLicenceIssuingAuthority(arg0.getSigningOrganization());
				
				personal.setPersonalPlaceofdomicile(arg0.getCertAddress());
				
				personal.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperPersonal(personal );
				
				saveLinkDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
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
			
			saveLinkDetail = jzfqAuthApi.saveStoreDetail(arg0);
			
			if(saveLinkDetail.getCode().equals("SUCCESS")){
				/*
				 * 添加到公司表
				 */
				SpsShopkeeperCompany company = new SpsShopkeeperCompany();
				
				company.setCompanyName(arg0.getCompanyName());
				
				company.setCompanyShopName(arg0.getStoreName());
				
				//company.setCompanyCorpName(companyCorpName);
				
				company.setCompanyBusinessAddr(arg0.getActualPName()+arg0.getActualCName()+arg0.getActualAName());
				
				company.setCompanyGpsAddr(arg0.getGpsAddress());
				
				company.setCompanyBusinessAddrOwnership(arg0.getOwnerShip());
				
				company.setCompanyOperatioTime(arg0.getStaffNum());
				
				company.setCompanyEmployeeNum(arg0.getStaffNum());
				
				company.setCompanyBusinessArea((double)arg0.getActualArea());
				
				company.setShopkeeperCustomerid(clientNum);

				shopkeeperService.insertShopkeeperCompany(company);
				/**
				 * 更改shopkeeper主表的内容
				 */
				SpsShopkeeper shopkeeper = new SpsShopkeeper();
				
				shopkeeper.setShopkeeperChannelType("店主");
				
				shopkeeper.setShopkeeperCommodityType(arg0.getMajorType());
				
				shopkeeper.setShopkeeperBusinessModel(arg0.getOperateModel());
				
				shopkeeper.setShopkeeperBrand(arg0.getMajorBrand());
				
				shopkeeper.setShopkeeperBusinessType(arg0.getMajorBusiness());
				
				shopkeeper.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.updateShopkeeper(shopkeeper);
				
				saveLinkDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
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
	public JsonResult saveMentionDetail(AuthResult arg0, String clientNum, SpsShopkeeperCredit credit){
		
		JsonResult saveMentionDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			saveMentionDetail = jzfqAuthApi.saveMentionDetail(arg0);
			
			if(saveMentionDetail.getCode().equals("SUCCESS")){
				
				credit.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperCredit(credit);
				
				saveMentionDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveMentionDetail.setCode(Message.FAILURE_CODE);
			saveMentionDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveMentionDetail;
	}
	@RequestMapping("/savePhonePassword")
	public JsonResult savePhonePassword(String phonePwd, String clientNum){
		
		JsonResult saveMentionDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
			
			personal.setPersonalPhonePassword(phonePwd);
			
			personal.setShopkeeperCustomerid(clientNum);
			
			shopkeeperService.updateSpsShopkeeperPersonal(personal );
			
			saveMentionDetail.setCode(Message.SUCCESS_CODE);
		}else{
			saveMentionDetail.setCode(Message.FAILURE_CODE);
			saveMentionDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveMentionDetail;
	}
	/**
	 * 个人信用账户
	 * @Title: accountInit   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param amount
	 * @param: @param application
	 * @param: @param certNo
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月16日 上午11:31:57
	 * @return: String      
	 * @throws
	 */
	public String accountInit(BigDecimal amount, String application, String certNo){
		
		StringBuffer url = new StringBuffer("http://dev.app.chezhubaitiao.com/api/account/init?");
		
		url.append("amount="+amount);
		
		url.append("&application="+application);
		
		url.append("&certNo="+certNo);
		
		String doPost = HttpClientUtil.doPost(url.toString());
		
		return doPost;
	}
	/**
	 * 个人资金账户
	 * @Title: customerAccountInit   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param application
	 * @param: @param certNo
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月16日 上午11:31:49
	 * @return: String      
	 * @throws
	 */
	public String customerAccountInit(String application, String certNo){
		
		StringBuffer url = new StringBuffer("http://dev.app.chezhubaitiao.com/api/customerAccount/init?");
		
		url.append("application="+application);
		
		url.append("&certNo="+certNo);
		
		String doPost = HttpClientUtil.doPost(url.toString());
		
		return doPost;
	}
}
