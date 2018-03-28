package com.sps.service.account.balance;

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
public interface AccountBalanceService {
//    查询账户余额
    BigDecimal queryByCustomerId(String customerId);
}
