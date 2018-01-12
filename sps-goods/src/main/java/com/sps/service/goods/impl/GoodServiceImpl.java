package com.sps.service.goods.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsGoodSkuMapper;
import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import org.sps.entity.goods.SpsGoods;
import org.sps.entity.goods.SpsGoodsAlbum;
import org.sps.service.goods.GoodsService;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000)
public class GoodServiceImpl implements GoodsService {
    @Resource
    private SpsGoodsMapper spsGoodsMapper;
    @Resource
    private SpsGoodSkuMapper spsGoodSkuMapper;
    @Resource
    private SpsGoodsAlbumMapper spsGoodsAlbumMapper;

    @Override
    public void saveOrUpdate(SpsGoods goods) {
        if(goods.getgId()!=null){
            //如果UpdateDetailFlag不为空 则删除 改商品的详情图
            if(goods.getUpdateDetailFlag()!=null){
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                map.put("updateDetailFlag", goods.getUpdateDetailFlag());
                spsGoodsAlbumMapper.deleteDetailPic(map);
            }
            //如果UpdatePicFlag 则删除 改商品的主图
            if(goods.getUpdatePicFlag()!=null){
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                map.put("updatePicFlag", goods.getUpdatePicFlag());
                spsGoodsAlbumMapper.deleteDetailPic(map);
            }
            //删除sku中的商品数据
            spsGoodSkuMapper.deleteSku(goods.getgId());
            goods.setgUpdateTime(new Date());
            spsGoodsMapper.update(goods);
        }else{
            goods.setgDeleteFlag(0);
            goods.setgCreateTime(new Date());
            spsGoodsMapper.insert(goods);
        }
    }

    @Override
    public SpsGoods findEntityById(Integer id) {
        return spsGoodsMapper.findById(id);
    }

    @Override
    public List<SpsGoods> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {
        SpsGoods goods = new SpsGoods();
        goods.setgId(id);
        goods.setgDeleteFlag(1);
        spsGoodsMapper.update(goods);

    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, String goodsNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsName", goodsName);
        map.put("goodsNo", goodsNo);
        //分页
        PageHelper.startPage(page,limit);
        List<SpsGoods> goodsList = spsGoodsMapper.findListAllWithMap(map);
        PageInfo pageInfo = new PageInfo(goodsList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count",  pageInfo.getTotal());
        hashMap.put("data", goodsList.size() != 0 ? goodsList : null);
        return hashMap;
    }

    @Override
    public SpsGoods findLastId() {
      return spsGoodsMapper.findLastId();
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo) {
        return spsGoodsMapper.getEntityBySearchLimit(gSpuNo);
    }
}
