package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsGoodSkuLogMapper;
import com.sps.dao.goods.SpsGoodSkuMapper;
import org.sps.entity.goods.SpsGoodSku;
import org.sps.entity.goods.SpsGoodSkuLog;
import org.sps.service.goods.GoodSkuLogService;
import org.sps.service.goods.GoodSkuService;
import util.NumberUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000)
public class GoodSkuLogServiceImpl implements GoodSkuLogService {
    @Resource
    private SpsGoodSkuLogMapper spsGoodSkuLogMapper;

    @Override
    public void saveOrUpdate(SpsGoodSkuLog log) {
        if (log.getgId() != null) {
            log.setgUpdateTime(new Date());
            spsGoodSkuLogMapper.update(log);
        } else {
            log.setgCreateTime(new Date());
            spsGoodSkuLogMapper.insert(log);
        }

    }

    @Override
    public SpsGoodSkuLog findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsGoodSkuLog> findList(Map<String, Object> map) {
        return null;
    }
}
