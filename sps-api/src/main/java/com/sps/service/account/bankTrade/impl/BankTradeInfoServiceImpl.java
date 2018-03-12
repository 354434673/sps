package com.sps.service.account.bankTrade.impl;

import com.sps.dao.account.BankCardInfoDao;
import com.sps.dao.account.BankTradeInfoDao;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BankTradeInfo;
import com.sps.service.account.bankTrade.BankTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-03-09.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class BankTradeInfoServiceImpl implements BankTradeService {
    @Autowired
    private BankCardInfoDao bankCardInfoDao;
    @Autowired
    private BankTradeInfoDao bankTradeInfoDao;
    @Override
    public List<BankTradeInfo> findBankTrdeList(String userName, Integer userType) {
//        根据用户名查询userId
       String userId = bankCardInfoDao.selectByUserName(userName);
//        根据用户userId查询交易信息
        List<BankTradeInfo> bankTradeList = bankTradeInfoDao.selectListByUserName(userId);
        return bankTradeList;
    }
}
