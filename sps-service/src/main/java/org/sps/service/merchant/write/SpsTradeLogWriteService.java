package org.sps.service.merchant.write;

import org.sps.entity.merchant.SpsTradeLog;

/**
 * Created by Administrator on 2018-03-31.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface SpsTradeLogWriteService {
    //保存一条异常交易记录
    Boolean saveTradeLog(SpsTradeLog spsTradeLog);
}
