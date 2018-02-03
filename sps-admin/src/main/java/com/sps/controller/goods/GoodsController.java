package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.*;
import org.sps.service.goods.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Reference(check=false,group="dianfu")
    private GoodsService goodService;
    @Reference(check=false,group="dianfu")
    private GoodSkuService goodSkuService;
    @Reference(check=false,group="dianfu")
    private BrandService brandService;
    @Reference(check=false,group="dianfu")
    private GoodsAlbumService goodsAlbumService;
    @Reference(check=false,group="dianfu-dev")
    private GoodCategoryService goodCategoryService;


    /**
     * @param page
     * @param limit
     * @param goodsName
     * @param goodsNo
     * @return
     */
    @RequestMapping("/goodsList")
    @ResponseBody
    public HashMap<String, Object> goodsList(Integer page, Integer limit, String goodsName, String goodsNo,String flowStatus) {
        HashMap<String, Object> goodsList = goodService.findGoodsList(page, limit, goodsName, goodsNo,flowStatus);
        return goodsList;
    }


    /**
     * 进入商品分类新增页面
     *
     * @return
     */
    @RequestMapping("/toAddOrEdit")
    public String toAddOrEdit(Integer id, Model model) {
        try {
            if (id != null) {
                model.addAttribute("goodsId", id);
            }
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "goods/addGoods";
    }

    /**
     * 添加或者修改
     *
     * @return
     */

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SpsGoods goods,String goodsDpic,String goodsPic, Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodService.saveOrUpdate(goods);
            SpsGoods spsGoods = goodService.findLastId();
            if(spsGoods.getgId()!=null){
                //处理商品相册逻辑
                goodsAlbumService.saveGoodsDetailPic(goodsPic, goodsDpic,spsGoods.getgId());
                resultMap.put("goodsId", spsGoods.getgId());
            }
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
    /**
     * 进入商品分类新增页面
     *
     * @return
     */
    @RequestMapping("checkGoodsNumber")
    @ResponseBody
    public Map<String, Object> checkGoodsNumber(String gSpuNo, Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer result = goodService.getEntityBySearchLimit(gSpuNo);
            if (result > 0) {
                resultMap.put("flag", 1);
            } else {
                resultMap.put("flag", 0);
            }
        } catch (Exception e) {
            String errorMsg = "操作失败";
            resultMap.put("msg", errorMsg);
            resultMap.put("flag", 0);
        }
        return resultMap;
    }
    @RequestMapping("toGoodsDetail")
    public String toGoodsDetail(Integer id, Model model) {
        try {
            if (id != null) {
                model.addAttribute("goodsId", id);
            }
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "goods/detailGoods";
    }


    /**
     * 根据分类ID查找详情
     *
     * @param id 分类ID
     * @return
     */


    @RequestMapping(value = "/findEntity")
    @ResponseBody
    public Map<String, Object> findEntity(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (id != null) {
                SpsGoods goods = goodService.findEntityById(id);
                //拼接分类名称
                if(!"".equals(goods.getgCategoryIds())){
                    String categoryNames = "";
                    String[] ids = goods.getgCategoryIds().split(",");
                    for (String categoryId : ids) {
                        SpsGoodCategory category = goodCategoryService.findEntityById(Integer.valueOf(categoryId));
                        categoryNames += ">" + category.getCategoryName();
                    }
                    goods.setgCategoryNames(categoryNames.substring(1));
                }
                if(goods.getgBrandId()!=null){
                    //查询商品品牌信息
                    SpsBrand spsBrand = brandService.findEntityById(goods.getgBrandId());
                    resultMap.put("brandName", spsBrand.getBrandName());
                }
                //查询商品sku
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                List<SpsGoodSku> skuList = goodSkuService.findList(map);
                resultMap.put("skuList", skuList);
                //查询商品图片
                Map<String, Object> albumMap = new HashMap<>();
                albumMap.put("goodsId", goods.getgId());
                List<SpsGoodsAlbum> picList=new ArrayList<>();
                List<SpsGoodsAlbum> detailList=new ArrayList<>();
                List<SpsGoodsAlbum> albumList = goodsAlbumService.findList(map);
                if(albumList!=null&&albumList.size()>0){
                    for(SpsGoodsAlbum list : albumList){
                        //1为详情图 0为主图
                        if(list.getAlbumType()==1){
                            detailList.add(list);
                        }else if(list.getAlbumType()==0){
                            picList.add(list);
                        }
                    }
                }
                //主图
                resultMap.put("picList", picList);
                //详情图
                resultMap.put("detailList", detailList);
                resultMap.put("goods", goods);
                resultMap.put("flag", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }

    /**
     * 假删除
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/delGoods")
    @ResponseBody
    public Map<String, Object> delGoods(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if(id!=null){
                goodService.falseDeletion(id);
            }
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
    /**
     * 根据品牌ID查询商品
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/findBrandGoods")
    @ResponseBody
    public Map<String, Object> findBrandGoods(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("brandId", id);
            List<SpsGoods> goodsList= goodService.findList(map);
            resultMap.put("goodsList", goodsList);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
}
