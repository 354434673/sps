package com.sps.serviceImpl.merchant.write;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsChannelBankTradeWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
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

	public String  saveBankTradeInfo(SpsChannelBank bankInfo,BigDecimal amount,String tradeType) {
		SpsChannelBankTrade bankTrandeInfo = new SpsChannelBankTrade();
		String uuid = UUID.randomUUID().toString();
		bankTrandeInfo.setIdentity(bankInfo.getIdentity());
		Date date = new Date();
		DateFormat timeInstance = SimpleDateFormat.getDateTimeInstance();
		String format = timeInstance.format(date);
		bankTrandeInfo.setApplicationStartDate(format);
		bankTrandeInfo.setTradeSerialNum(uuid);
		//0代表支出（提现），1代表收入（充值）
		bankTrandeInfo.setTradeType(tradeType);
		bankTrandeInfo.setUserid(bankInfo.getUserId());
		//交易状态 0 代表待审批，2 审批通过，1审批不通过
		bankTrandeInfo.setTradeStatus("0");
		bankTrandeInfo.setTradeName(bankInfo.getUserName());
		bankTrandeInfo.setTradeAmount(amount);
		bankTrandeInfo.setTradeBeforeBalanc(bankInfo.getAvailableBalance());
		bankTrandeInfo.setTradeName(bankInfo.getChannlNum());
		bankTrandeInfo.setTradeType(tradeType);
		BigDecimal tradeAfter = null;
		/**
		 * 支出类型1 为提现，2为退货
		 */
		if("0".equals(tradeType)){
			bankTrandeInfo.setExpenditureType("1");
			bankTrandeInfo.setStandby1("提现");
			tradeAfter = bankInfo.getAvailableBalance().subtract(amount);
		}
		if("1".equals(tradeType)){
			bankTrandeInfo.setExpenditureType("1");
			bankTrandeInfo.setStandby1("充值");
			tradeAfter = bankInfo.getAvailableBalance().add(amount);
		}

		bankTrandeInfo.setTradeAfterBalanc(tradeAfter);
		int num = bankTradeWrite.insertBankTrade(bankTrandeInfo);
		if( num > 0){
			num = bankWrite.updateAblance(bankInfo.getUserId(), tradeAfter);
		}
		return num > 0?uuid:"";
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
	public Boolean modifyBankTradeByApplicateDate(String applicationDate, String status,String content) {
		//设置审核结束时间,申请结束时间

		Date date = new Date();
		DateFormat timeInstance = SimpleDateFormat.getDateTimeInstance();
		String  applicationStopDate = timeInstance.format(date);
		String  auditDate = timeInstance.format(date);

		int m = bankTradeWrite.updateStatus(applicationDate, status,content,applicationStopDate,auditDate);
		return m >0;
	}


}
