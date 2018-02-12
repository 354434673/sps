package com.sps.serviceImpl.merchant.write;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsChannelBankTradeWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankTradeWriteServiceImpl implements ChannelBankTradeWriteService{
	@Resource
	private SpsChannelBankTradeWriteMapper bankTradeWrite;
	@Resource
	private SpsChannelBankReadMapper bankRead;
	@Resource
	private SpsChannelOpenAccountReadMapper openAccount;
	/**
	 * 保存交易记录的方法
	 */
	@Override
	public void  saveBankTradeInfo(SpsChannelBankTrade bankTrade,String userName) {
		//登录用户的用户名进行查询
		String channelNum = openAccount.selectByOpenAdminNum(userName);
		SpsChannelBank bank = bankRead.selectByChannelNum(channelNum);
		//保存交易信息
		bankTrade.setIdentity(bank.getIdentity());
		Date date = new Date();
		DateFormat timeInstance = SimpleDateFormat.getDateTimeInstance();
		String format = timeInstance.format(date);
		bankTrade.setApplicationStartDate(format);
		bankTrade.setTradeSerialNum(UUID.randomUUID().toString());
		//1代表提现，2 代表充值
		bankTrade.setTradeType("1");
		bankTrade.setUserid(bank.getUserId());
		//交易状态 0 代表审批中，1 审批通过，2 审批不通过
		bankTrade.setTradeStatus("0");
		bankTrade.setTradeBeforeBalanc(bank.getAvailableBalance());
		bankTrade.setTradeName(channelNum);
		/**
		 * 支出类型1 为提现，2为退货
		 */
		bankTrade.setExpenditureType("1");
		
		bankTrade.setStandby1("提现");
		bankTradeWrite.insertBankTrade(bankTrade);
	}


	@Override
	public void modifyBankTradeInfo(SpsChannelBankTrade bankTrade) {
		bankTradeWrite.updateBankTrade(bankTrade);
	}

	@Override
	public void removeBankTradeInfo(String tradeSerialNum) {
		bankTradeWrite.deleteBankTrade(tradeSerialNum);
	}

	
	
	
	
	
}
