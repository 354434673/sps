package com.sps.service.shopkeeper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import com.sps.entity.shopkeeper.SpsShopkeeperTaking;
import com.sps.service.shopkeeper.ShopkeeperService;
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
	@Override
	public int insertShopkeeper(SpsShopkeeper shopkeeper) {
		
		return spsShopkeeperDao.insertSelective(shopkeeper );
	}
	@Override
	public int insertsShopkeeperCarProperty(SpsShopkeeperCarProperty carProperty) {
		return 0;
	}
	@Override
	public int insertShopkeeperCompany(SpsShopkeeperCompany company) {
		
		return companyDao.insertSelective(company);
	}
	@Override
	public int insertSpsShopkeeperContact(SpsShopkeeperContact contact) {
		
		return contactDao.insertSelective(contact);
	}
	@Override
	public int insertSpsShopkeeperCredit(SpsShopkeeperCredit credit) {
		
		return creditDao.insertSelective(credit);
	}
	@Override
	public int insertSpsShopkeeperHouseProperty(SpsShopkeeperHouseProperty houseProperty) {
		
		return 0;
	}
	@Override
	public int insertSpsShopkeeperPersonal(SpsShopkeeperPersonal personal) {
		return 0;
	}
	@Override
	public int insertSpsShopkeeperPic(SpsShopkeeperPic pic) {
		
		return picDao.insertSelective(pic);
	}
	@Override
	public int insertSpsShopkeeperRepayment(SpsShopkeeperRepayment repayment) {
		
		return repaymentDao.insertSelective(repayment);
	}
	@Override
	public int insertSpsShopkeeperTaking(SpsShopkeeperTaking taking) {
		
		return takingDao.insertSelective(taking);
	}
}
