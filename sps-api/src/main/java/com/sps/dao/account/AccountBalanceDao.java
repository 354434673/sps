package com.sps.dao.account;

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
    BigDecimal selectByUserId(@Param("userId") Integer userId, @Param("userType") Integer userType);
}
