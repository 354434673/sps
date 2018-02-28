package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.dao.goods.SpsSaleLogMapper;
import org.sps.entity.goods.SpsBrand;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.entity.goods.SpsSaleLog;
import org.sps.service.goods.BrandService;
import org.sps.service.goods.SaleLogService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000,group="dianfu")
public class SaleLogServiceImpl implements SaleLogService {
    @Resource
    private SpsSaleLogMapper spsSaleLogMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsSaleLog log) {
        if (log.getSaleId() != null) {
            log.setSaleUpdateTime(new Date());
            spsSaleLogMapper.update(log);
        } else {
            log.setSaleCreateTime(new Date());
            spsSaleLogMapper.insert(log);
        }
    }

    @Override
    public SpsBrand findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsBrand> findList(Map<String, Object> map) {
        return null;
    }
}
