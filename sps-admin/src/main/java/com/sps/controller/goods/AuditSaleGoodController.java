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
@RequestMapping(value = "/auditGood")
public class AuditSaleGoodController {
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


    /**
     * 平台端审核商品上架
     * @param page
     * @param limit
     * @param goodsName
     * @return
     */
    @RequestMapping("/goodsList")
    @ResponseBody
    public HashMap<String, Object> goodsList(Integer page, Integer limit, String goodsName,String shopName,String shopNumber, Integer shopStatus, String endTime, String startTime) {
        HashMap<String, Object> goodsList = goodService.findAutidGoodsList(page, limit, shopName,goodsName,shopNumber, shopStatus, endTime, startTime);
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
        return "auditSale/detailGoods";
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
                    //查询商品品牌信息
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
                map1.put("gNo", goods.getgSpuName());
                map1.put("list", idList);
                List<SpsGoodSku> spsGoodSkuList = skuService.findList(map1);
                //这里明天该
               /* List list1 = new ArrayList();
                //排除掉核心商户sku表中的ids
                if (spsGoodSkuList != null && spsGoodSkuList.size() > 0) {
                    String[] idList = skuIds.split(",");
                    for (String ids : idList) {
                        for (SpsGoodSku list : spsGoodSkuList) {
                            if (!list.getgId().equals(Integer.valueOf(ids))) {
                                list1.add(list);
                            }
                        }
                    }
                }
                resultMap.put("newList", list1);*/
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
     * 进入商品分类新增页面
     *
     * @return
     */
    @RequestMapping("/toAudit")
    public String toAudit(Integer id, Model model) {
        try {
            if (id != null) {
                model.addAttribute("goodsId", id);
            }
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "auditSale/auditGoods";
    }


    /**
     * 审核商品
     * @return
     */
    @RequestMapping(value = "/auditShopGood")
    @ResponseBody
    public Map<String, Object> auditShopGood(SpsGoodShop goods) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodService.auditShopGood(goods);
            resultMap.put("flag", 1);
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
