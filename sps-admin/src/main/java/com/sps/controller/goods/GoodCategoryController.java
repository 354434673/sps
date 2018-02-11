package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.entity.goods.SpsGoods;
import org.sps.service.goods.GoodCategoryService;
import org.sps.service.goods.GoodsService;

import java.util.*;

@Controller
@RequestMapping("/category")
public class GoodCategoryController {
    @Reference(check = false, group = "dianfu")
    GoodCategoryService goodCategoryService;
    @Reference(check = false, group = "dianfu")
    GoodsService goodsService;


    /**
     * 进入商品分类列表
     *
     * @param model 模型
     */
    @RequestMapping
    public String index(Model model) {
        try {
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "goodsCategory/index";
    }

    @RequestMapping("/getCategory")
    @ResponseBody
    public String getCategory() {
        Map<String, Object> map = new HashMap<>();
        map.put("isFirst", "0");
        //先查父类
        List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
        //组装数据
        List<SpsGoodCategory> listJson = goodCategoryService.getJson(categoryList);
        String jsonString = JSON.toJSONString(listJson);
        return jsonString;
    }

    /**
     * 添加分类时 弹出框的分类树 只显示2级
     *
     * @return
     */
    @RequestMapping("/getTwoCategory")
    @ResponseBody
    public String getTwoCategory() {
      /*  try {*/
        Map<String, Object> map = new HashMap<>();
        map.put("isFirst", "0");
        //先查父类
        List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
        //组装数据
        SpsGoodCategory spsCategory = new SpsGoodCategory();
        spsCategory.setName("无");
        List<SpsGoodCategory> listJson = goodCategoryService.getTwoCategoryJson(categoryList);
        listJson.add(spsCategory);
        String jsonString = JSON.toJSONString(listJson);
        return jsonString;
    }


    /**
     * 根据id和Pid拼接分类名称 例如： 数码》手机》华为
     * 这块逻辑有点乱 以后优化优化 写的比较急
     *
     * @return
     */
    @RequestMapping(value = "/getCategoryName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(Integer pId, Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String name = "";
            String ids = "";
            SpsGoodCategory smallCategory = goodCategoryService.findEntityById(id);
            SpsGoodCategory category = goodCategoryService.findEntityById(pId);
            if (pId != null && pId != 0) {
                SpsGoodCategory pCategory = goodCategoryService.findEntityById(category.getCategoryParentId());
                if (pCategory != null) {//选了三级
                    name = pCategory.getCategoryName() + ">" + category.getCategoryName() + ">" + smallCategory.getCategoryName();
                    ids = pCategory.getCategoryId() + "," + category.getCategoryId() + "," + smallCategory.getCategoryId();
                    resultMap.put("name", name);
                    resultMap.put("ids", ids);
                } else {//选了二级
                    name = category.getCategoryName() + ">" + smallCategory.getCategoryName();
                    ids = category.getCategoryId() + "," + smallCategory.getCategoryId();
                    resultMap.put("name", name);
                    resultMap.put("ids", ids);
                }
            } else if (pId == null) {//说明只选了一级父类
                name = smallCategory.getCategoryName();
                ids = smallCategory.getCategoryId() + "";
                resultMap.put("name", name);
                resultMap.put("ids", ids);
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

    @RequestMapping("/toAddOrEdit")
    public String toUpdateProduct(Integer id, Model model) {
        try {
            if (id != null) {
                SpsGoodCategory spsGoodCategory = goodCategoryService.findEntityById(id);
                //判断是否为3级分类 用于是否可以上传图片
                if(spsGoodCategory.getCategoryParentId().equals(0)){
                    model.addAttribute("parentFlag", 0);
                }else {
                    SpsGoodCategory category = goodCategoryService.findEntityById(spsGoodCategory.getCategoryParentId());
                    if(category.getCategoryParentId().equals(0)){
                        model.addAttribute("parentFlag", 0);
                    }
                }
                model.addAttribute("spsGoodCategory", spsGoodCategory);
                if (spsGoodCategory != null && spsGoodCategory.getCategoryParentId() != null) {

                    model.addAttribute("categoryParentName", goodCategoryService.findEntityById(spsGoodCategory.getCategoryParentId()).getCategoryName());
                }
            }
            model.addAttribute("flag", 1);
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "goodsCategory/addCategory";
    }

    /**
     * 校验是否有审核中的商品在使用该分类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/checkCategory")
    @ResponseBody
    public Map<String, Object> checkCategory(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (id != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("flowStatus", 1);
                List<SpsGoods> goodsList = goodsService.findAuditList(map);
                if (goodsList != null && goodsList.size() > 0) {
                    for (SpsGoods goods : goodsList) {
                        String[] ids = goods.getgCategoryIds().split(",");
                        //判断数组是否包含id
                        if (useLoop(ids, id.toString())) {
                            resultMap.put("flag", 2);
                            return resultMap;
                        }
                    }
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
     * 判断数组中是否包含某一元素
     *
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    /**
     * 添加或者修改
     *
     * @return
     */

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SpsGoodCategory category, Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodCategoryService.saveOrUpdate(category);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }

    /**
     * 根据分类ID查找详情
     *
     * @param id 分类ID
     * @return
     */


    @RequestMapping(value = "/findEntity")
    public String findEntity(Integer id, Model model) {
        if (id != null) {
            SpsGoodCategory spsGoodCategory = goodCategoryService.findEntityById(id);
            model.addAttribute("spsGoodCategory", spsGoodCategory);
            if (spsGoodCategory != null && spsGoodCategory.getCategoryParentId() != null && spsGoodCategory.getCategoryParentId() != 0) {
                model.addAttribute("categoryParentName", goodCategoryService.findEntityById(spsGoodCategory.getCategoryParentId()).getCategoryName());
            }
        }
        return "goodsCategory/detail";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        if (id != null) {
            SpsGoodCategory spsGoodCategory = goodCategoryService.findEntityById(id);
            resultMap.put("pId", spsGoodCategory.getCategoryParentId());
            resultMap.put("flag", 1);
        }
        return resultMap;
    }


    /**
     * 查询一级
     *
     * @return
     */
    @RequestMapping("/getFistCategory")
    @ResponseBody
    public Map<String, Object> getFistCategory(String ids) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        if (ids == null) {
            map.put("isFirst", "0");
            //先查父类
            List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
            resultMap.put("categoryList", categoryList);
        } else {
            List list = new ArrayList<>();
            String[] idList = ids.split(",");
            for (String id : idList) {
                map.put("id", id);
                //先查父类
                List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
                list.add(categoryList);
            }
            resultMap.put("categoryList", list);
        }
        resultMap.put("code", 0);
        return resultMap;
    }

    /**
     * 查询二级三级
     *
     * @return
     */
    @RequestMapping("/getChildrenCategory")
    @ResponseBody
    public String getChildrenCategory(String ids) {
        Map<String, Object> resultMap = new HashMap<>();
        List<SpsGoodCategory> childrenList = goodCategoryService.findLastCategory(ids);
        String jsonString = JSON.toJSONString(childrenList);
        resultMap.put("childrenList", childrenList);
        resultMap.put("code", 0);
        return jsonString;
    }

    /**
     * 查询二级三级
     *
     * @return
     */
    @RequestMapping("/getChildrenCategorys")
    @ResponseBody
    @JSONField(serialize = false)
    public String getChildrenCategorys(String ids) {
        List<SpsGoodCategory> childrenList = goodCategoryService.findLastCategory(ids);
        String jsonString = JSON.toJSONString(childrenList, SerializerFeature.DisableCircularReferenceDetect);
        return jsonString;
    }

    /**
     * 查询一级
     *
     * @return
     */
    @RequestMapping("/getNextCategory")
    @ResponseBody
    public Map<String, Object> getNextCategory(Integer parentId) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", parentId);
        List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
        resultMap.put("categoryList", categoryList);
        resultMap.put("code", 0);
        return resultMap;
    }

}
