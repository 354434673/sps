package com.sps.serviceImpl.merchant.read;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.read.ChannelBankTransReadService;
import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankTransReadMapper;
import org.sps.util.StringUtil;

@Service(timeout=12000,group="dianfu")
@Transactional
public class ChannelBankTransReadServiceImpl implements ChannelBankTransReadService{

	@Resource
	private SpsChannelBankTransReadMapper bankRead;
	

	@Override
	public SpsChannelBankTrans getBankInfo(String userName) {
		return  null;
	}

	@Override
	public SpsChannelBankTrans findBankState(String requestNo, String yborderid) {
		if(StringUtil.isEmpty(yborderid)){
			return  bankRead.selectByRequestNo(requestNo);
		}
		return bankRead.selectOne(requestNo, yborderid);

	}

}
