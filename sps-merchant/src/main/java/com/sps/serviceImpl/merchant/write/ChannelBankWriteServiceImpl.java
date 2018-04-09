package com.sps.serviceImpl.merchant.write;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsBalanceReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsBalanceWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBalance;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.write.ChannelBankWriteService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankWriteServiceImpl implements ChannelBankWriteService{

	@Autowired
	private SpsChannelBankWriteMapper bankWrite;
	@Autowired
	private SpsBalanceWriteMapper balanceWriteMapper;
	@Autowired
	private SpsBalanceReadMapper balanceReadMapper;
	@Autowired
	private SpsChannelBankReadMapper bankRead;
	@Autowired
	private SpsChannelOpenAccountReadMapper openAccount;
	/**
	 * 更新绑卡信息
	 */
	@Override
	public Boolean modifyBankInfo(SpsChannelBank bankinfo) {
		try {
			bankWrite.updateBank(bankinfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	/**
	 * 删除绑卡信息
	 */
	@Override
	public Boolean removeBankInfo(String userName) {

		try {

			bankWrite.deleteByPrimaryKey(userName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/***
	 * 保存绑卡信息
	 */
	@Override
	public Boolean saveBankInfo(SpsChannelBank bankInfo,Integer userMark) {

		//查询余额信息
		SpsChannelBalance spsChannelBalance = balanceReadMapper.selectByUserId(bankInfo.getChannlNum());
		int m;
		if(spsChannelBalance !=null){
			bankInfo.setAvailableBalance(spsChannelBalance.getBalance());
			m=bankWrite.insertBank(bankInfo);
			return m >0 ? true:false;
		}
		bankInfo.setAvailableBalance(new BigDecimal(0));
		//保存一条用户的余额信息
		SpsChannelBalance accountBalance = new SpsChannelBalance();
		accountBalance.setBalance(new BigDecimal(0));
		accountBalance.setCreateTime(new Date());
		accountBalance.setUserNo(bankInfo.getChannlNum());
		accountBalance.setUserType(userMark);
		m=bankWrite.insertBank(bankInfo);
		int n=balanceWriteMapper.insertBalance(accountBalance);
		return m >0 &&  n>0 ? true:false;

	}

	@Override
	public Boolean modifyBalance(String userName, BigDecimal balance) {
		int m = bankWrite.updateBalance(userName, balance);
		return m >0 ? true :false;
	}

	@Override
	public Boolean removeBankInfoOrNo(String userId) {

		return false;
	}

	@Override
	public Boolean modifyTradePsw(String userName, String psw,String salt) {
		SpsChannelBank bank = bankRead.selectByLoginName(userName);
		int  num = bankWrite.updateTradePsw(bank.getUserId(), psw,salt);
		return num > 0;
	}


}
