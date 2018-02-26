package com.sps.serviceImpl.merchant.read;

import javax.annotation.Resource;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.read.ChannelBankReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import org.sps.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

@Service(timeout=2000,group="dianfu")
@Transactional(readOnly = true)
public class ChannelBankReadServiceImpl implements ChannelBankReadService {
	@Resource
	private SpsChannelBankReadMapper bankRead;
	@Resource
	private SpsChannelOpenAccountReadMapper accountRead;
	@Resource
	private SpsChannelOpenAccountReadMapper openAccount;
	/***
	 * 根据用户身份信息查询绑卡银行卡信息
	 */
	@Override
	public SpsChannelBank getBankInfo(String identify) {
		SpsChannelBank bank=bankRead.selectByPrimaryKey(identify);
			return bank;
	}
	
	/***
	 * 校验获取号
	 */
	
	@Override
	public String generateRequestNo() {
		return null;
	}

	/**
	 * 根据用户名判断交易密码是否存在
	 * @param userName
	 * @return
	 */
	@Override
	public String findTradePassword(String userName) {
		return bankRead.selectByLoginUser(userName);

	}

	/**
	 * 根据用户名获取手机号
	 * @param userName
	 * @return
	 */
	@Override
	public String findMobileByUserName(String userName) {
		return bankRead.selectMobileByLoginUser(userName);
	}

	@Override
	public SpsChannelBank getBankInfoByUserName(String userName) {
		
		return bankRead.selectByLoginName(userName);
	}

}
