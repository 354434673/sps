package com.sps.serviceImpl.merchant.read;

import javax.annotation.Resource;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.read.ChannelBankReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
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
	public SpsChannelBank getBankInfo(String userName) {
		//获取档期那登录用户的用户名进行查询
		String channelNum = accountRead.selectByOpenAdminNum(userName);
		SpsChannelBank bank = bankRead.selectByChannelNum(channelNum);
		return bank;
			
	}
	
	/***
	 * 校验获取号
	 */
	
	@Override
	public String generateRequestNo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户名判断交易密码是否存在
	 * @param userName
	 * @return
	 */
	@Override
	public Boolean findTradePassword(String userName) {
		String pwd = bankRead.selectByLoginUser(userName);
		return StringUtils.isNumeric(pwd);
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

}
