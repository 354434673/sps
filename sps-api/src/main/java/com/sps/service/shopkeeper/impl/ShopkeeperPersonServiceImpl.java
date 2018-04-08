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
import com.sps.dao.shopkeeper.SpsShopkeeperPicDao;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.service.goods.BrandService;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.vo.SpsShopFindPersonInfoVo;import com.sps.service.goods.BrandService;
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
    @Autowired
    private SpsShopkeeperPicDao spsShopkeeperPicDao;

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
    public SpsShopFindPersonInfoVo findEntityByCustomerNum(String customerNum) {
        return spsShopkeeperPersonalMapper.findEntityByCustomerNum(customerNum);
    }

    @Override
    public SpsShopkeeperPersonal  findPerson(String  customerId) {
        return  spsShopkeeperPersonalDao.selectByPersonId(customerId);
    }

    @Override
    public Boolean saveSrc(String customerId, String src) {
        //根据客户编号查看是否存在头像记录
        SpsShopkeeperPic pic = spsShopkeeperPicDao.selectByCustomerId(customerId);
        if(pic==null){
            //保存一条头像记录
            SpsShopkeeperPic spsShopkeeperPic = new SpsShopkeeperPic();
            spsShopkeeperPic.setPicSrc(src);
            spsShopkeeperPic.setPicType(17);
            spsShopkeeperPic.setPicState(0);
            spsShopkeeperPic.setPicUploadTime(new Date());
            spsShopkeeperPic.setPicCreatTime(new Date());
            spsShopkeeperPic.setShopkeeperCustomerid(customerId);
            int m = spsShopkeeperPicDao.insert(spsShopkeeperPic);
            return m >0 ? true:false;
        }else{
            //修改记录
            int m = spsShopkeeperPicDao.saveSrc(pic.getPicId(), src,new Date());
            return m >0 ? true:false;
        }



    }

    @Override
    public Boolean updateNickName(String customerId, String nickName) {
        int m = spsShopkeeperPersonalDao.updateNickName(customerId, nickName,new Date());
        return m >0 ? true:false;
    }

    @Override
    public SpsShopkeeperPersonal getByPersonId(String customerId ) {
        return spsShopkeeperPersonalDao.selectByPersonId(customerId);
    }

    @Override
    public List<SpsShopkeeperCarProperty> getCardInfo(String consumerId) {
        return carDao.selectByCustomerId(consumerId);
    }

    @Override
    public List<SpsShopkeeperHouseProperty> getHouseInfo(String consumerId) {
        return houseDao.selectByCustomerId(consumerId);
    }


    @Override
    public Boolean saveCarInfo(SpsShopkeeperCarProperty spsShopkeeperCarProperty,String src) {
        int m = carDao.saveCarInfo(spsShopkeeperCarProperty);
        SpsShopkeeperPic spsShopkeeperPic = new SpsShopkeeperPic();
        spsShopkeeperPic.setPicSrc(src);
        spsShopkeeperPic.setPicType(12);
        spsShopkeeperPic.setPicUploadTime(new Date());
        spsShopkeeperPic.setPicCreatTime(new Date());
        spsShopkeeperPic.setShopkeeperCustomerid(spsShopkeeperCarProperty.getShopkeeperCustomerid());
        int n = spsShopkeeperPicDao.insert(spsShopkeeperPic);
        return m > 0 && n > 0 ? true : false;
    }
    @Override
    public SpsShopkeeperPersonal findByCustomerNum(String shopkeeperNum) {
        return spsShopkeeperPersonalMapper.findByCustomerNum(shopkeeperNum);
    }
    @Override
    public Boolean saveHouseInfo(SpsShopkeeperHouseProperty spsShopkeeperHouseProperty,List<String> lists) {
        int m = houseDao.saveHouseInfo(spsShopkeeperHouseProperty);
        int n=0;
        for (int i=0;i<lists.size();i++){
            SpsShopkeeperPic spsShopkeeperPic = new SpsShopkeeperPic();
            spsShopkeeperPic.setPicSrc(lists.get(i));
            spsShopkeeperPic.setPicType(11);
            spsShopkeeperPic.setPicUploadTime(new Date());
            spsShopkeeperPic.setPicCreatTime(new Date());
            spsShopkeeperPic.setShopkeeperCustomerid(spsShopkeeperHouseProperty.getShopkeeperCustomerid());
            n = spsShopkeeperPicDao.insert(spsShopkeeperPic);
        }
        return m > 0 && n > 0 ? true : false;
    }
}
