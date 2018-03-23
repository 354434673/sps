package com.sps.serviceImpl.merchant.write;

import java.util.Date;

import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;

import com.sps.dao.merchant.read.SpsChannelBankTransReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.write.ChannelBankTransWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.write.SpsChannelBankTransWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankTransWriteServiceImpl implements ChannelBankTransWriteService{
	@Autowired
	private SpsChannelBankTransWriteMapper bankTrans;
	@Autowired
	private SpsChannelBankTransReadMapper bankTransRead;
	@Autowired
	private SpsChannelBankTransReadMapper bankTransReadMapper;
	@Autowired
	private SpsChannelOpenAccountReadMapper openAccount;

	@Override
	public void saveBankTansInfo(SpsChannelBankTrans bankTransInfo) {

		bankTransInfo.setStartTime(new Date());
		bankTransInfo.setUserId(UUID.randomUUID().toString());
		bankTrans.insertBankTrans(bankTransInfo);
		
	}


	@Override
	public void removeBankInfo(String serialSh, String serialYop) {
		bankTrans.deleteByPrimaryKey( serialSh,  serialYop);
	}

	@Override
	public HashMap<String,Object> saveBankTansInfos(SpsChannelBank bankTransInfo, String userName, String marchantNo, String UserId) {
		String num = openAccount.selectByOpenAdminNum(userName);
		SpsChannelBankTrans spsChannelBankTrans = new SpsChannelBankTrans();
		spsChannelBankTrans.setName(bankTransInfo.getName());
		spsChannelBankTrans.setBankName(bankTransInfo.getBank());
		spsChannelBankTrans.setUserId(bankTransInfo.getUserId());
		spsChannelBankTrans.setLoginName(bankTransInfo.getUserName());
		spsChannelBankTrans.setIdentity(bankTransInfo.getIdentity());
		spsChannelBankTrans.setPhone(bankTransInfo.getPhone());
		spsChannelBankTrans.setMerchantNo(marchantNo);
		spsChannelBankTrans.setStartTime(new Date());
		spsChannelBankTrans.setSerialSh(UUID.randomUUID().toString());
		spsChannelBankTrans.setBankCode(bankTransInfo.getAccounts());
		spsChannelBankTrans.setChannlNum(num);
		HashMap<String, Object> map = new HashMap<>();
		try{
			bankTrans.insertBankTrans(spsChannelBankTrans);
			SpsChannelBankTrans spsChannelBankTrans1 = bankTransReadMapper.selectOne(spsChannelBankTrans.getSerialSh(), null);
			map.put("flag",true);
			map.put("spsChannelBankTrans1",spsChannelBankTrans1);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag",false);
		}
		return  map;

	}

	@Override
	public Boolean modifyBankTran(String seriNum, String yopSerNO, String status) {
		//根据请求号查询信息
		SpsChannelBankTrans spsChannelBankTrans1 = bankTransRead.selectOne(seriNum, null);
		spsChannelBankTrans1.setSerialYop(yopSerNO);
		spsChannelBankTrans1.setState(status);
		spsChannelBankTrans1.setStopTime(new Date());
		int m= bankTrans.updateBankTrans(spsChannelBankTrans1, seriNum);
		return m>0? true:false;
	}


}
