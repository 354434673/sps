package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsGoodSkuMapper;
import org.sps.entity.goods.SpsGoodSku;
import org.sps.service.goods.GoodSkuService;
import util.NumberUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000,group="dianfu-dev")
public class GoodSkuServiceImpl implements GoodSkuService {
    @Resource
    private SpsGoodSkuMapper spsGoodSkuMapper;

    @Override
    public void saveOrUpdate(SpsGoodSku goodSku) {
        if (goodSku.getgId() != null) {
            goodSku.setgUpdateTime(new Date());
            spsGoodSkuMapper.update(goodSku);
        } else {
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
        Map<String, Object> map = new HashMap<>();
        map.put("goodsName", goodsName);
        map.put("spuNo", spuNo);
        map.put("size", size);

        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodSku> goodsList = spsGoodSkuMapper.findList(map);
        PageInfo pageInfo = new PageInfo(goodsList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", goodsList.size() != 0 ? goodsList : null);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updatePrice(List<SpsGoodSku> goodSku) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (goodSku != null && goodSku.size() > 0) {
            for (SpsGoodSku sku : goodSku) {
                SpsGoodSku shopSku = spsGoodSkuMapper.findById(sku.getgId());
                //判断是否和原有库存价格相等 如果不等 修改
                if ((!shopSku.getgPrice().equals(sku.getgPrice())) || (!shopSku.getgType().equals(sku.getgType())) || (!shopSku.getgScale().equals(sku.getgScale()))) {
                    if ("0".equals(sku.getgType())) {
                        Double aPrice = NumberUtil.add(sku.getgPrice().doubleValue(), sku.getgScale().doubleValue());
                        Double bPrice = NumberUtil.sub(sku.getgPrice().doubleValue(), sku.getgScale().doubleValue());
                        sku.setgAprice(BigDecimal.valueOf(aPrice));
                        sku.setgBprice(BigDecimal.valueOf(bPrice));
                        sku.setgUpdateTime(new Date());
                        spsGoodSkuMapper.update(sku);
                    } else if ("1".equals(sku.getgType())) {
                        //具体算法看原型
                        Double scale = NumberUtil.div(sku.getgScale().doubleValue(), 100);
                        Double scaleVal = NumberUtil.mul(sku.getgPrice().doubleValue(), scale);
                        Double a = NumberUtil.add(scaleVal, sku.getgPrice().doubleValue());
                        Double b = NumberUtil.sub(sku.getgPrice().doubleValue(), scaleVal);
                        sku.setgAprice(BigDecimal.valueOf(b));
                        sku.setgBprice(BigDecimal.valueOf(a));
                        sku.setgUpdateTime(new Date());
                        spsGoodSkuMapper.update(sku);
                    }
                }
            }
        }
        hashMap.put("msg", "修改成功");
        hashMap.put("state", "success");
        return hashMap;
    }
}
