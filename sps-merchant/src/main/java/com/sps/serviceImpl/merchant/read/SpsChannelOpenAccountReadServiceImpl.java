package com.sps.serviceImpl.merchant.read;

import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sps.service.merchant.read.SpsChannelOpenAccountReadService;

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
@com.alibaba.dubbo.config.annotation.Service(timeout = 12000, group = "dianfu")
@Transactional
public class SpsChannelOpenAccountReadServiceImpl implements SpsChannelOpenAccountReadService{
    @Autowired
    private SpsChannelOpenAccountReadMapper openAccount;
    @Override
    public String selectByOpenAdminNum(String loginName) {
        return  openAccount.selectByOpenAdminNum(loginName);
    }
}

