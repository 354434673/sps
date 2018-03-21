package com.sps.service.shopkeeper.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.dao.goods.SpsShopkeeperPersonalMapper;
import com.sps.dao.shopkeeper.SpsShopkeeperPersonalDao;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.goods.BrandService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopkeeperPersonServiceImpl implements ShopkeeperPersonService {
    @Resource
    private SpsShopkeeperPersonalMapper spsShopkeeperPersonalMapper;
    @Resource
    private SpsShopkeeperPersonalDao spsShopkeeperPersonalDao;

    @Override
    public void saveOrUpdate(SpsShopkeeperPersonal spsShopkeeperPersonal) {

    }

    @Override
    public SpsShopkeeperPersonal findEntityById(Integer id) {
        return spsShopkeeperPersonalMapper.findById(id);
    }

    @Override
    public List<SpsShopkeeperPersonal> findList(Map<String, Object> map) {
        return spsShopkeeperPersonalMapper.findListAllWithMap(map);
    }

    @Override
    public SpsShopkeeperPersonal findEntityByCustomerNum(String customerNum) {
        return spsShopkeeperPersonalMapper.findEntityByCustomerNum(customerNum);
    }

    @Override
    public String  findPerson(Integer personId) {
        SpsShopkeeperPersonal spsShopkeeperPersonal = spsShopkeeperPersonalDao.selectByPersonId(personId);
        return spsShopkeeperPersonal.getPersonalIdcard();
    }
}
