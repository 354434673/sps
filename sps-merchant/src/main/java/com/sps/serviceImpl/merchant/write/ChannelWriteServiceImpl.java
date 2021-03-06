package com.sps.serviceImpl.merchant.write;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.util.HttpClientUtil;
import com.sps.util.HttpClientUtils;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelExample;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelWriteService;
import org.sps.util.FinalData;
import org.sps.util.FinalUrl;
import org.sps.util.RuleUtil;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.dao.merchant.write.SpsChannelBusinessWriteMapper;
import com.sps.dao.merchant.write.SpsChannelEnterpriseWriteMapper;
import com.sps.dao.merchant.write.SpsChannelFinanceTargetWriteMapper;
import com.sps.dao.merchant.write.SpsChannelGatherWriteMapper;
import com.sps.dao.merchant.write.SpsChannelGuaranteeWriteMapper;
import com.sps.dao.merchant.write.SpsChannelLogisticsWriteMapper;
import com.sps.dao.merchant.write.SpsChannelOpenAccountWriteMapper;
import com.sps.dao.merchant.write.SpsChannelWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelWriteServiceImpl implements ChannelWriteService{
	private static final String URL = FinalUrl.RISK_URL+"/sps/insertCenterBank";

	private static final String init = FinalUrl.CHEZHUBAITIAO_URL+"/api/merchantAccount/init";
	
	private static final String initBusiness = FinalUrl.CHEZHUBAITIAO_URL+"/api/business/init";
	@Resource
	private SpsChannelWriteMapper channelWrite;
	@Resource
	private SpsChannelBusinessWriteMapper businessWrite;
	@Resource
	private SpsChannelEnterpriseWriteMapper enterpriseWrite;
	@Resource
	private SpsChannelGuaranteeWriteMapper guaranteeWrite;
	@Resource
	private SpsChannelFinanceTargetWriteMapper financeTargetWrite;
	@Resource
	private SpsChannelLogisticsWriteMapper logisticsWrite;
	@Resource
	private SpsChannelOpenAccountWriteMapper openAccountWrite;
	@Resource
	private SpsChannelGatherWriteMapper gatherWrite;
	@Resource
	private ChannelReadService channelReadService;
	@Override
	public HashMap<String, String> insertAll(SpsChannel channel, 
							SpsChannelEnterprise enterprise, 
							SpsChannelBusiness business, 
							SpsChannelGuarantee guarantee,
							SpsChannelFinanceTarget financeTarget,
							SpsChannelLogistics logistics , 
							SpsChannelOpenAccount openAccount){
		
			HashMap<String, String> result = new HashMap<String,String>();
			
			SpsChannelEnterprise queryEnterprise = channelReadService.getChannel(enterprise);
			
			if(queryEnterprise == null){
				try {
					
					String clientNum = RuleUtil.getClientNum("DF");
					
					channel.setChannelNum(clientNum);
					
					insertChanel(channel);
					
					insertEnterprise(enterprise,clientNum);
					
					insertBusiness(business, clientNum);
					
					insertGuarantee(guarantee, clientNum);
					
					insertFinanceTarget(financeTarget, clientNum);
					
					insertLogistics(logistics, clientNum);
					
					insertOpenAccount(openAccount, clientNum);
					
					result.put("msg", "添加成功");
					result.put("state", FinalData.STATE_SUCCESS);
					result.put("icon", "1");
					result.put("channelNum", clientNum);
				} catch (Exception e) {
					result.put("msg", "添加失败");
					result.put("state", FinalData.STATE_ERROR);
					result.put("icon", "2");
					e.printStackTrace();
				}
			}else{
				result.put("msg", "该商户已存在");
				result.put("state", FinalData.STATE_EXIST);
				result.put("icon", "2");
			}
			return result;
		
	};
	@Override
	public HashMap<String, String> insertChanel(SpsChannel channel) {
		
		HashMap<String, String> result = new HashMap<String,String>();
		
		int insertSelective = channelWrite.insertSelective(channel);
		
		return null;
		
	}
	@Override
	public HashMap<String, String> insertEnterprise(SpsChannelEnterprise enterprise, String channelNum) {
		enterprise.setChannelNum(channelNum);
		enterpriseWrite.insertSelective(enterprise);
		return null;
	}
	@Override
	public HashMap<String, String> insertBusiness(SpsChannelBusiness business, String channelNum) {
		business.setChannelNum(channelNum);
		businessWrite.insertSelective(business);
		return null;
	}
	@Override
	public HashMap<String, Object> insertGather(SpsChannelGather gather) {

		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		SpsChannelGather queryGather = channelReadService.getGather(gather);
		

		if(queryGather == null){
			try {
				int insertSelective = gatherWrite.insertSelective(gather);
				
				Integer gatherId = gather.getGatherId();
				
				insertBank(gather);

				hashMap.put("msg", "银行卡添加成功");
				hashMap.put("state", FinalData.STATE_SUCCESS);
				hashMap.put("icon", 1);
			} catch (Exception e) {
				hashMap.put("msg", "银行卡添加失败");
				hashMap.put("state", FinalData.STATE_ERROR);
				hashMap.put("icon", 2);
				e.printStackTrace();
			}
		}
		return hashMap;

}
	@Override
	public HashMap<String, String> insertLogistics(SpsChannelLogistics logistics, String channelNum) {
		logistics.setChannelNum(channelNum);
		
		logisticsWrite.insertSelective(logistics);
		
		return null;
	}
	@Override
	public HashMap<String, String> insertGuarantee(SpsChannelGuarantee guarantee, String channelNum) {
		guarantee.setChannelNum(channelNum);
		guaranteeWrite.insertSelective(guarantee);
		return null;
	}
	@Override
	public HashMap<String, String> insertFinanceTarget(SpsChannelFinanceTarget financeTarget, String channelNum) {
		financeTarget.setChannelNum(channelNum);
		financeTargetWrite.insertSelective(financeTarget);
		return null;
	}
	@Override
	public HashMap<String, String> insertOpenAccount(SpsChannelOpenAccount account, String channelNum) {
		
		account.setChannelNum(channelNum);
		openAccountWrite.insertSelective(account);
		return null;
	}
	@Override
	public HashMap<String, String> deleteChannel(String channelNum, Integer state) {
		SpsChannel record = new SpsChannel();
		
		record.setChannelState(state);
		
		SpsChannelExample example = new SpsChannelExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum);
		
		int updateByExampleSelective = channelWrite.updateByExampleSelective(record, example);
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		
		hashMap.put("msg", "删除成功");
		hashMap.put("state", FinalData.STATE_SUCCESS);
		
		return hashMap;
	}
	private void insertBank(SpsChannelGather channelGather){
		JSONObject centerBankInfo = new JSONObject();
		JSONObject centerMerchantInfo = new JSONObject();
		/**
		 * 推向风控
		 */
		centerMerchantInfo.put("merchantCode", channelGather.getChannelNum());//商户编号
		centerBankInfo.put("bankNo", channelGather.getGatherBankId());//收款银行卡账号
		centerBankInfo.put("cardOwnerName", channelGather.getGatherOwnerName());//银行卡所有人姓名
		centerBankInfo.put("certNo", channelGather.getGatherIdcard());//身份证号
		centerBankInfo.put("bindMobile", channelGather.getGatherPhone());//银行卡绑定手机号
		centerBankInfo.put("depositBank",  channelGather.getGatherDepositBank());//开户银行
		centerBankInfo.put("bankSeparate",  channelGather.getGatherBankSubbranch());//开户行分行
		centerBankInfo.put("bankBranch",  channelGather.getGatherBankBranch());//开户银行支行

		JSONObject data = new JSONObject();
		data.put("centerBankInfo", centerBankInfo);
		data.put("merchantInfo", centerMerchantInfo);
		String jsonString = JSON.toJSONString(data);

		org.sps.util.HttpClientUtil.doPostJson(URL, jsonString);
	}

	@Override
	public HashMap<String, Object> initBusiness(String businessId,String firstMonthQuota,String monthQuota,String totalQuota) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONObject json = new JSONObject();
		json.put("application", "dianfu");
		json.put("approvedDate", df.format(System.currentTimeMillis()));
		json.put("businessId",businessId);
		json.put("firstMonthQuota", firstMonthQuota);
		json.put("monthQuota", monthQuota);
		json.put("signDateStart", df.format(System.currentTimeMillis()));
		json.put("totalQuota", totalQuota);
		String jsonResult = com.sps.util.HttpClientUtil.doPostJson(initBusiness, json.toJSONString());
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
	public HashMap<String, Object> initMerchantAccount(String businessId, String name) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Map map = new HashMap<>();
		map.put("application", "dianfu");
		map.put("businessId", businessId);
		map.put("name", name);
		String jsonResult = HttpClientUtils.post(init, map);
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
	public HashMap<String, Object> updateChannelState(String channelNum, Integer channelFlowState) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsChannelExample example = new SpsChannelExample();
			
			example.createCriteria().andChannelNumEqualTo(channelNum);
			
			SpsChannel record = new SpsChannel();
			
			record.setChannelFlowState(channelFlowState);
			
			channelWrite.updateByExampleSelective(record , example);
			
			map.put("code", 1);
			map.put("msg", "流程状态修改成功");
			map.put("success", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "流程状态修改失败");
			map.put("success", "error");
		}
		return map;
	}
}