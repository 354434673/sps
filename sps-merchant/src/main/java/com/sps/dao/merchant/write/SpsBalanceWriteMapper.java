package com.sps.dao.merchant.write;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBalance;

import java.math.BigDecimal;
import java.util.Date;

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
public interface SpsBalanceWriteMapper {
    int updateBalance(@Param("id") Integer id,@Param("balance") BigDecimal balance, @Param("updateTime") Date updateTime);

    int insertBalance(  SpsChannelBalance spsChannelBalance );
}
