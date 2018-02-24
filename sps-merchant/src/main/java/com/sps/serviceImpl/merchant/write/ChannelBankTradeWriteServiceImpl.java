package com.sps.serviceImpl.merchant.write;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsChannelBankTradeWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankTradeWriteServiceImpl implements ChannelBankTradeWriteService{
	@Resource
	private SpsChannelBankTradeWriteMapper bankTradeWrite;
	@Resource
	private SpsChannelBankReadMapper bankRead;
	@Resource
	private SpsChannelBankWriteMapper bankWrite;
	@Resource
	private SpsChannelOpenAccountReadMapper openAccount;
	/**
	 * 保存交易记录的方法
	 */
	@Override

	public Boolean  saveBankTradeInfo(SpsChannelBank bankInfo,BigDecimal amount) {
		SpsChannelBankTrade bankTrandeInfo = new SpsChannelBankTrade();
		bankTrandeInfo.setIdentity(bankInfo.getIdentity());
		Date date = new Date();
		DateFormat timeInstance = SimpleDateFormat.getDateTimeInstance();
		String format = timeInstance.format(date);
		bankTrandeInfo.setApplicationStartDate(format);
		bankTrandeInfo.setTradeSerialNum(UUID.randomUUID().toString());
		//0代表提现，1代表充值
		bankTrandeInfo.setTradeType("0");
		bankTrandeInfo.setUserid(bankInfo.getUserId());
		//交易状态 0 代表审批中，1 审批通过，2 审批不通过
		bankTrandeInfo.setTradeStatus("0");
		bankTrandeInfo.setTradeName(bankInfo.getUserName());
		bankTrandeInfo.setTradeAmount(amount);
		bankTrandeInfo.setTradeBeforeBalanc(bankInfo.getAvailableBalance());

		bankTrandeInfo.setTradeName(bankInfo.getChannlNum());
		
		/**
		 * 支出类型1 为提现，2为退货
		 */
		bankTrandeInfo.setExpenditureType("1");
		
		bankTrandeInfo.setStandby1("提现");
		Boolean flag=true;
		try {
			BigDecimal tradeAfter = bankInfo.getAvailableBalance().subtract(amount);
			bankTrandeInfo.setTradeAfterBalanc(tradeAfter);
			bankTradeWrite.insertBankTrade(bankTrandeInfo);

			bankWrite.updateAblance(bankInfo.getUserId(),tradeAfter);
			//记住在页面或controoler里一定要保证了 提现金额<=可用余额，只有
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;

		}finally{
			return flag;
		}
	}


	@Override
	public void modifyBankTradeInfo(SpsChannelBankTrade bankTrade) {
		bankTradeWrite.updateBankTrade(bankTrade);
	}

	@Override
	public void removeBankTradeInfo(String tradeSerialNum) {
		bankTradeWrite.deleteBankTrade(tradeSerialNum);
	}

	@Override
	public Boolean modifyBankTradeByApplicateDate(String applicationDate, String status) {
		Boolean flag=true;
		try{
			int m = bankTradeWrite.updateStatus(applicationDate, status);

		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}finally{
			return flag;
		}

	}


}
