package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.goods.SpsGoodSkuMapper;
import org.sps.entity.goods.SpsGoodSku;
import org.sps.service.goods.GoodSkuService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000)
public class GoodSkuServiceImpl implements GoodSkuService {
    @Resource
    private SpsGoodSkuMapper spsGoodSkuMapper;

    @Override
    public void saveOrUpdate(SpsGoodSku goodSku) {
        if(goodSku.getgId()!=null){
            goodSku.setgUpdateTime(new Date());
            spsGoodSkuMapper.update(goodSku);
        }else{
            goodSku.setgDeleteFlag(0);
            goodSku.setgCreateTime(new Date());
            spsGoodSkuMapper.insert(goodSku);
        }
    }

    @Override
    public SpsGoodSku findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsGoodSku> findList(Map<String, Object> map) {
        return spsGoodSkuMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public HashMap<String, Object> findGoodSkuList(Integer page, Integer limit, String goodsName, String spuNo, String size) {
        return null;
    }
}
