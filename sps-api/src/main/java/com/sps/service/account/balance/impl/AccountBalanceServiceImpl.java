package com.sps.service.account.balance.impl;

import com.sps.dao.account.AccountBalanceDao;
import com.sps.service.account.balance.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
public class AccountBalanceServiceImpl implements AccountBalanceService {
    @Autowired
    private AccountBalanceDao accountBalanceDao;
    @Override
    public BigDecimal queryByCustomerId(String customerId) {
        //根据登录用户名获取用户id
        BigDecimal balance = accountBalanceDao.selectByUserId(customerId);
        return balance;
    }
}
