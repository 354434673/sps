package com.sps.service.account.bankTrade;

import com.sps.entity.account.BankTradeInfo;

import java.math.BigDecimal;
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
public interface BankTradeService {
//   根据用户名查询交易信息
    List<BankTradeInfo> findBankTrdeList(String userName, Integer userType);

}
