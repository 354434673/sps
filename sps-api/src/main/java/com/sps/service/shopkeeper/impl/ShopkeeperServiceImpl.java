package com.sps.service.shopkeeper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.shopkeeper.SpsShopkeeperAccountDao;
import com.sps.dao.shopkeeper.SpsShopkeeperCarPrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperCompanyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperContactDao;
import com.sps.dao.shopkeeper.SpsShopkeeperCreditDao;
import com.sps.dao.shopkeeper.SpsShopkeeperDao;
import com.sps.dao.shopkeeper.SpsShopkeeperHousePrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperInvitationDao;
import com.sps.dao.shopkeeper.SpsShopkeeperPersonalDao;
import com.sps.dao.shopkeeper.SpsShopkeeperPicDao;
import com.sps.dao.shopkeeper.SpsShopkeeperRepaymentDao;
import com.sps.dao.shopkeeper.SpsShopkeeperTakingDao;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperCredit;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitationExample;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import com.sps.entity.shopkeeper.SpsShopkeeperTaking;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sun.org.apache.bcel.internal.generic.DADD;
/**
 * 店主相关业务层
 * @ClassName:  ShopkeeperServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月2日 上午11:02:39
 */
@Service
public class ShopkeeperServiceImpl implements ShopkeeperService{
	@Resource
	private SpsShopkeeperDao spsShopkeeperDao;
	@Resource
	private SpsShopkeeperAccountDao spsShopkeeperAccountDao;
	@Resource
	private SpsShopkeeperInvitationDao invitationDao;
	@Resource
	private SpsShopkeeperCarPrppertyDao carPrppertyDao;
	@Resource
	private SpsShopkeeperHousePrppertyDao housePrppertyDao;
	@Resource
	private SpsShopkeeperCompanyDao companyDao;
	@Resource
	private SpsShopkeeperContactDao contactDao;
	@Resource
	private SpsShopkeeperCreditDao creditDao;
	@Resource
	private SpsShopkeeperPersonalDao  personalDao;
	@Resource
	private SpsShopkeeperPicDao picDao;
	@Resource
	private SpsShopkeeperRepaymentDao repaymentDao;
	@Resource
	private SpsShopkeeperTakingDao takingDao;
	@Override
	public SpsShopkeeper queryShopkeeperList(String shopkeeperCustomerid) {
		
		SpsShopkeeperExample example = new SpsShopkeeperExample();
		
		if(!StringUtil.isEmpty(shopkeeperCustomerid)){
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		}
		List<SpsShopkeeper> selectByExample = spsShopkeeperDao.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public boolean queryAccount(String customerId) {
		
		SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(customerId);
		
		List<SpsShopkeeperAccount> selectByExample = spsShopkeeperAccountDao.selectByExample(example);
		
		return selectByExample.get(0).getAccountState() == 0 ? true : false;
	}
	@Override
	public int updateShopkeeperState(Integer state, String customerId) {
		try {
			SpsShopkeeper record = new SpsShopkeeper();
			
			record.setShopkeeperState(state);
			
			SpsShopkeeperExample example = new SpsShopkeeperExample();

			example.createCriteria().andShopkeeperCustomeridEqualTo(customerId);
			
			spsShopkeeperDao.updateByExampleSelective(record, example);
			
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	@Override
	public int updateShopkeeperInvitationState(String state, String phone) {
		try {
			SpsShopkeeperInvitation record = new SpsShopkeeperInvitation();
			
			record.setInvitationState(state);
			
			SpsShopkeeperInvitationExample example = new SpsShopkeeperInvitationExample();
			
			example.createCriteria().andInvitationPhoneEqualTo(phone);
			
			invitationDao.updateByExampleSelective(record, example);
			
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			
			return 1;
		}
	}
	/*
	 * 以下为insert
	 */
	@Override
	public int insertShopkeeper(SpsShopkeeper shopkeeper) {
		
		shopkeeper.setShopkeeperCreatTime(new Date());
		
		shopkeeper.setShopkeeperUpdateTime(new Date());
		
		return spsShopkeeperDao.insertSelective(shopkeeper );
	}
	@Override
	public int insertsShopkeeperCarProperty(SpsShopkeeperCarProperty carProperty) {
		
		carProperty.setCarCreatTime(new Date());
		
		carProperty.setCarUpdateTime(new Date());
		
		return carPrppertyDao.insertSelective(carProperty);
	}
	@Override
	public int insertShopkeeperCompany(SpsShopkeeperCompany company) {
		
		company.setCompanyCreatTime(new Date());
		
		company.setCompanyUpdateTime(new Date());
		
		return companyDao.insertSelective(company);
	}
	@Override
	public int insertSpsShopkeeperContact(SpsShopkeeperContact contact) {
		
		contact.setContactCreatTime(new Date());
		
		contact.setContactUpdateTime(new Date());
		
		return contactDao.insertSelective(contact);
	}
	@Override
	public int insertSpsShopkeeperCredit(SpsShopkeeperCredit credit) {
		
		credit.setCreditUpdateTime(new Date());
		
		credit.setCreditCreatTime(new Date());
		
		return creditDao.insertSelective(credit);
	}
	@Override
	public int insertSpsShopkeeperHouseProperty(SpsShopkeeperHouseProperty houseProperty) {
		
		houseProperty.setHouseCreatTime(new Date());
		
		houseProperty.setHouseUpdateTime(new Date());
		
		return 	housePrppertyDao.insertSelective(houseProperty);
	}
	@Override
	public int insertSpsShopkeeperPersonal(SpsShopkeeperPersonal personal) {
		
		personal.setPersonalCreatTime(new Date());
		
		personal.setPersonalUpdateTime(new Date());
		
		return personalDao.insertSelective(personal);
	}
	@Override
	public int insertSpsShopkeeperPic(SpsShopkeeperPic pic) {
		
		pic.setPicCreatTime(new Date());
		
		pic.setPicUploadTime(new Date());
		
		return picDao.insertSelective(pic);
	}
	@Override
	public int insertSpsShopkeeperRepayment(SpsShopkeeperRepayment repayment) {
		
		repayment.setRepaymentCreatTime(new Date());
		
		repayment.setRepaymentUpdateTime(new Date());
		
		return repaymentDao.insertSelective(repayment);
	}
	@Override
	public int insertSpsShopkeeperTaking(SpsShopkeeperTaking taking) {
		
		taking.setTakingCreatTime(new Date());
		
		taking.setTakingUpdateTime(new Date());
		
		return takingDao.insertSelective(taking);
	}
	@Override
	public int updateSpsShopkeeperPersonal(SpsShopkeeperPersonal personal) {
		
		SpsShopkeeperPersonalExample example = new SpsShopkeeperPersonalExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(personal.getShopkeeperCustomerid());
		
		return personalDao.updateByExampleSelective(personal, example );
	}
	@Override
	public int updateShopkeeper(SpsShopkeeper shopkeeper) {
		
		SpsShopkeeperExample example = new SpsShopkeeperExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeper.getShopkeeperCustomerid());
		
		return spsShopkeeperDao.updateByExample(shopkeeper, example);
	}
	@Override
	public HashMap<String, Object> insertShopkeeperInvitation(SpsShopkeeperInvitation invitation) {
		HashMap<String, Object> hashMap = null;

		String invitationPhone = invitation.getInvitationPhone();

		try {
			if(!StringUtil.isEmpty(invitationPhone)){
				SpsShopkeeperInvitation queryInvitation = queryInvitation(invitationPhone);
				if(queryInvitation == null){
					SpsChannelGuaranteeExample example = new SpsChannelGuaranteeExample();

					example.createCriteria().andGuaranteeCorpPhoneEqualTo(invitation.getInvitationChannelPhone());

					List<SpsChannelGuarantee> selectByExample = guaranteeDao.selectByExample(example);

					if(selectByExample.size() != 0){

						String channelNum = selectByExample.get(0).getChannelNum();

						invitation.setInvitationCreatTime(new Date());

						invitation.setInvitationUpdateTime(new Date());

						invitation.setInvitationState("0");

						invitation.setInvitationType(1);

						invitationDao.insertSelective(invitation);

						/**
						 * 插到店主信息表中
						 */
						String clientNum = RuleUtil.getClientNum("SP");
						SpsShopkeeper spsShopkeeper = new SpsShopkeeper();
						spsShopkeeper.setShopkeeperUsername(invitation.getInvitationPhone());
						spsShopkeeper.setShopkeeperCreatTime(new Date());
						spsShopkeeper.setShopkeeperUpdateTime(new Date());
						spsShopkeeper.setShopkeeperState(1);
						spsShopkeeper.setShopkeeperCustomerid(clientNum);
						spsShopkeeper.setShopkeeperDefaultChannelNum(channelNum);
						spsShopkeeperDao.insertSelective(spsShopkeeper);

						/*
						 * 往店主个人信息中添加,字段为店主名称
						 */
						SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
						personal.setPersonalClientName(invitation.getInvitationName());
						personal.setPersonalCreatTime(new Date());
						personal.setPersonalUpdateTime(new Date());
						personal.setShopkeeperCustomerid(clientNum);
						personalDao.insertSelective(personal);

						HashMap<String, String> result = new HashMap<>();
						result.put("channelNum", channelNum);
						result.put("clientNum", clientNum);

						hashMap = Message.resultMap(Message.SUCCESS_CODE, "邀请成功", Message.SUCCESS_MSG, 1, null);
					}else{
						hashMap = Message.resultMap(Message.FAILURE_CODE, "该供应商不存在", Message.FAILURE_MSG, 0, null);
					}
				}else{
					hashMap = Message.resultMap(Message.FAILURE_CODE, "该店主已邀请", Message.FAILURE_MSG, 0, null);
				}
			}else{
				hashMap = Message.resultMap(Message.FAILURE_CODE, "店主手机号不可为空", Message.FAILURE_MSG, 0, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			hashMap = Message.resultMap(Message.FAILURE_CODE, "邀请失败", Message.FAILURE_MSG, 0, null);
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> queryInvitationList(String salemanPhone) {
		
		HashMap<String, Object> hashMap = null;
		
		HashMap<String, Object> data = null;
		try {
			SpsShopkeeperInvitationExample example = new SpsShopkeeperInvitationExample();
			
			example.createCriteria().andInvitationSalemanPhoneEqualTo(salemanPhone)
									.andInvitationTypeEqualTo(1);
			ArrayList<Object> accept = new ArrayList<Object>();
			
			ArrayList<Object> noAccept = new ArrayList<Object>();
			
			List<SpsShopkeeperInvitation> selectByExample = invitationDao.selectByExample(example);
			
/*			for (SpsShopkeeperInvitation spsShopkeeperInvitation : selectByExample) {
				if(spsShopkeeperInvitation.getInvitationState().equals("1")){
					accept.add(spsShopkeeperInvitation);
				}else if(spsShopkeeperInvitation.getInvitationState().equals("0")){
					noAccept.add(spsShopkeeperInvitation);
				}
			}*/
			selectByExample.forEach(n -> {
				if(n.getInvitationState().equals("1")){
					accept.add(n);
				}else if(n.getInvitationState().equals("0")){
					noAccept.add(n);
				}
			});
			data = new HashMap<String, Object>();
			
			data.put("accept", accept);
			
			data.put("noAccept", noAccept);
			
			hashMap = Message.resultMap(Message.SUCCESS_CODE, "查询成功", Message.SUCCESS_MSG, selectByExample.size(), data);
		} catch (Exception e) {
			hashMap = Message.resultMap(Message.FAILURE_CODE, "查询失败", Message.FAILURE_MSG, 0, null);
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public SpsShopkeeperInvitation queryInvitation(String phone) {
		SpsShopkeeperInvitationExample example = new SpsShopkeeperInvitationExample();
		
		example.createCriteria().andInvitationPhoneEqualTo(phone);
		
		List<SpsShopkeeperInvitation> selectByExample = invitationDao.selectByExample(example );
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public String queryByLoginName(String loginName) {
		return spsShopkeeperDao.selectByLoginName(loginName);
	}
}
