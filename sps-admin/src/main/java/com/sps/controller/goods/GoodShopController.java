package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.controller.system.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.*;
import org.sps.service.goods.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping(value = "/goodShop")
public class GoodShopController {
    @Reference(check=false,group="dianfu")
    private GoodShopService goodService;
    @Reference(check=false,group="dianfu")
    private GoodCategoryService goodCategoryService;
    @Reference(check=false,group="dianfu")
    private GoodShopSkuService goodSkuService;
    @Reference(check=false,group="dianfu")
    private BrandService brandService;
    @Reference(check=false,group="dianfu")
    private CustomCategoryService customCategoryService;
    @Reference(check=false,group="dianfu")
    private GoodSkuService skuService;
    @Resource
    UserController userController;



    /**
     * @param page
     * @param limit
     * @param goodsName
     * @return
     */
    @RequestMapping("/goodsList")
    @ResponseBody
    public HashMap<String, Object> goodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime) {
        String shopNum= userController.getNumForUserType();
        HashMap<String, Object> goodsList = goodService.findGoodsList(page, limit, goodsName, shopStatus, flowStatus, endTime, startTime,shopNum);
        return goodsList;
    }

    /**
     * 商户详情查询商品列表
     * @param page
     * @param limit
     * @param goodsName
     * @return
     */
    @RequestMapping("/findShopGoodsList")
    @ResponseBody
    public HashMap<String, Object> goodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime,String shopNum,String spuNo) {
        HashMap<String, Object> goodsList = goodService.findShopGoodsList(page, limit, goodsName, shopStatus, flowStatus, endTime, startTime,shopNum,spuNo);
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
        return "goodShop/addGoods";
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
            String shopId= userController.getNumForUserType();
            goods.setgShopId(shopId);
            goodService.saveOrUpdate(goods);
            SpsGoodShop spsGoods = goodService.findLastId();
            if (spsGoods.getgId() != null) {
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
            Integer result = goodService.getEntityBySearchLimit(gSpuNo, spuName);
            if (result > 0) {
                resultMap.put("flag", 1);
            } else {
                resultMap.put("flag", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return "goodShop/detailGoods";
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
                SpsGoodShop goods = goodService.findEntityById(id);
                if (goods.getgBrandId() != null) {
                    //查询商品品牌信息
                    SpsBrand spsBrand = brandService.findEntityById(goods.getgBrandId());
                    resultMap.put("brandName", spsBrand.getBrandName());
                }
                if (goods.getgCategoryIds() != null) {
                    //查询商品品牌信息
                    String[] ids = goods.getgCategoryIds().split(",");
                    SpsGoodCategory firstCategory = goodCategoryService.findEntityById(Integer.valueOf(ids[0]));
                    resultMap.put("firstCategory", firstCategory.getCategoryName());
                    SpsGoodCategory twoCategory = goodCategoryService.findEntityById(Integer.valueOf(ids[1]));
                    resultMap.put("twoCategory", twoCategory.getCategoryName());
                    SpsGoodCategory threeCategory = goodCategoryService.findEntityById(Integer.valueOf(ids[2]));
                    resultMap.put("threeCategory", threeCategory.getCategoryName());
                }
                if (goods.getgCategorySelf() != null) {
                    //查询自定义分类信息
                    SpsCustomCategory category = customCategoryService.findEntityById(goods.getgCategorySelf());
                    resultMap.put("customName", category.getCustomName());
                }
                //查询商品sku
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                List<SpsGoodShopSku> skuList = goodSkuService.findList(map);
                //获取到核心商户sku中的skuId
                String skuIds = "";
                if (skuList != null && skuList.size() > 0) {
                    for (int i = 0; i < skuList.size(); i++) {
                        if (i == skuList.size() - 1) {
                            skuIds += skuList.get(i).getgSkuId();
                        } else {
                            skuIds += skuList.get(i).getgSkuId() + ",";
                        }
                    }
                }
                String[] idList = skuIds.split(",");
                Map<String, Object> map1 = new HashMap<>();
                map1.put("gGoodNo", goods.getgSpuNo());
                map1.put("list", idList);
                //查询不在核心商户表中的平台sku
                List<SpsGoodSku> spsGoodSkuList = skuService.findList(map1);
                resultMap.put("newList", spsGoodSkuList);
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
     *
     * @return
     */
    @RequestMapping(value = "/onSale")
    @ResponseBody
    public Map<String, Object> onSale(String ids, String state) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (ids != null && !"".equals(ids)) {
                String[] idList = ids.split(",");
                for (String id : idList) {
                    SpsGoodShop goods = goodService.findEntityById(Integer.valueOf(id));
                    if("1".equals(state )){
                        if ("1".equals(goods.getgGroundingFlag() )) {
                            resultMap.put("msg", "已有商品为上架状态，请重新选择");
                            resultMap.put("flag", 3);
                            return resultMap;
                        }
                    }
                    if (goods.getgStatus() != 2) {
                        resultMap.put("msg", "请选择审核通过的商品");
                        resultMap.put("flag", 2);
                        return resultMap;
                    }

                }
                for (String id : idList) {
                    goodService.setSale(Integer.valueOf(id), state);
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
     *
     * @return
     */
    @RequestMapping(value = "/onRecommend")
    @ResponseBody
    public Map<String, Object> onRecommend(String ids, String state) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (ids != null && !"".equals(ids)) {
                String[] idList = ids.split(",");
                for (String id : idList) {
                    SpsGoodShop goods = goodService.findEntityById(Integer.valueOf(id));
                    if("1".equals(state )) {
                        if ("1".equals(goods.getgRecommend())) {
                            resultMap.put("flag", 3);
                            return resultMap;
                        }
                    }
                    if (goods.getgStatus() != 2) {
                        resultMap.put("msg", "请选择审核通过的商品");
                        resultMap.put("flag", 2);
                        return resultMap;
                    }
                }
                for (String id : idList) {
                    goodService.setRecommend(Integer.valueOf(id), state);
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
     * 把String数据转换成Long类型数组
     *
     * @param array
     * @return
     */
    public static Long[] convertStringArrayToLong(String[] array) {
        List<Long> list = new ArrayList<Long>();
        for (String num : array) {
            if (num != null && !num.trim().equals("")) {
                list.add(Long.parseLong(num));
            }

        }
        return list.toArray(new Long[list.size()]);
    }


}
