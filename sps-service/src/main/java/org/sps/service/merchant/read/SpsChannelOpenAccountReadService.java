package org.sps.service.merchant.read;

import org.sps.service.goods.SaleLogService;

/**
 * Created by Administrator on 2018-04-08.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface SpsChannelOpenAccountReadService {

    String selectByOpenAdminNum(String loginName);
}
