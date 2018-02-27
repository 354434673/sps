package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoodsAlbum;
import org.springframework.stereotype.Repository;

import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodsAlbumMapper extends ApiBaseDaoImpl<SpsGoodsAlbum, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodsAlbum";
    }

    public void deleteDetailPic(Map<String, Object> map) {
        super.selectOne(getStatement("deletePic"),map);
    }
}