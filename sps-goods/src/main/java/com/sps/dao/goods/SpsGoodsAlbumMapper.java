package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoodsAlbum;

import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodsAlbumMapper extends BaseDaoImpl<SpsGoodsAlbum, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodsAlbum";
    }

    public void deleteDetailPic(Map<String, Object> map) {
        super.selectOne(getStatement("deletePic"),map);
    }
}