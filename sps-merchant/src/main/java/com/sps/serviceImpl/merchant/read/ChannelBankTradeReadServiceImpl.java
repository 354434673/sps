package com.sps.serviceImpl.merchant.read;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankTradeReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.read.ChannelBankTradeReadService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 交易記錄的方法
 * 
 * @author juzi
 *
 */
@Service(timeout = 12000, group = "dianfu")
@Transactional
public class ChannelBankTradeReadServiceImpl implements ChannelBankTradeReadService {
	@Resource
	private SpsChannelBankTradeReadMapper bankTradeRead;
	@Resource
	private SpsChannelOpenAccountReadMapper accountRead;
	@Resource
	private SpsChannelOpenAccountReadMapper openAccount;
	@Resource
	private SpsChannelBankReadMapper bankRead;

	@Override
	public HashMap<String, Object> getBankTradeList(Integer page, Integer limit, String applicationStartDate,
			String paymentDate, String tradeStatus, String loginName,String tradeType) {
		// 获取档期那登录用户的用户名进行查询
		String channelNum = accountRead.selectByOpenAdminNum(loginName);
		PageHelper.startPage(page, limit);
		List<SpsChannelBankTrade> listBankTrade = bankTradeRead.selectListBankTrade(applicationStartDate, paymentDate,
				tradeStatus, channelNum,tradeType);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		PageInfo pageInfo = new PageInfo(listBankTrade);
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", listBankTrade.size() != 0 ? listBankTrade : null);
		return hashMap;
	}

	/**
	 * 根据登录用户名查询交易信息
	 * @param loginName
	 * @return
	 */
	
	@Override
	public SpsChannelBankTrade getTradeDetail(String loginName, String tradeSerialNum) {
	String channelNum = accountRead.selectByOpenAdminNum(loginName);
		SpsChannelBankTrade bankTrade = bankTradeRead.selectBankTradeByUsername(channelNum,tradeSerialNum);
		return bankTrade;		
	}

	@Override
	public SpsChannelBankTrade getTradeInfo(String tradeSerialNum) {
		SpsChannelBankTrade bankTrade = bankTradeRead.selectBankTradeByUsername(null,tradeSerialNum);
		return bankTrade;
	}

	/**
	 * 提现审核记录信息
	 * @param page
	 * @param limit
	 * @param applicationStartDate
	 * @param paymentDate
	 * @param tradeStatus
	 * @param enterpriseCompanyAbbreviation
	 * @param loginName
	 * @return
	 */
	@Override
	public HashMap<String, Object> getBankAuditInfo(Integer page, Integer limit, String applicationStartDate, String paymentDate, String tradeStatus, String enterpriseCompanyAbbreviation, String loginName) {
		// 获取档期那登录用户的用户名进行查询
		String channelNum = accountRead.selectByOpenAdminNum(loginName);
		PageHelper.startPage(page, limit);
		List<SpsChannelBankTrade> listBankTrade = bankTradeRead.selectListCashAudit(applicationStartDate, paymentDate,tradeStatus,enterpriseCompanyAbbreviation,loginName);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		PageInfo pageInfo = new PageInfo(listBankTrade);
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", listBankTrade.size() != 0 ? listBankTrade : null);
		return hashMap;
	}

}
