package com.sps.controller;

import com.alibaba.fastjson.JSON;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.service.goods.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/category")
public class GoodCategoryController {

    @Resource
    private GoodCategoryService goodCategoryService;
    /**
     * 进入商品分类列表
     * @param model  模型
     * @return
     */
    @RequestMapping
    public String index(Model model) {
        try {
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "";
    }
    @RequestMapping("/getCategory")
    @ResponseBody
    public String getMenuList(){
        String jsonString="";
        try {
            Map<String,Object> map = new HashMap<>();
            List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
            HashMap<String, List<SpsGoodCategory>> hashMap = new HashMap<>();
            SpsGoodCategory spsCategory= null;
            for (int i = 0; i < categoryList.size(); i++) {
                //只遍历ParentId为1的，如果ParentId为1，说明为父节点
                if(categoryList.get(i).getCategoryParentId() == 0){
                    spsCategory=new SpsGoodCategory();
                    spsCategory.setCategoryId(categoryList.get(i).getCategoryId());
                    spsCategory.setCategoryName(categoryList.get(i).getCategoryName());
                    //查找子类
                    List<SpsGoodCategory> getChildren = getChildren(categoryList.get(i).getCategoryId());
                    if(getChildren.size()!= 0){
                        spsCategory.setChildren(getChildren);
                    }
                    categoryList.remove(categoryList.get(0));
                }
                categoryList.add(spsCategory);
                categoryList.remove(categoryList.get(0));
            }
            //用增强for循环会报错
            /*for (SpsGoodCategory category : categoryList) {
                //只遍历ParentId为1的，如果ParentId为1，说明为父节点
                if(category.getCategoryParentId() == 0){
                    spsCategory=new SpsGoodCategory();
                    spsCategory.setCategoryId(category.getCategoryId());
                    spsCategory.setCategoryName(category.getCategoryName());
                    //查找子类
                    List<SpsGoodCategory> getChildren = getChildren(category.getCategoryId());
                    if(getChildren.size()!= 0){
                        spsCategory.setChildrenCategory(getChildren);
                    }
                }
                categoryList.add(spsCategory);
                categoryList.remove(categoryList.size() - 1);
            }*/
            hashMap.put("nodes", categoryList);
            jsonString = JSON.toJSONString(hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }


    /**
     * 拼接数据
     * @param list
     * @return
     */
    private HashMap<String, List<SpsGoodCategory>>  getData(List<SpsGoodCategory> list) {
        HashMap<String, List<SpsGoodCategory>> hashMap = new HashMap<>();
        SpsGoodCategory spsCategory= null;
        for (SpsGoodCategory category : list) {
            //只遍历ParentId为1的，如果ParentId为1，说明为父节点
            if(category.getCategoryParentId() == 0){
                spsCategory=new SpsGoodCategory();
                spsCategory.setCategoryId(category.getCategoryId());
                spsCategory.setCategoryName(category.getCategoryName());
                //查找子类
                List<SpsGoodCategory> getChildren = getChildren(category.getCategoryId());
                if(getChildren.size()!= 0){
                    spsCategory.setChildren(getChildren);
                }
            }
            list.add(spsCategory);
        }
        hashMap.put("nodes", list);
        return hashMap;
    }

    /**
     * 获取子类
     * @param categoryId
     * @return
     */
    private List<SpsGoodCategory> getChildren(Integer categoryId) {
        Map<String,Object> map=new HashMap<>();
        map.put("categoryId",categoryId);
        List<SpsGoodCategory> selectChildern = goodCategoryService.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory=new SpsGoodCategory();
            spsCategory.setCategoryId(category.getCategoryId());
            spsCategory.setCategoryName(category.getCategoryName());
            childernList.add(spsCategory);
        }
        return childernList;
    }

    /**
     * 进入商品分类新增页面
     * @return
     */
    @RequestMapping("add")
    public String add() {
        return "category/add";
    }
    /**
     * 添加或者修改
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveOrUpdate(SpsGoodCategory category, Model model) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
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
        SpsGoodCategory category = null;
        try {
            category = goodCategoryService.findEntityById(id);

            model.addAttribute("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("flag", 0);
            model.addAttribute("msg", "操作失败");
        }
        model.addAttribute("category", category);
        return "category/detail";
    }

}
