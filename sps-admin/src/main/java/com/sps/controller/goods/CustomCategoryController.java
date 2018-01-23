package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsCustomCategory;
import org.sps.service.goods.CustomCategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/customCategory")
public class CustomCategoryController {
    @Reference(check=false)
    private CustomCategoryService customCategoryService;

    /**
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/customCategoryList")
    @ResponseBody
    public HashMap<String, Object> customCategoryList(Integer page, Integer limit, String name) {
        HashMap<String, Object> customCategoryList = customCategoryService.findCustomCategoryList(page, limit, name);
        return customCategoryList;
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
                SpsCustomCategory customCategory = customCategoryService.findEntityById(id);
                model.addAttribute("customCategory", customCategory);
            }
            model.addAttribute("flag", 1);
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "";
    }

    /**
     * 添加或者修改
     *
     * @return
     */

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SpsCustomCategory customCategory, Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            customCategoryService.saveOrUpdate(customCategory);
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
    public Map<String, Object> findEntity(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (id != null) {
                SpsCustomCategory customCategory = customCategoryService.findEntityById(id);
                resultMap.put("customCategory", customCategory);
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
    @RequestMapping(value = "/delCustomCategory")
    @ResponseBody
    public Map<String, Object> dellab(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            customCategoryService.falseDeletion(id);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }


    /**
     * 查询品牌列表
     *
     * @return
     */
    @RequestMapping(value = "/findCustomCategoryList")
    @ResponseBody
    public Map<String, Object> findBrandList() {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Map<String, Object> map = new HashMap<>();
            List<SpsCustomCategory> customCategoryList = customCategoryService.findList(map);
            resultMap.put("data", customCategoryList);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
}
