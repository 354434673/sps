package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.service.goods.GoodCategoryService;

import java.util.*;

@Controller
@RequestMapping("/category")
public class GoodCategoryController {
    @Reference
    GoodCategoryService goodCategoryService;


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
     *  这块逻辑有点乱 以后优化优化 写的比较急
     * @return
     */
    @RequestMapping(value = "/getCategoryName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(Integer pId, Integer id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            String name = "";
            String ids = "";
            SpsGoodCategory smallCategory = goodCategoryService.findEntityById(id);
            SpsGoodCategory category = goodCategoryService.findEntityById(pId);
            if (pId != null && pId != 0) {
                    SpsGoodCategory Pcategory = goodCategoryService.findEntityById(category.getCategoryParentId());
                    if(Pcategory!=null){//选了三级
                        name = Pcategory.getCategoryName() + ">" + category.getCategoryName() + ">" + smallCategory.getCategoryName();
                        ids = Pcategory.getCategoryId() + "," + category.getCategoryId() + "," + smallCategory.getCategoryId();
                        resultMap.put("name", name);
                        resultMap.put("ids", ids);
                    }else {//选了二级
                        name = category.getCategoryName() + ">" + smallCategory.getCategoryName();
                        ids = category.getCategoryId() + "," + smallCategory.getCategoryId();
                        resultMap.put("name", name);
                        resultMap.put("ids", ids);
                    }
            } else if(pId==null) {//说明只选了一级父类
                name =  smallCategory.getCategoryName();
                ids =  smallCategory.getCategoryId()+"";
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


    /**
     * 查询一级
     * @return
     */
    @RequestMapping("/getFistCategory")
    @ResponseBody
    public  Map<String, Object>  getFistCategory() {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("isFirst", "0");
        //先查父类
        List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
        resultMap.put("categoryList", categoryList);
        resultMap.put("code", 0);
        return resultMap;
    }
    /**
     * 查询二级三级
     * @return
     */
    @RequestMapping("/getChildrenCategory")
    @ResponseBody
    public String getChildrenCategory( String ids) {
        Map<String, Object> resultMap = new HashMap<>();
        List<SpsGoodCategory> childrenList = goodCategoryService.findLastCategory(ids);
        String jsonString = JSON.toJSONString(childrenList);
        resultMap.put("childrenList", childrenList);
        resultMap.put("code", 0);
        return jsonString;
    }
    /**
     * 查询二级三级
     * @return
     */
    @RequestMapping("/getChildrenCategorys")
    @ResponseBody
    public  Map<String, Object>  getChildrenCategorys( String ids) {
        Map<String, Object> resultMap = new HashMap<>();
        List<SpsGoodCategory> childrenList = goodCategoryService.findLastCategory(ids);
        String jsonString = JSON.toJSONString(childrenList);
        resultMap.put("childrenList", childrenList);


       /* List spsGoodCategoryList = new ArrayList<>();
        if (ids != null && !"".equals(ids)) {
            String[] id = ids.split(",");
            for (String ides : id) {
                List<SpsGoodCategory> list = new ArrayList<>();
                Map<String,Object> map=new HashMap<>();
                map.put("categoryId",ides);
                List<SpsGoodCategory> selectChildern = this.findList(map);
                SpsGoodCategory spsCategory;
                List<SpsGoodCategory> childernList = new ArrayList<>();
                for (SpsGoodCategory category : selectChildern) {
                    spsCategory=new SpsGoodCategory();
                    spsCategory.setId(category.getCategoryId());
                    spsCategory.setTitle(category.getCategoryName());
                    childernList.add(spsCategory);
                    List<SpsGoodCategory> getGrandson = getGrand(category.getCategoryId());
                    if(getGrandson.size()!= 0){
                        spsCategory.setChildren(getGrandson);
                    }
                    list.add(spsCategory);
                }
                spsGoodCategoryList.add(childernList) ;
            }
        }
        return spsGoodCategoryList;*/


        return resultMap;
    }

    /**
     * 查询一级
     * @return
     */
    @RequestMapping("/getNextCategory")
    @ResponseBody
    public  Map<String, Object>  getNextCategory(Integer parentId) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", parentId);
        List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
        resultMap.put("categoryList", categoryList);
        resultMap.put("code", 0);
        return resultMap;
    }

}
