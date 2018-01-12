package org.sps.service.goods;
import org.sps.entity.goods.SpsBrand;
import org.sps.entity.goods.SpsGoodsAlbum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsAlbumService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoodsAlbum goodsAlbum);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodsAlbum findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoodsAlbum> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

    /**
     * 插入详情图
     * @param goodsDpic
     */
    void saveGoodsDetailPic(String goodsPic,String goodsDpic,Integer goodsId);
}
