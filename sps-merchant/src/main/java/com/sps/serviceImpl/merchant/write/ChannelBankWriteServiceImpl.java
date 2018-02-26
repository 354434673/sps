package com.sps.serviceImpl.merchant.write;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.write.ChannelBankWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankWriteServiceImpl implements ChannelBankWriteService{

	@Resource
	private SpsChannelBankWriteMapper bankWrite;
	@Resource
	private SpsChannelBankReadMapper bankRead;
	@Resource
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
	public Boolean saveBankInfo(SpsChannelBank bankInfo,String loginName) {
		try {
			String num = openAccount.selectByOpenAdminNum(loginName);
			bankInfo.setCreatetime(new Date());
			bankInfo.setUserId(UUID.randomUUID().toString());
			//绑卡
			bankInfo.setState(1);
			bankInfo.setUserName(loginName);
			bankInfo.setChannlNum(num);
			bankWrite.insertBank(bankInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Boolean removeBankInfoOrNo(String userId) {
		
		return false;
	}

	@Override
	public Boolean modifyTradePsw(String userName, String psw) {
		SpsChannelBank bank = bankRead.selectByLoginName(userName);
		Boolean flag=true;
		try{
			bankWrite.updateTradePsw(bank.getUserId(), psw);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally{
			return flag;
		}
	}


}
