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
import org.sps.util.StringUtil;

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
	public HashMap<String,Object> saveBankTansInfos(SpsChannelBankTrans bankTransInfo, String userName) {
		String num = openAccount.selectByOpenAdminNum(userName);
        bankTransInfo.setStartTime(new Date());
        bankTransInfo.setChannlNum(num);
		HashMap<String, Object> map = new HashMap<>();
		int m = bankTrans.insertBankTrans(bankTransInfo);
		if(m >0){
			SpsChannelBankTrans spsChannelBankTrans1 = bankTransReadMapper.selectByRequestNo(bankTransInfo.getSerialSh());
			map.put("flag",true);
			map.put("spsChannelBankTrans1",spsChannelBankTrans1);
			return  map;
		}
		map.put("flag",false);
		map.put("spsChannelBankTrans1",null);
		return  map;

	}

	@Override
	public Boolean modifyBankTran(String seriNum, String yopSerNO, String status,String cardtop,String  cardlast, String authtype,String remark) {
		int m=0;
		if(StringUtil.isNotEmpty(yopSerNO)){
			SpsChannelBankTrans bindBankTrans = bankTransRead.selectByRequestNo(seriNum);
			m= bankTrans.updateBankTrans(bindBankTrans.getId(),status,yopSerNO,new Date(),cardtop,cardlast,authtype,remark);
		}else{
			SpsChannelBankTrans bindBankTrans = bankTransRead.selectByRequestNo(seriNum);
			m=  bankTrans.updateBankTrans(bindBankTrans.getId(),status,null,new Date(),cardtop,cardlast,authtype,remark);
		}
		return m > 0 ? true : false;
		//根据请求号查询信息
	}


}
