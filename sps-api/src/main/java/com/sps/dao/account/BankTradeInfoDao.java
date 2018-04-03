package com.sps.dao.account;

import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.account.vo.BankTradeInfoVo;
import org.apache.ibatis.annotations.Param;

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
public interface BankTradeInfoDao {
    //   获取当前登录用户的所有交易记录
    List<BankTradeInfo> selectListByUserName(@Param("userId") String userId);
    //根据类型查询交易信息
    List<BankTradeInfo> selectListByUserNameAndTradeType(@Param("userId") String userId,@Param("tradeType") String tradeType);
    //根据主键查询详情
    BankTradeInfo selectDetail(Integer id);
    //   获取当前登录用户的所有交易记录
    List<BankTradeInfoVo> selectListByConstomeId(String constomeId);
    //根据查询类型tradeType + 用户customerId 获取交易记录 tradeType 0 标识支出 1标识收入 ,2标识全部
    List<BankTradeInfoVo>  findBankTrdeShowPageList(@Param("constomeId") String constomeId,@Param("types") Integer types,@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize) ;

}
