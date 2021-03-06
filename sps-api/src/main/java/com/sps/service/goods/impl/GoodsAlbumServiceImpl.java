package com.sps.service.goods.impl;

import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.service.goods.GoodsAlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsAlbumServiceImpl implements GoodsAlbumService {
    @Resource
    private SpsGoodsAlbumMapper spsGoodsAlbumMapper;

    @Override
    public void saveOrUpdate(SpsGoodsAlbum goodsAlbum) {

    }

    @Override
    public SpsGoodsAlbum findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsGoodsAlbum> findList(Map<String, Object> map) {
        return spsGoodsAlbumMapper.findListAllWithMap(map);
    }
    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public void saveGoodsDetailPic(String goodsPic,String goodsDpic,Integer goodsId) {
        if (goodsDpic != null && !"".equals(goodsDpic)) {
            String[] urlList = goodsDpic.split(",");
            for (String url : urlList) {
                SpsGoodsAlbum album = new SpsGoodsAlbum();
                album.setAlbumCreateTime(new Date());
                album.setAlbumType(1);
                album.setAlbumUrl(url);
                album.setGoodsId(goodsId);
                album.setAlbumDeleteFlag(0);
                spsGoodsAlbumMapper.insert(album);
            }
        }
        if (goodsPic != null && !"".equals(goodsPic)) {
            String[] urlList = goodsPic.split(",");
            for (String url : urlList) {
                SpsGoodsAlbum album = new SpsGoodsAlbum();
                album.setAlbumCreateTime(new Date());
                album.setAlbumType(0);
                album.setAlbumUrl(url);
                album.setGoodsId(goodsId);
                album.setAlbumDeleteFlag(0);
                spsGoodsAlbumMapper.insert(album);

            }
        }
    }
}
