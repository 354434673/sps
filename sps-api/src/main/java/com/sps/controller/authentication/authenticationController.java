package com.sps.controller.authentication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.capital.service.IUserCardNewService;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.JzfqAuthApi;
import com.jzfq.auth.core.api.JzfqAuthQueryApi;
import com.jzfq.auth.core.api.entiy.AuthBasicDetail;
import com.jzfq.auth.core.api.entiy.AuthConfig;
import com.jzfq.auth.core.api.entiy.AuthFaceDetail;
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
import com.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import com.sps.service.shopkeeper.ShopkeeperService;

@RestController
@RequestMapping("/authentication")
public class authenticationController {
	@Resource
	private FaceAuthApi faceAuthApi;
	@Resource
	private JzfqAuthApi jzfqAuthApi;
	@Resource
	private JzfqAuthQueryApi jzfqAuthQueryApi;
	@Resource
	private ShopkeeperService shopkeeperService;
	@Resource
	private IUserCardNewService iUserCardNewService;
	/**
	 * 查询用户认证步骤
	 * @Title: queryStateArray   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param arg0
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月26日 下午4:33:00
	 * @return: JsonResult<Map<String,Object>>      
	 * @throws
	 */
	@RequestMapping("/queryStateArray")
	public JsonResult<Map<String, Object>> queryStateArray(AuthStateArray arg0){
		
		JsonResult<Map<String, Object>> queryStateArray = jzfqAuthQueryApi.queryStateArray(arg0 );
		
		queryStateArray.setCode(queryStateArray.getCode().equals("SUCCESS") ? "1":"0");
		
		return queryStateArray;
	}
	@RequestMapping("/getAuthConfig")
	public JsonResult<Map<String, Object>> getAuthConfig(){
		
		AuthConfig arg0 = new AuthConfig();
		
		arg0.setChannel("3");
		
		arg0.setProductLine("auth");
		JsonResult<Map<String, Object>> queryStateArray = jzfqAuthApi.getAuthConfig(arg0);
		
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
			
			String code = backIdCardResult.getCode();
			if(code != null){
				if(code.equals("SUCCESS")){
					SpsShopkeeperPic pic = new SpsShopkeeperPic();
					
					pic.setPicType(3);
					
					pic.setShopkeeperCustomerid(clientNum);
					
					pic.setPicSrc(arg0.getBackImagePath());
					
					shopkeeperService.insertSpsShopkeeperPic(pic );
					
					backIdCardResult.setCode(Message.SUCCESS_CODE);
				}
			}
		}else{
			backIdCardResult.setCode(Message.FAILURE_CODE);
			backIdCardResult.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return backIdCardResult;
	}
	@RequestMapping("/savePic")
	public JsonResult<AuthFaceIdCard> savePic(String clientNum, SpsShopkeeperPic pic){
		
		JsonResult<AuthFaceIdCard> backIdCardResult = new JsonResult<AuthFaceIdCard>();
		
		if(!StringUtil.isEmpty(clientNum)){
					
					pic.setShopkeeperCustomerid(clientNum);
					
					shopkeeperService.insertSpsShopkeeperPic(pic );
					
					backIdCardResult.setCode(Message.SUCCESS_CODE);
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
			
			String code = backIdCardResult.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					SpsShopkeeperPic pic = new SpsShopkeeperPic();
					
					pic.setPicType(2);
					
					pic.setShopkeeperCustomerid(clientNum);
					
					pic.setPicSrc(arg0.getFrontImagePath());
					
					shopkeeperService.insertSpsShopkeeperPic(pic);
					
					backIdCardResult.setCode(Message.SUCCESS_CODE);
				}
			}
		}else{
			backIdCardResult.setCode(Message.FAILURE_CODE);
			backIdCardResult.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return backIdCardResult;
	}
	@RequestMapping("/saveFaceDetail")
	public JsonResult<AuthFaceIdCard> saveFaceDetail(String clientNum, AuthFaceDetail arg0, String livingImage3){
		
		JsonResult saveFaceDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			
			saveFaceDetail = jzfqAuthApi.saveFaceDetail(arg0 );
					
			String code = saveFaceDetail.getCode();
			
			if(code.equals("SUCCESS")){
				SpsShopkeeperPic pic = null;
				
				pic = new SpsShopkeeperPic();
				pic.setPicSrc(arg0.getLivingImage1());
				
				pic.setPicType(14);
				
				pic.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperPic(pic);
				
				pic = new SpsShopkeeperPic();
				
				pic.setPicSrc(arg0.getLivingImage2());
				
				pic.setPicType(15);
				
				pic.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperPic(pic);
				
				pic = new SpsShopkeeperPic();
				
				pic.setPicSrc(livingImage3);
				
				pic.setPicType(16);
				
				pic.setShopkeeperCustomerid(clientNum);
				
				shopkeeperService.insertSpsShopkeeperPic(pic);
				
				saveFaceDetail.setCode(Message.SUCCESS_CODE);
			}
		}else{
			saveFaceDetail.setCode(Message.FAILURE_CODE);
			saveFaceDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveFaceDetail;
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
			
			String code = saveLinkDetail.getCode();
			if(code != null){
				if(code.equals("SUCCESS")){
					
					String linkInfoF = arg0.getLinkInfoF();
					
					String[] first = linkInfoF.split("\\|\\|");
					
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
					
					String[] sec = linkInfoT.split("\\|\\|");
					
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
	public String saveIousDetail(String clientNum, String picUrl, String idCard, AuthIousDetail arg0){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			
			saveLinkDetail = jzfqAuthApi.saveIousDetail(arg0 );
			
			String code = saveLinkDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					
					SpsShopkeeperCarProperty carProperty = new SpsShopkeeperCarProperty();
					
					carProperty.setCarChassisNum(arg0.getFrameNumber());//车架号
					
					carProperty.setCarPlateNum(arg0.getPlateTypeStr());//车牌号
					
					carProperty.setCarBrand(arg0.getPlateType());//号牌种类
					
					carProperty.setShopkeeperCustomerid(clientNum);
					//状态码,除了100000都是失败
					shopkeeperService.insertsShopkeeperCarProperty(carProperty );
					
					SpsShopkeeperPic pic = new SpsShopkeeperPic();
					
					pic.setShopkeeperCustomerid(clientNum);
					
					pic.setPicSrc(picUrl);
					
					pic.setPicType(12);
					
					shopkeeperService.insertSpsShopkeeperPic(pic );
					//进行个人信用初始化
					String accountInit = accountInit(new BigDecimal(10000.00), "dianfu", idCard);
					
					JSONObject parseObject = JSON.parseObject(accountInit);
					
					parseObject.put("code", "1");
					
					String jsonString = JSON.toJSONString(parseObject);
					//进行个人资金初始化
					customerAccountInit("店付", idCard);
					
					return jsonString;
				}
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
	public JsonResult saveHouseDetail(String clientNum, String picUrl, AuthHouseDetail arg0){
		JsonResult saveLinkDetail = new JsonResult<>(); 
		if(!StringUtil.isEmpty(clientNum)){
			
			saveLinkDetail = jzfqAuthApi.saveHouseDetail(arg0 );
			
			String code = saveLinkDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					SpsShopkeeperHouseProperty houseProperty = new SpsShopkeeperHouseProperty();
					houseProperty.setHouseArea((double)arg0.getHouseArea());
					
					houseProperty.setHouseAddr(arg0.getHousePName()+arg0.getHouseCName()+arg0.getHouseAName()+arg0.getHouseAddress());
					
					houseProperty.setShopkeeperCustomerid(clientNum);
					
					shopkeeperService.insertSpsShopkeeperHouseProperty(houseProperty );
					
					SpsShopkeeperPic pic = new SpsShopkeeperPic();
					
					pic.setShopkeeperCustomerid(clientNum);
					
					pic.setPicSrc(picUrl);
					
					pic.setPicType(11);
					
					shopkeeperService.insertSpsShopkeeperPic(pic );
					
					saveLinkDetail.setCode(Message.SUCCESS_CODE);
				}
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
			
			String code = saveLinkDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					/**
					 * 更改信息
					 */
					SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
					
					personal.setPersonalLivingProvinceName(arg0.getLiveP());
					
					personal.setPersonalLivingProvinceCode(arg0.getLivePCode());
					
					personal.setPersonalLivingCityName(arg0.getLiveC());
					
					personal.setPersonalLivingCityCode(arg0.getLiveCCode());
					
					personal.setPersonalLivingAreaName(arg0.getLiveA());
					
					personal.setPersonalLivingAreaCode(arg0.getLiveACode());
					
					personal.setPersonalLivingAddress(arg0.getLiveAddress());
					
					personal.setPersonalMaritalStatus(arg0.getMarriage()+"");
					
					personal.setPersonalLivingCondition(arg0.getLiveState()+"");
					
					personal.setShopkeeperCustomerid(clientNum);
					
					shopkeeperService.updateSpsShopkeeperPersonal(personal);
					
					saveLinkDetail.setCode(Message.SUCCESS_CODE);
				}
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
			
			String code = saveLinkDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					
					SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
					
					personal.setPersonalClientName(arg0.getName());
					
					personal.setPersonalSex(IdcardUtil.getSex(arg0.getCertNo()));
					
					personal.setPersonalIdcard(arg0.getCertNo());
					
					String effectiveTime = arg0.getEffectiveTime();
					
					String[] split = effectiveTime.split("-");
					
					personal.setPersonalAge(IdcardUtil.IdNOToAge(arg0.getCertNo()));
					
					personal.setPersonalIdcardValidityStart(split[0]);
					
					personal.setPersonalIdcardValidityEnd(split[1]);
					
					personal.setPersonalLicenceIssuingAuthority(arg0.getSigningOrganization());
					
					personal.setPersonalPlaceofdomicile(arg0.getCertAddress());
					
					personal.setShopkeeperCustomerid(clientNum);
					
					//shopkeeperService.insertSpsShopkeeperPersonal(personal);
					
					saveLinkDetail.setCode(Message.SUCCESS_CODE);
				}
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveLinkDetail;
	}
	/**
	 * 银行卡认证
	 * @Title: saveBank   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param repayment
	 * @param: @param clientNum
	 * @param: @param userId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月26日 下午4:40:16
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("/saveBank")
	public JsonResult saveBank(SpsShopkeeperRepayment repayment, String clientNum, Integer userId){
		
		JsonResult saveLinkDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			AuthIdentityDetail arg0 = new AuthIdentityDetail();
			
			arg0.setBankNo(repayment.getRepaymentBankid());
			
			arg0.setUserId(userId);
			
			arg0.setChannel("3");
			
			arg0.setProductLine("auth");
			
			arg0.setType(1);
			
			saveLinkDetail = jzfqAuthApi.saveIdentityDetail(arg0 );
			
			String code = saveLinkDetail.getCode();
			if(code != null){
				if(code.equals("SUCCESS")){
					repayment.setShopkeeperCustomerid(clientNum);
					
					shopkeeperService.insertSpsShopkeeperRepayment(repayment);
					
					saveLinkDetail.setCode(Message.SUCCESS_CODE);
				}
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
			
			String code = saveLinkDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					
					SpsShopkeeperCompany company = new SpsShopkeeperCompany();
					
					company.setCompanyName(arg0.getCompanyName());
					
					company.setCompanyShopName(arg0.getStoreName());
					
					//company.setCompanyCorpName(companyCorpName);
					company.setCompanyBusinessProvinceName(arg0.getActualPName());
					
					company.setCompanyBusinessProvinceCode(arg0.getActualPCode());
					
					company.setCompanyBusinessCityName(arg0.getActualCName());
					
					company.setCompanyBusinessCityCode(arg0.getActualCCode());
					
					company.setCompanyBusinessAreaName(arg0.getActualAName());
					
					company.setCompanyBusinessAreaCode(arg0.getActualACode());
					
					company.setCompanyGpsAddr(arg0.getGpsAddress());
					
					company.setCompanyBusinessLat(arg0.getGpsLat());
					
					company.setCompanyBusinessLng(arg0.getGpsLng());
					company.setCompanyBusinessAddr(arg0.getActualPName()+arg0.getActualCName()+arg0.getActualAName());
					
					company.setCompanyGpsAddr(arg0.getGpsAddress());
					
					company.setCompanyBusinessAddrOwnership(arg0.getOwnerShip());
					
					company.setCompanyOperatioTime(arg0.getStaffNum());
					
					company.setCompanyEmployeeNum(arg0.getStaffNum());
					
					company.setCompanyBusinessArea((double)arg0.getActualArea());
					
					company.setShopkeeperCustomerid(clientNum);

					shopkeeperService.insertShopkeeperCompany(company);
					/*
					 * 插入图片
					 */
					shopkeeperService.insertSpsShopkeeperPicForEach(clientNum, arg0.getStoreFrontPictures(), 7);
					
					shopkeeperService.insertSpsShopkeeperPicForEach(clientNum, arg0.getStoreInPictures(), 13);
					
					shopkeeperService.insertSpsShopkeeperPicForEach(clientNum, arg0.getLeasePictures(), 0);
					
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
			}
		}else{
			saveLinkDetail.setCode(Message.FAILURE_CODE);
			saveLinkDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveLinkDetail;
	}
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
			
			String code = saveMentionDetail.getCode();
			
			if(code != null){
				if(code.equals("SUCCESS")){
					
					credit.setShopkeeperCustomerid(clientNum);
					
					shopkeeperService.insertSpsShopkeeperCredit(credit);
					
					saveMentionDetail.setCode(Message.SUCCESS_CODE);
				}
			}
		}else{
			saveMentionDetail.setCode(Message.FAILURE_CODE);
			saveMentionDetail.setMsg(Message.FAILURE_CLIENTNUM);
		}
		return saveMentionDetail;
	}
	@RequestMapping("/savePhonePassword")
	public JsonResult savePhonePassword(String phonePwd, String clientNum, Integer userId){
		
		JsonResult saveMentionDetail = new JsonResult<>();
		
		if(!StringUtil.isEmpty(clientNum)){
			SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
			
			personal.setPersonalPhonePassword(phonePwd);
			
			personal.setShopkeeperCustomerid(clientNum);
			
			shopkeeperService.updateSpsShopkeeperPersonal(personal);
			
			saveMentionDetail.setCode(Message.SUCCESS_CODE);
			saveMentionDetail.setMsg("手机服务密码保存成功");
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
