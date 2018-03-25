package com.sps.service.shopkeeper.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.dao.goods.SpsShopkeeperPersonalMapper;
import com.sps.dao.shopkeeper.SpsShopkeeperCarPrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperHousePrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperPersonalDao;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.goods.BrandService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShopkeeperPersonServiceImpl implements ShopkeeperPersonService {
    @Resource
    private SpsShopkeeperPersonalMapper spsShopkeeperPersonalMapper;
    @Resource
    private SpsShopkeeperPersonalDao spsShopkeeperPersonalDao;
    @Autowired
    private SpsShopkeeperCarPrppertyDao carDao;
    @Autowired
    private SpsShopkeeperHousePrppertyDao houseDao;

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
    public SpsShopkeeperPersonal  findPerson(String  customerId) {
        return  spsShopkeeperPersonalDao.selectByPersonId(customerId);
    }

    @Override
    public Boolean saveSrc(Integer id, String src) {
        SpsShopkeeperPersonal person = spsShopkeeperPersonalDao.getByPersonId(id);
        int m = spsShopkeeperPersonalDao.saveSrc(person.getPic().getPicId(), src);
        return m >0 ? true:false;
    }

    @Override
    public Boolean updateNickName(Integer id, String nickName) {
        int m = spsShopkeeperPersonalDao.updateNickName(id, nickName);
        return m >0 ? true:false;
    }

    @Override
    public SpsShopkeeperPersonal getByPersonId(Integer id) {
        return spsShopkeeperPersonalDao.getByPersonId(id);
    }

    @Override
    public Boolean saveCarInfo(SpsShopkeeperCarProperty spsShopkeeperCarProperty) {
        int m = carDao.saveCarInfo(spsShopkeeperCarProperty);
        return  m >0 ? true : false;
    }

    @Override
    public Boolean saveHouseInfo(SpsShopkeeperHouseProperty spsShopkeeperHouseProperty) {
        int m = houseDao.saveHouseInfo(spsShopkeeperHouseProperty);
        return m >0 ? true :false;
    }
}
