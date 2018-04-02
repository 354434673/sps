package com.sps.dao.account;

import com.sps.entity.account.AccountBalance;
import org.apache.ibatis.annotations.Param;

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
public interface AccountBalanceDao {
//    获取当前余额的方法
    BigDecimal selectByUserId(String userNo);
    //保存余额记录的方法
    int insertAccountBalance(AccountBalance accountBalance);
}
