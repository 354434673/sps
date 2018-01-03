package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsBrandMapper;
import org.sps.entity.goods.SpsBrand;
import org.sps.service.goods.BrandService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Override
    public void saveOrUpdate(SpsBrand brand) {
        if(brand.getBrandId()!=null){
            brand.setBrandUpdateTime(new Date());
            spsBrandMapper.update(brand);
        }else{
            brand.setBrandDeleteFlag(0);
            brand.setBrandCreateTime(new Date());
            spsBrandMapper.insert(brand);
        }
    }

    @Override
    public SpsBrand findEntityById(Integer id) {
        return spsBrandMapper.findById(id);
    }

    @Override
    public List<SpsBrand> findList(Map<String, Object> map) {
        return spsBrandMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {
        SpsBrand brand = new SpsBrand();
        brand.setBrandId(id);
        brand.setBrandDeleteFlag(1);
        spsBrandMapper.update(brand);
    }

    @Override
    public HashMap<String, Object> findBrandList(Integer page, Integer limit, String brandName, String brandEnglishName) {

        Map<String, Object> map = new HashMap<>();
        map.put("brandName", brandName);
        map.put("brandEnglishName", brandEnglishName);
        //分页
        PageHelper.startPage(page,limit);
        List<SpsBrand> brandList = spsBrandMapper.findListAllWithMap(map);
        PageInfo pageInfo = new PageInfo(brandList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count",  pageInfo.getTotal());
        hashMap.put("data", brandList.size() != 0 ? brandList : null);
        return hashMap;
    }
}
