package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.*;
import org.sps.service.goods.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "/goodShop")
public class GoodShopController {
    @Reference
    private GoodShopService goodService;
    @Reference
    private GoodSkuService goodSkuService;
    @Reference
    private BrandService brandService;



    /**
     * @param page
     * @param limit
     * @param goodsName
     * @return
     */
    @RequestMapping("/goodsList")
    @ResponseBody
    public HashMap<String, Object> goodsList(Integer page, Integer limit, String goodsName, Integer shopStatus,Integer flowStatus ) {
        HashMap<String, Object> goodsList = goodService.findGoodsList(page, limit, goodsName, shopStatus,flowStatus);
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
    public Map<String, Object> saveOrUpdate(SpsGoodShop goods) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodService.saveOrUpdate(goods);
            SpsGoodShop spsGoods = goodService.findLastId();
            if(spsGoods.getgId()!=null){
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
    public Map<String, Object> checkGoodsNumber(String gSpuNo, String spuName) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer result = goodService.getEntityBySearchLimit(gSpuNo,spuName);
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
     * @param id 分类ID
     * @return
     */


    @RequestMapping(value = "/findEntity")
    @ResponseBody
    public Map<String, Object> findEntity(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (id != null) {
                SpsGoodShop goods = goodService.findEntityById(id);
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
            goodService.falseDeletion(id);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }

    /**
     * 上下架商品
     * @return
     */
    @RequestMapping(value = "/onSale")
    @ResponseBody
    public Map<String, Object> onSale(String ids,String state) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (ids != null && !"".equals(ids)) {
                String[] idList = ids.split(",");
                for (String id : idList) {
                    SpsGoodShop goods = goodService.findEntityById(Integer.valueOf(id));
                    if(goods.getgStatus()!=1){
                        resultMap.put("msg", "请选择审核通过的商品");
                        resultMap.put("flag", 2);
                        return resultMap;
                    }
                }
                for (String id : idList) {
                    goodService.setSale(Integer.valueOf(id),state);
                }
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
     * 上下架商品
     * @return
     */
    @RequestMapping(value = "/onRecommend")
    @ResponseBody
    public Map<String, Object> onRecommend(String ids,String state) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (ids != null && !"".equals(ids)) {
                String[] idList = ids.split(",");
                for (String id : idList) {
                    SpsGoodShop goods = goodService.findEntityById( Integer.valueOf(id));
                    if(goods.getgStatus()!=1){
                        resultMap.put("msg", "请选择审核通过的商品");
                        resultMap.put("flag", 2);
                        return resultMap;
                    }
                }
                for (String id : idList) {
                    goodService.setRecommend(Integer.valueOf(id),state);
                }
                resultMap.put("flag", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }





}
