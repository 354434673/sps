package com.sps.controller.goods;

import com.sps.common.*;
import com.sps.entity.goods.*;
import com.sps.service.goods.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/goods")
public class goodsController {
    @Resource
    private ApiGoodShopService goodShopService;
    @Resource
    private GoodShopSkuService goodShopSkuService;
    @Resource
    private CustomCategoryService customCategoryService;

    @Resource
    private BrandService brandService;
    @Resource
    private GoodCategoryService goodCategoryService;


    /**
     * 根据ID商品详情
     *
     * @return
     */
    @RequestMapping(value = "/findCustomerCategory", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findCustomerCategory(Integer enterpriseId) {
        ReturnInfo ri = new ReturnInfo();
        try {
            List<SpsCustomCategory> categoryList = customCategoryService.findByEnterpriseId(enterpriseId);
            String[] pro = new String[]{"customId", "customName", "customWide"};
            if (categoryList != null) {
                ri.setResult(EntityUtiles.reloadListPropertyValue(categoryList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 根据ID商品详情
     *
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(Integer id) {
        ReturnInfo ri = new ReturnInfo();
        try {
            HashMap<String, Object> data = new HashMap<String, Object>();//封装对象
            SpsGoodShop goods = goodShopService.findById(id);
            data.put("gId", goods.getgId());
            data.put("gSpuName", goods.getgSpuName());
            data.put("gMinPrice", goods.getgMinPrice());
            data.put("albumList", goods.getAlbumList());
            data.put("albumDetailList", goods.getAlbumDetailList());
            if (goods != null) {
                ri.setResult(data);
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 根据ID查询Sku
     *
     * @return
     */
    @RequestMapping(value = "/findSkuById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(Integer goodsId) {
        Map<String, Object> map = new HashMap<>();
        ReturnInfo ri = new ReturnInfo();
        try {
            map.put("goodsId", goodsId);
            List<SpsGoodShopSku> skuList = goodShopSkuService.findList(map);
            String[] pro = new String[]{"gId", "gGid", "gColorSize", "gColor", "gSize", "gPrice", "gQuantity", "gStock"};
            if (skuList != null) {
                ri.setResult(EntityUtils.reloadListPropertyValue(skuList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


    /**
     * 根据商品分类查询品牌列表
     *
     * @return
     */
    @RequestMapping(value = "/getBrandList")
    @ResponseBody
    public ReturnInfo getBrandList(String categoryIds) {
        ReturnInfo ri = new ReturnInfo();
        try {
            List<SpsBrand> list = new ArrayList<>();
            String[] ids = categoryIds.split(",");
            for (String id : ids) {
                Map<String, Object> map = new HashMap<>();
                map.put("categoryIds", id);
                List<SpsBrand> spsBrandList = brandService.findList(map);
                if (spsBrandList != null && spsBrandList.size() > 0) {
                    for (SpsBrand brand : spsBrandList) {
                        list.add(brand);
                    }
                }
            }
            String[] pro = new String[]{"brandId", "brandName"};
            if (list != null) {
                ri.setResult(EntityUtiles.reloadListPropertyValue(list, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 查询主营业务
     *
     * @return
     */
    @RequestMapping("/getFistCategory")
    @ResponseBody
    public ReturnInfo getFistCategory(String ids) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String, Object> map = new HashMap<>();
            if (ids == null) {
                //先查父类
                map.put("isFirst", "0");
                List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
                String[] pro = new String[]{"categoryId", "categoryName"};
                if (categoryList != null) {
                    ri.setResult(EntityUtiles.reloadListPropertyValue(categoryList, pro));
                    ri.setSuccess(Message.SUCCESS_MSG);
                    ri.setCode(Message.SUCCESS_CODE);
                    ri.setMsg(Message.API_SUCCESS_MSG);
                }

            } else {
                List<SpsGoodCategory> goodCategoryList = new ArrayList<>();
                String[] idList = ids.split(",");

                for (String id : idList) {
                    map.put("id", id);
                    List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
                    if (categoryList != null && categoryList.size() > 0) {
                        for (SpsGoodCategory category : categoryList) {
                            goodCategoryList.add(category);
                        }
                    }
                }
                String[] pro = new String[]{"categoryId", "categoryName"};
                if (goodCategoryList != null) {
                    ri.setResult(EntityUtiles.reloadListPropertyValue(goodCategoryList, pro));
                    ri.setSuccess(Message.SUCCESS_MSG);
                    ri.setCode(Message.SUCCESS_CODE);
                    ri.setMsg(Message.API_SUCCESS_MSG);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 根据主营业务查询商品类型
     *
     * @return
     */
    @RequestMapping("/getChildrenCategorys")
    @ResponseBody
    public ReturnInfo getChildrenCategorys(String ids) {
        ReturnInfo ri = new ReturnInfo();
        try {
            List<SpsGoodCategory> childrenList = goodCategoryService.findLastCategory(ids);
            String[] pro = new String[]{"id", "title"};
            if (childrenList != null) {
                ri.setResult(EntityUtiles.reloadListPropertyValue(childrenList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


}
