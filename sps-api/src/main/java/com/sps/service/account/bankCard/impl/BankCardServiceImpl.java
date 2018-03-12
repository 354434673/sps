package com.sps.service.account.bankCard.impl;

import com.sps.dao.account.BankCardInfoDao;
import com.sps.service.account.bankCard.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public String findUserId(String userName) {
        String userId = bankCardInfoDao.selectByUserName(userName);
        return userId;
    }
}
