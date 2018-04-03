package com.sps.serviceImpl.merchant.write;

import com.sps.dao.merchant.write.SpsTradeLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsTradeLog;
import org.sps.service.merchant.write.SpsTradeLogWriteService;

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
@com.alibaba.dubbo.config.annotation.Service(timeout=2000,group="dianfu")
@Transactional
public class SpsTradeLogWriteServiceImpl implements SpsTradeLogWriteService {
    @Autowired
    private SpsTradeLogMapper spsTradeLogMapper;
    @Override
    public Boolean saveTradeLog(SpsTradeLog spsTradeLog) {
        int m = spsTradeLogMapper.insertTradeLog(spsTradeLog);
        return m >0 ? true:false;
    }
}
