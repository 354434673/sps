package com.sps.serviceImpl.merchant.read;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankTradeReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.shopkeeper.read.SpsShopkeeperCarPropertyReadMapper;

/**
 * 交易記錄的方法
 * 
 * @author juzi
 *
 */
@Service(timeout = 2000, group = "dianfu")
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
			String paymentDate, String tradeStatus, String loginName) {
		// 获取档期那登录用户的用户名进行查询
		String channelNum = accountRead.selectByOpenAdminNum(loginName);
		List<SpsChannelBankTrade> listBankTrade = bankTradeRead.selectListBankTrade(applicationStartDate, paymentDate,
				tradeStatus, channelNum);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		PageHelper.startPage(page, limit);
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

}
