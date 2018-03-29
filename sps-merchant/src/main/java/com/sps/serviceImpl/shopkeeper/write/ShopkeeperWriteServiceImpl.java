package com.sps.serviceImpl.shopkeeper.write;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.util.HttpClientUtils;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import org.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;
import org.sps.util.FinalData;
import org.sps.util.HttpClientUtil;
import org.sps.util.RuleUtil;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.dao.shopkeeper.write.SpsShopkeeperAccountWriteMapper;
import com.sps.dao.shopkeeper.write.SpsShopkeeperInvitationWriteMapper;
import com.sps.dao.shopkeeper.write.SpsShopkeeperPersonalWriteMapper;
import com.sps.dao.shopkeeper.write.SpsShopkeeperWriteMapper;
@Service(timeout = 2000, group = "dianfu")
@org.springframework.stereotype.Service
public class ShopkeeperWriteServiceImpl implements ShopkeeperWriteService {
	private static final String URL_APPLY_INSERT = "http://192.168.201.149:8080/sps/insertShopApplyInfo";
	private static String initCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/init";
	private static String initAccount = "http://dev.app.chezhubaitiao.com/api/account/init";
	@Resource
	private SpsShopkeeperAccountWriteMapper accountWrite;
	@Resource
	private SpsShopkeeperWriteMapper write;
	@Resource
	private SpsShopkeeperPersonalWriteMapper personalWrite;
	@Resource
	private SpsShopkeeperInvitationWriteMapper invitationWrite;
	@Resource
	private ShopkeeperReadService shopkeeperReadService;
	@Override
	public HashMap<String, Object> updateAccount(String shopkeeperCustomerid, SpsShopkeeperAccount account) {
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
			
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
			
			int updateByExample = accountWrite.updateByExampleSelective(account, example);
			
			hashMap.put("code", 0);
			hashMap.put("msg", "修改成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("code", 0);
			hashMap.put("msg", "修改失败");
			hashMap.put("state", FinalData.STATE_ERROR);
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> updateState(String shopkeeperCustomerid, Integer state) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsShopkeeper record = new SpsShopkeeper();
			
			record.setShopkeeperState(state);
			
			record.setShopkeeperUpdateTime(new Date());
			
			SpsShopkeeperExample example = new SpsShopkeeperExample();
			
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
			
			write.updateByExampleSelective(record, example);
			
			hashMap.put("code", 0);
			hashMap.put("msg", "修改成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			hashMap.put("code", 0);
			hashMap.put("msg", "修改失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> insertInvitation(SpsShopkeeperInvitation invitation,  String channelNum){
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			//判断是否重复
			SpsShopkeeperInvitation queryInvitation = 
					shopkeeperReadService.queryInvitation(invitation.getInvitationName(), invitation.getInvitationPhone(), null);
			
			if(queryInvitation == null){
				
				invitation.setInvitationCreatTime(new Date());
				invitation.setInvitationUpdateTime(new Date());
				invitation.setInvitationTime(new Date());
				invitation.setInvitationState("0");
				invitation.setInvitationType(0);
				invitationWrite.insert(invitation);
				/*
				 * 添加后往店主信息表中差一条数据,店主账号,状态为邀请中(1)
				 */
				String clientNum = RuleUtil.getClientNum("SP");
				SpsShopkeeper spsShopkeeper = new SpsShopkeeper();
				spsShopkeeper.setShopkeeperUsername(invitation.getInvitationPhone());
				spsShopkeeper.setShopkeeperCreatTime(new Date());
				spsShopkeeper.setShopkeeperUpdateTime(new Date());
				spsShopkeeper.setShopkeeperState(1);
				spsShopkeeper.setShopkeeperCustomerid(clientNum);
				spsShopkeeper.setShopkeeperDefaultChannelNum(channelNum);
				write.insertSelective(spsShopkeeper);
				
/*				SpsShopkeeperAccount account = new SpsShopkeeperAccount();
				account.setShopkeeperCustomerid(clientNum);
				account.setAccountNum(invitation.getInvitationPhone());
				account.setAccountState(0);
				accountWrite.insertSelective(account);*/
				/*
				 * 往个人信息中添加,字段为店主名称
				 */
				SpsShopkeeperPersonal personal = new SpsShopkeeperPersonal();
				personal.setPersonalClientName(invitation.getInvitationName());
				personal.setPersonalCreatTime(new Date());
				personal.setPersonalUpdateTime(new Date());
				personal.setShopkeeperCustomerid(clientNum);
				personalWrite.insertSelective(personal);
				
				insert(invitation, clientNum, channelNum);

				HashMap<String, String> result = new HashMap<>();
				result.put("channelNum", channelNum);
				result.put("clientNum", clientNum);
				
				hashMap.put("code", 0);
				hashMap.put("msg", "添加成功");
				hashMap.put("state", FinalData.STATE_SUCCESS);
				hashMap.put("result", result);
			}else{
				hashMap.put("code", 0);
				hashMap.put("msg", "该店主已重复邀请");
				hashMap.put("state", FinalData.STATE_EXIST);
			}
		} catch (Exception e) {
			hashMap.put("code", 0);
			hashMap.put("msg", "添加失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> insertManyInvitation(SpsShopkeeperInvitation invitation) throws Exception {
		
		return null;
	}
	private void insert(SpsShopkeeperInvitation invitation, String clientNum, String channelNum){

		JSONObject shopApplyInfo = new JSONObject();

		shopApplyInfo.put("shopCode", clientNum);

		shopApplyInfo.put("applyTime", new Date());

		shopApplyInfo.put("registerChannel", "web");

		shopApplyInfo.put("customer_channel",  "商户邀请");

		shopApplyInfo.put("centerMerchantCode",  channelNum);

		shopApplyInfo.put("createTime",  new Date());

		JSONObject data = new JSONObject();

		data.put("shopApplyInfo", shopApplyInfo);

		HttpClientUtil.doPostJson(URL_APPLY_INSERT, JSON.toJSONString(data));
	}

	@Override
	public Map<String, Object> initCustomerAccount(String certNo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Map map = new HashMap<>();
		map.put("application", "dianfu");
		map.put("certNo", certNo);
		String jsonResult = HttpClientUtils.post(initCustomerAccount, map);
		System.out.println(jsonResult);
		if (jsonResult != null) {
			JSONObject job = JSON.parseObject(jsonResult);
			String code = job.getString("code");
			String msg = job.getString("msg");
			String success = job.getString("success");
			String result = job.getString("result");
			resultMap.put("code", code);
			resultMap.put("msg", msg);
			resultMap.put("success", success);
			resultMap.put("result", result);
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> initAccount(String amount, String certNo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Map map = new HashMap<>();
		map.put("application", "dianfu");
		map.put("amount", amount);
		map.put("certNo", certNo);
		String jsonResult = HttpClientUtils.post(initAccount, map);
		System.out.println(jsonResult);
		if (jsonResult != null) {
			JSONObject job = JSON.parseObject(jsonResult);
			String code = job.getString("code");
			String msg = job.getString("msg");
			String success = job.getString("success");
			String result = job.getString("result");
			resultMap.put("code", code);
			resultMap.put("msg", msg);
			resultMap.put("success", success);
			resultMap.put("result", result);
		}
		return resultMap;
	}

}
