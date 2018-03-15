package com.sps.dao.merchant.read;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBalance;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-03-14.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface SpsBalanceReadMapper {
    SpsChannelBalance selectByUserId(@Param("userId") Integer userId, @Param("userType") Integer userType);
}
