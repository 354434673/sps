package com.sps.serviceImpl.finance.read;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankTradeReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.finance.BankDrawAudio;
import org.sps.entity.finance.OrderDetail;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.finance.read.CashAuditReadService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-02-23.
 */
@Service(timeout = 2000, group = "dianfu")
@Transactional(readOnly = true)
public class CashAuditServiceImpl implements CashAuditReadService {
    @Resource
    private SpsChannelBankTradeReadMapper bankTradeRead;
    @Resource
    private SpsChannelOpenAccountReadMapper accountRead;
    @Resource
    private SpsChannelOpenAccountReadMapper openAccount;
    @Resource
    private SpsChannelBankReadMapper bankRead;

    @Override
    public HashMap<String, Object> getBankTradeList(Integer page, Integer limit, String applicationStartDate, String paymentDate, String tradeStatus, String enterpriseCompanyName, String loginName) {
        PageHelper.startPage(page, limit);
        List<SpsChannelBankTrade> listBankTrade = bankTradeRead.selectListCashAudit(applicationStartDate, paymentDate, tradeStatus, enterpriseCompanyName, loginName);
        List<BankDrawAudio> listDrawAudio = new ArrayList<BankDrawAudio>();
        for (SpsChannelBankTrade info : listBankTrade) {

            BankDrawAudio bankDrawAudio = new BankDrawAudio();
            bankDrawAudio.setId(info.getId());
            bankDrawAudio.setBankCard(info.getCahnnelBank().getAccounts());
            bankDrawAudio.setAmount(info.getTradeAmount());
            bankDrawAudio.setApplicationDate(info.getApplicationStartDate());
            bankDrawAudio.setCompanyName(info.getEnterprise().getEnterpriseCompanyName());
            bankDrawAudio.setPayDate(info.getApplicationStartDate());
            bankDrawAudio.setStatus(info.getTradeStatus());
            bankDrawAudio.setBalance(info.getTradeAfterBalanc());
            bankDrawAudio.setUserName(info.getCahnnelBank().getUserName());
            //统计近30天提现金额
            BigDecimal moneyAmount = bankTradeRead.selectMoneyAmount(info.getCahnnelBank().getUserName());
            bankDrawAudio.setMoneyAmount(moneyAmount);
            //统计通过审核的提现金额
            BigDecimal totalAmount = bankTradeRead.selectTotalAmount(info.getCahnnelBank().getUserName());
            bankDrawAudio.setTotalAmount(totalAmount);
            listDrawAudio.add(bankDrawAudio);
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Page p = (Page) listBankTrade;
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", p.getTotal());
        hashMap.put("data", listDrawAudio.size() != 0 ? listDrawAudio : null);
        return hashMap;
    }

    /**
     * 根据用户名查找提现记录
     *
     * @param page
     * @param limit
     * @param userName
     * @return
     */
    @Override
    public HashMap<String, Object> getBankTradeAuditList(Integer page, Integer limit, String userName) {
        PageHelper.startPage(page, limit);
        List<SpsChannelBankTrade> listBankTrade = bankTradeRead.selectListCashAuditByUserName(userName);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        PageInfo pageInfo = new PageInfo(listBankTrade);
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", listBankTrade.size() != 0 ? listBankTrade : null);
        return hashMap;
    }

    /**
     * 根据提现申请日期获取提现信息
     *
     * @param id
     * @return
     */
    @Override
    public BankDrawAudio getBankTradeAuditInfo(int id) {
        SpsChannelBankTrade info = bankTradeRead.selectBankTradeInfo(id);
        BankDrawAudio bankDrawAudio = new BankDrawAudio();
        bankDrawAudio.setId(info.getId());
        bankDrawAudio.setBankCard(info.getCahnnelBank().getAccounts());
        bankDrawAudio.setAmount(info.getTradeAmount());
        bankDrawAudio.setApplicationDate(info.getApplicationStartDate());
        bankDrawAudio.setCompanyName(info.getEnterprise().getEnterpriseCompanyName());
        bankDrawAudio.setPayDate(info.getPaymentDate());
        bankDrawAudio.setStatus(info.getTradeStatus());
        bankDrawAudio.setBalance(info.getTradeAfterBalanc());
        bankDrawAudio.setUserName(info.getCahnnelBank().getUserName());
        //统计近30天提现金额
        BigDecimal moneyAmount = bankTradeRead.selectMoneyAmount(info.getCahnnelBank().getUserName());
        bankDrawAudio.setMoneyAmount(moneyAmount);
        //统计通过审核的提现金额
        BigDecimal totalAmount = bankTradeRead.selectTotalAmount(info.getCahnnelBank().getUserName());
        bankDrawAudio.setTotalAmount(totalAmount);
        return bankDrawAudio;
    }


    @Override
    public HashMap<String, Object> getBankTradeIncomePayList(Integer page, Integer limit, String startTime, String endTime, BigDecimal minAmount, BigDecimal maxAmount, String payType, String companyName, String reamrk) {
        PageHelper.startPage(page, limit);
        List<SpsChannelBankTrade> list = bankTradeRead.selectIncomePaymentList(startTime, endTime, minAmount, maxAmount, payType, companyName, reamrk);

        List<BankDrawAudio> listDrawAudio = new ArrayList<BankDrawAudio>();
        for (SpsChannelBankTrade info : list) {
            //保存收支信息
            BankDrawAudio bankDrawAudio = new BankDrawAudio();
            bankDrawAudio.setAuditSerialNum(info.getTradeSerialNum());
            bankDrawAudio.setCompanyName(info.getEnterprise().getEnterpriseCompanyName());
            bankDrawAudio.setAmount(info.getTradeAmount());
            bankDrawAudio.setRemark(info.getStandby1());
            bankDrawAudio.setPayDate(info.getPaymentDate());
            bankDrawAudio.setPayType(info.getTradeType());
            listDrawAudio.add(bankDrawAudio);
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Page p = (Page) list;
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", p.getTotal());
        hashMap.put("data", listDrawAudio.size() != 0 ? listDrawAudio : null);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getBankTradeIncomeList(Integer page, Integer limit, String startTime, String endTime, BigDecimal minAmount, BigDecimal maxAmount, String payType, String companyName, String reamrk) {
        PageHelper.startPage(page, limit);
        List<SpsChannelBankTrade> list = bankTradeRead.selectBankTradeTypeList(startTime, endTime, minAmount, maxAmount, payType, companyName, reamrk);
        List<BankDrawAudio> listDrawAudio = new ArrayList<BankDrawAudio>();
        for (SpsChannelBankTrade info : list) {
            //保存收支信息
            BankDrawAudio bankDrawAudio = new BankDrawAudio();
            bankDrawAudio.setAuditSerialNum(info.getTradeSerialNum());
            bankDrawAudio.setCompanyName(info.getEnterprise().getEnterpriseCompanyName());
            bankDrawAudio.setAmount(info.getTradeAmount());
            bankDrawAudio.setPayType(info.getTradeType());
            bankDrawAudio.setRemark(info.getStandby1());
            bankDrawAudio.setPayDate(info.getApplicationStartDate());
            bankDrawAudio.setPayType(info.getTradeType());
            listDrawAudio.add(bankDrawAudio);
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Page p = (Page) list;
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", p.getTotal());
        hashMap.put("data", listDrawAudio.size() != 0 ? listDrawAudio : null);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getBankTradePaymentList(Integer page, Integer limit, String startTime, String endTime, BigDecimal minAmount, BigDecimal maxAmount, String payType, String companyName, String reamrk) {
        PageHelper.startPage(page, limit);
        List<SpsChannelBankTrade> list = bankTradeRead.selectBankTradeTypeList(startTime, endTime, minAmount, maxAmount, payType, companyName, reamrk);
        List<BankDrawAudio> listDrawAudio = new ArrayList<BankDrawAudio>();
        for (SpsChannelBankTrade info : list) {
            //保存收支信息
            BankDrawAudio bankDrawAudio = new BankDrawAudio();
            bankDrawAudio.setAuditSerialNum(info.getTradeSerialNum());
            bankDrawAudio.setCompanyName(info.getEnterprise().getEnterpriseCompanyName());
            bankDrawAudio.setAmount(info.getTradeAmount());
            bankDrawAudio.setPayType(info.getTradeType());
            bankDrawAudio.setRemark(info.getStandby1());
            bankDrawAudio.setPayDate(info.getApplicationStartDate());
            bankDrawAudio.setPayType(info.getTradeType());
            listDrawAudio.add(bankDrawAudio);
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Page p = (Page) list;
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", p.getTotal());
        hashMap.put("data", listDrawAudio.size() != 0 ? listDrawAudio : null);
        return hashMap;
    }

    @Override
    public OrderDetail getTradeOrderInfo(String tradeSeriNum) {
        //根据交易号查询交易订单信息
        return null;
    }
}
