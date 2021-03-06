package com.sps.service.account.bankCard.impl;

import com.sps.dao.account.AccountBalanceDao;
import com.sps.dao.account.BankCardInfoDao;
import com.sps.entity.account.AccountBalance;
import com.sps.entity.account.BankCardInfo;
import com.sps.service.account.bankCard.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018-03-10.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private BankCardInfoDao bankCardInfoDao;
  /*  @Autowired
    private SpsChannelOpenAccountReadMapper openAccount;*/
    @Autowired
    private AccountBalanceDao accountBalanceDao;
    @Override
    public String findUserId(String customerId) {
        return  bankCardInfoDao.selectByUserName(customerId);
    }

    @Override
    public Boolean saveBankCardInfo(BankCardInfo bankInfo ) {
        //		根据用户名获取 余额表信息---存在取出余额---不存在 创建改用户的余额表信息
        BigDecimal balance = accountBalanceDao.selectByUserId(bankInfo.getChannlNum());
        int m;
        if(balance !=null){
            bankInfo.setAvailableBalance(balance);
            m=bankCardInfoDao.insertBankCardInfo(bankInfo);
            return m >0 ? true:false;
        }
        bankInfo.setAvailableBalance(new BigDecimal(0));
        //保存一条用户的余额信息
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setBalance(new BigDecimal(0));
        accountBalance.setCreateTime(new Date());
        accountBalance.setUserNo(bankInfo.getChannlNum());
       // accountBalance.setUserType(2);
        m=bankCardInfoDao.insertBankCardInfo(bankInfo);
        int n=accountBalanceDao.insertAccountBalance(accountBalance);
        return m >0 &&  n>0 ? true:false;

    }

    @Override
    public Boolean removeBankCard(String userId) {
        int m = bankCardInfoDao.deleteBankCard(userId);
        return m >0? true:false;
    }

    @Override
    public List<BankCardInfo> findBindCardInfo(String customerId) {
        List<BankCardInfo> bankCardInfos = bankCardInfoDao.selectByCustomerId(customerId);

        return bankCardInfos;
    }

    @Override
    public Boolean modifyBankInfo(BankCardInfo bankCardInfo) {
        int m = bankCardInfoDao.updateBankInfo(bankCardInfo);
        return m > 0 ? true:false;
    }
}
