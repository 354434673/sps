package com.sps.serviceImpl.merchant.write;

import java.util.Date;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.write.ChannelBankTransWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.write.SpsChannelBankTransWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankTransWriteServiceImpl implements ChannelBankTransWriteService{
	@Resource
	private SpsChannelBankTransWriteMapper bankTrans;

	@Override
	public void saveBankTansInfo(SpsChannelBankTrans bankTransInfo) {
		bankTransInfo.setStartTime(new Date());
		bankTransInfo.setUserId(UUID.randomUUID().toString());
		bankTrans.insertBankTrans(bankTransInfo);
		
	}

	@Override
	public void modifyBankInfo(SpsChannelBankTrans bankTransInfo) {
		bankTrans.updateBankTrans(bankTransInfo);
	}

	@Override
	public void removeBankInfo(String serialSh, String serialYop) {
		bankTrans.deleteByPrimaryKey( serialSh,  serialYop);
	}

	

	
	
	
}
