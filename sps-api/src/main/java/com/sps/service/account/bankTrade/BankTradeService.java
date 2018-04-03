package com.sps.service.account.bankTrade;

import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.account.vo.BankTradeInfoVo;

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
    List<BankTradeInfo> findBankTrdeList(String constomeId);
    //根据交易类型查询信息
    List<BankTradeInfo> findBankTrdeListByTradeType(String constomeId,String tradeType);
    //查询交易详情
    BankTradeInfo findBankTradeDetail(Integer id);
    //   根据用户名查询交易信息
    List<BankTradeInfoVo> findBankTrdeShowList(String constomeId);
    //根据查询类型tradeType + 用户customerId 获取交易记录 tradeType 0 标识支出 1标识收入 ,2标识全部
    List<BankTradeInfoVo> findBankTrdeShowPageList(String constomeId,Integer types,Integer currentPage,Integer pageSize);
}
