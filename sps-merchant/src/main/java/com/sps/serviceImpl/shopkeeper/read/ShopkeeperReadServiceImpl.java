package com.sps.serviceImpl.shopkeeper.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import org.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperCarPropertyExample;
import org.sps.entity.shopkeeper.SpsShopkeeperCompany;
import org.sps.entity.shopkeeper.SpsShopkeeperCompanyExample;
import org.sps.entity.shopkeeper.SpsShopkeeperContact;
import org.sps.entity.shopkeeper.SpsShopkeeperContactExample;
import org.sps.entity.shopkeeper.SpsShopkeeperCredit;
import org.sps.entity.shopkeeper.SpsShopkeeperCreditExample;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;
import org.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import org.sps.entity.shopkeeper.SpsShopkeeperHousePropertyExample;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitationExample;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitationExample.Criteria;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;
import org.sps.entity.shopkeeper.SpsShopkeeperPic;
import org.sps.entity.shopkeeper.SpsShopkeeperPicExample;
import org.sps.entity.shopkeeper.SpsShopkeeperRepayment;
import org.sps.entity.shopkeeper.SpsShopkeeperRepaymentExample;
import org.sps.entity.shopkeeper.SpsShopkeeperTaking;
import org.sps.entity.shopkeeper.SpsShopkeeperTakingExample;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.shopkeeper.read.SpsShopkeeperAccountReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperCarPropertyReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperCompanyReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperContactReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperCreditReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperHousePropertyReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperInvitationReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperPersonalReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperPicReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperRepaymentReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperTakingReadMapper;

@Service(timeout=2000,group="dianfu")
@Transactional(readOnly = true)
public class ShopkeeperReadServiceImpl implements ShopkeeperReadService{
	@Resource
	private SpsShopkeeperReadMapper shopkeeperRead;
	@Resource
	private SpsShopkeeperCarPropertyReadMapper carPropertyRead;
	@Resource
	private SpsShopkeeperCompanyReadMapper companyRead;
	@Resource
	private SpsShopkeeperContactReadMapper contactRead;
	@Resource
	private SpsShopkeeperCreditReadMapper creditRead;
	@Resource
	private SpsShopkeeperHousePropertyReadMapper housePropertyRead;
	@Resource
	private SpsShopkeeperPersonalReadMapper personalRead;
	@Resource
	private SpsShopkeeperRepaymentReadMapper repaymentRead;
	@Resource
	private SpsShopkeeperTakingReadMapper takingRead;
	@Resource
	private SpsShopkeeperPicReadMapper picRead;
	@Resource
	private SpsShopkeeperAccountReadMapper accountRead;
	@Resource
	private SpsShopkeeperInvitationReadMapper invitationRead;
	@Override
	public HashMap<String,Object> getShopkeeperList(Integer page, Integer limit, String account, String shopkeeperName,
			Integer shopkeeperState) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		PageHelper.startPage(page, limit);
		
		List<SpsShopkeeper> selectListForJoin = shopkeeperRead.selectListForJoin(account, shopkeeperName, shopkeeperState);
		
		PageInfo pageInfo = new PageInfo(selectListForJoin);
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", selectListForJoin.size() != 0 ? selectListForJoin : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeper(String shopkeeperCustomerid) {
		SpsShopkeeperExample example = new SpsShopkeeperExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeper> selectByExample = shopkeeperRead.selectByExample(example);
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperCompany(String shopkeeperCustomerid) {
		SpsShopkeeperCompanyExample example = new SpsShopkeeperCompanyExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperCompany> selectByExample = companyRead.selectByExample(example);
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperContact(String shopkeeperCustomerid, Integer page, Integer limit) {
		SpsShopkeeperContactExample example = new SpsShopkeeperContactExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		PageHelper.startPage(page, limit);
		
		List<SpsShopkeeperContact> selectByExample = contactRead.selectByExample(example);
		
		PageInfo pageInfo = new PageInfo(selectByExample);
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("count", pageInfo.getTotal());
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample: null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperCredit(String shopkeeperCustomerid) {
		SpsShopkeeperCreditExample example = new SpsShopkeeperCreditExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperCredit> selectByExample = creditRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperHouseProperty(String shopkeeperCustomerid) {
		SpsShopkeeperHousePropertyExample example = new SpsShopkeeperHousePropertyExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperHouseProperty> selectByExample = housePropertyRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperPersonal(String shopkeeperCustomerid) {
		SpsShopkeeperPersonalExample example = new SpsShopkeeperPersonalExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperPersonal> selectByExample = personalRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperCarProperty(String shopkeeperCustomerid) {
		
		SpsShopkeeperCarPropertyExample example = new SpsShopkeeperCarPropertyExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperCarProperty> selectByExample = carPropertyRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperRepayment(String shopkeeperCustomerid) {
		SpsShopkeeperRepaymentExample example = new SpsShopkeeperRepaymentExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperRepayment> selectByExample = repaymentRead.selectByExample(example);
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperTaking(String shopkeeperCustomerid) {
		SpsShopkeeperTakingExample example = new SpsShopkeeperTakingExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperTaking> selectByExample = takingRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperPic(String shopkeeperCustomerid) {
		SpsShopkeeperPicExample example = new SpsShopkeeperPicExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperPic> selectByExample = picRead.selectByExample(example);
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		
		return hashMap;
	}
	
	private HashMap<String, Object> putMap(List<Object> selectByExample, String msg){
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", msg);
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getShopkeeperAccount(String shopkeeperCustomerid) {
		
		SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeperAccount> selectByExample = accountRead.selectByExample(example );
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		hashMap.put("code", 0);
		
		hashMap.put("msg", "获取成功");
		
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample.get(0) : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> queryInvitationList(Integer page, Integer limit, String name, String phone, String state) {

		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		SpsShopkeeperInvitationExample example = new SpsShopkeeperInvitationExample();
		
		Criteria createCriteria = example.createCriteria();
		
		if(!(name == null || name.equals(""))){
			createCriteria.andInvitationNameLike("%"+name+"%");
		}
		if(!(phone == null || phone.equals(""))){
			createCriteria.andInvitationPhoneLike("%"+phone+"%");
		}
		if(!(state == null || state.equals(""))){
			createCriteria.andInvitationStateEqualTo(state);
		}
		
		PageHelper.startPage(page, limit);
		List<SpsShopkeeperInvitation> selectByExample = invitationRead.selectByExample(example );
		PageInfo pageInfo = new PageInfo(selectByExample);
		
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		
		return hashMap;
	}

}
