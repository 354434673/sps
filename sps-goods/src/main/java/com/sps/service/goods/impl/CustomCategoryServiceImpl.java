package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsCustomCategoryMapper;
import com.sps.dao.goods.SpsGoodShopMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.sps.entity.goods.SpsCustomCategory;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.service.goods.CustomCategoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000,group="dianfu")
public class CustomCategoryServiceImpl implements CustomCategoryService {

    @Resource
    private SpsCustomCategoryMapper spsCustomCategoryMapper;
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;
    @Override
    public void saveOrUpdate(SpsCustomCategory customCategory) {
        if(customCategory.getCustomId()!=null){
            customCategory.setCustomUpdateTime(new Date());
            spsCustomCategoryMapper.update(customCategory);
        }else{
            customCategory.setCustomDeleteFlag(0);
            customCategory.setCustomCreateTime(new Date());
            spsCustomCategoryMapper.insert(customCategory);
        }
    }

    @Override
    public SpsCustomCategory findEntityById(Integer id) {
        return spsCustomCategoryMapper.findById(id);
    }

    @Override
    public List<SpsCustomCategory> findList(Map<String, Object> map) {
         return spsCustomCategoryMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {
        SpsCustomCategory customCategory = new SpsCustomCategory();
        customCategory.setCustomId(id);
        customCategory.setCustomDeleteFlag(1);
        spsCustomCategoryMapper.update(customCategory);
        //删除商品中的自定义分类
        Map<String, Object> map = new HashMap<>();
        map.put("customCategoryId", id);
        List<SpsGoodShop> list = spsGoodShopMapper.findListAllWithMap(map);
        if(list!=null&&list.size()>0){
            for(SpsGoodShop goodsList : list){
                SpsGoodShop spsGoodShop = new SpsGoodShop();
                spsGoodShop.setgId(goodsList.getgId());
                spsGoodShop.setgCategorySelf(null);
                spsGoodShopMapper.updateCustomCategory(spsGoodShop);
            }
        }

    }

    @Override
    public HashMap<String, Object> findCustomCategoryList(Integer page, Integer limit, String name,String shopNum) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("customShopNum", shopNum);
        //分页
        PageHelper.startPage(page,limit);
        List<SpsCustomCategory> customCategoryList = spsCustomCategoryMapper.findListAllWithMap(map);
        PageInfo pageInfo = new PageInfo(customCategoryList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count",  pageInfo.getTotal());
        hashMap.put("data", customCategoryList.size() != 0 ? customCategoryList : null);
        return hashMap;
    }

}
