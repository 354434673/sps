package com.sps.service.goods.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsGoodSkuMapper;
import com.sps.entity.goods.SpsGoodSku;
import com.sps.service.goods.GoodSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodSkuServiceImpl implements GoodSkuService {
    @Resource
    private SpsGoodSkuMapper spsGoodSkuMapper;

    @Override
    public void saveOrUpdate(SpsGoodSku goodSku) {
        if (goodSku.getgId() != null) {
            goodSku.setgUpdateTime(new Date());
            spsGoodSkuMapper.update(goodSku);
        } else {
            //审核中
        /*    goodSku.setgAuditStatus(0);*/
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
    public HashMap<String, Object> findGoodSkuList(Integer page, Integer limit, String goodsName, String spuNo, String size,Integer auditStatus) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsName", goodsName);
        map.put("gAuditStatus", auditStatus);
        map.put("spuNo", spuNo);
        map.put("spec", size);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodSku> goodsList = spsGoodSkuMapper.findList(map);
       /* if(goodsList!=null&&goodsList.size()>0){
            for(SpsGoodSku list:goodsList){
                if("1".equals(list.getgType())){
                    list.setScale(list.getgScale() + "%");
                }else{
                    list.setScale(list.getgScale().toString());
                }
                if(list.getgAprice()!=null&&list.getgBprice()!=null){
                    list.setWaveInterval(list.getgAprice()+"-"+list.getgBprice());
                }
            }
        }*/
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

        return null;
    }

    @Override
    public void updateType(SpsGoodSku goodSku) {
        if(goodSku.getgId()!=null){
            goodSku.setgUpdateTime(new Date());
            spsGoodSkuMapper.update(goodSku);
        }
    }
}
