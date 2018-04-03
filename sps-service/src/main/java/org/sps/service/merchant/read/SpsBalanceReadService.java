package org.sps.service.merchant.read;

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
public interface SpsBalanceReadService {
    SpsChannelBalance  findByUserId(String userNo, Integer userType);
}
