package com.sps.serviceImpl.merchant.write;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsBalanceReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankTradeReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import com.sps.dao.merchant.write.SpsBalanceWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankTradeWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBalance;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelBankTradeWriteServiceImpl implements ChannelBankTradeWriteService{
	@Autowired
	private SpsChannelBankTradeWriteMapper bankTradeWrite;
	@Autowired
	private SpsChannelBankTradeReadMapper bankTradeRead;
	@Autowired
	private SpsBalanceReadMapper  spsBalanceReadMapper;
	@Autowired
	private SpsBalanceWriteMapper spsBalanceWrite;
	@Autowired
	private SpsChannelBankReadMapper bankRead;
	@Autowired
	private SpsChannelBankWriteMapper bankWrite;
	@Autowired
	private SpsChannelOpenAccountReadMapper openAccount;
	/**
	 * 保存交易记录的方法
	 */
	@Override
	public String  saveBankTradeInfo(SpsChannelBank bankInfo,BigDecimal amount,String tradeType,Integer userId, Integer userMark) {
		SpsChannelBankTrade bankTrandeInfo = new SpsChannelBankTrade();
		String uuid = UUID.randomUUID().toString();
		bankTrandeInfo.setIdentity(bankInfo.getIdentity());
		bankTrandeInfo.setApplicationStartDate(new Date());
		bankTrandeInfo.setTradeSerialNum(uuid);
		//0代表支出（提现），1代表收入（充值）
		bankTrandeInfo.setTradeType(tradeType);
		bankTrandeInfo.setUserId(bankInfo.getUserId());
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
//		根据userId 和userMark 获取 id
		SpsChannelBalance spsChannelBalance = spsBalanceReadMapper.selectByUserId(bankInfo.getChannlNum());
		if( num > 0){
			num = bankWrite.updateAblance(bankInfo.getUserId(), tradeAfter);
			num= spsBalanceWrite.updateBalance(spsChannelBalance.getId(), tradeAfter, new Date());
//			更新余额
		}
		return num > 0?uuid:"";
	}
	@Override
	public Boolean saveBankRechangeTradeInfo(String  userName,SpsChannelBankTrade bankTrandeInfo) {
		int n = bankWrite.updateBalance(userName,bankTrandeInfo.getTradeBeforeBalanc());
		int m = bankTradeWrite.insertBankTrade(bankTrandeInfo);
		return m >0 ? true:false ;
	}
	@Override
	public Boolean modifyRechangeStatus(SpsChannelBankTrade spsChannelBankTrade) {
		int m = bankTradeWrite.updateRechangeStatus(spsChannelBankTrade);
		return m > 0 ? true:false;
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
	public Map<String,Object> modifyBankTradeByApplicateDate(int id, String status, String content) {
		Date date = new Date();
		//设置审核结束时间,申请结束时间
		HashMap<String, Object> map = new HashMap<>();
		int m=0;
		Boolean flag=true;
		if(StringUtils.isEmpty(content)){
		//	建议为空
			m = bankTradeWrite.updateStatus(id, status, date, date);
			SpsChannelBankTrade spsChannelBankTrade = bankTradeRead.selectBankTradeInfo(id);
			//根据id查询信息
			map.put("flag",m >0? true:false);
			map.put("spsChannelBankTrade",spsChannelBankTrade);
			return map;
		}else{
			//	建议存在
			m = bankTradeWrite.updateStatusAndContent(id, status,content,date,date);
			//根据id查询信息
			SpsChannelBankTrade spsChannelBankTrade = bankTradeRead.selectBankTradeInfo(id);
			map.put("flag",m >0? true:false);
			map.put("spsChannelBankTrade",spsChannelBankTrade);
			return map;
		}
		//return  map;
	}
}