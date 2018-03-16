package com.sps.service.goods.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.ChannelEnterpriseDao;
import com.sps.dao.goods.SpsCustomCategoryMapper;
import com.sps.entity.goods.SpsCustomCategory;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.service.goods.CustomCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CustomCategoryServiceImpl implements CustomCategoryService {
    @Resource
    private ChannelEnterpriseDao enterpriseDao;
    @Resource
    private SpsCustomCategoryMapper spsCustomCategoryMapper;

    @Override
    public void saveOrUpdate(SpsCustomCategory customCategory) {
        if (customCategory.getCustomId() != null) {
            customCategory.setCustomUpdateTime(new Date());
            spsCustomCategoryMapper.update(customCategory);
        } else {
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

    }

    @Override
    public HashMap<String, Object> findCustomCategoryList(Integer page, Integer limit, String name, String shopNum) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("customShopNum", shopNum);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsCustomCategory> customCategoryList = spsCustomCategoryMapper.findListAllWithMap(map);
        PageInfo pageInfo = new PageInfo(customCategoryList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", customCategoryList.size() != 0 ? customCategoryList : null);
        return hashMap;
    }

    @Override
    public List<SpsCustomCategory>findByEnterpriseId(Integer enterpriseId) {
        ArrayList<String> arrayList = new ArrayList<String>();
        List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, null, enterpriseId);
        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("customShopNum", queryBusinessForApi.get(0).getChannelNum());
        List<SpsCustomCategory> categoryList = spsCustomCategoryMapper.findListAllWithMap(categoryMap);
        return categoryList;
    }

}
