package com.sps.serviceImpl.merchant.read;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsBalanceReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelBalance;
import org.sps.service.merchant.read.SpsBalanceReadService;

import javax.annotation.Resource;
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
@Service(timeout = 12000, group = "dianfu")
@Transactional
public class SpsBalanceReadServiceImpl implements SpsBalanceReadService {
    @Resource
    private SpsBalanceReadMapper spsBalanceReadMapper;

    @Override
    public SpsChannelBalance  findByUserId(Integer userId, Integer userType) {

          return  spsBalanceReadMapper.selectByUserId(userId, userType);
    }
}
