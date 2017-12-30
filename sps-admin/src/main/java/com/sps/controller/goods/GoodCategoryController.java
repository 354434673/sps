package com.sps.controller.goods;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.service.goods.GoodCategoryService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class GoodCategoryController {
    @Reference
    GoodCategoryService goodCategoryService;


    /**
     *
     * 进入商品分类列表
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
      /*  try {*/
            Map<String, Object> map = new HashMap<>();
            map.put("isFirst", "0");
            //先查父类
            List<SpsGoodCategory> categoryList = goodCategoryService.findList(map);
            //组装数据
            List<SpsGoodCategory> listJson = goodCategoryService.getJson(categoryList);
            String  jsonString = JSON.toJSONString(listJson);
      /*  } catch (Exception e) {
            e.printStackTrace();
        }*/
        return jsonString;
    }

    /**
     * 添加分类时 弹出框的分类树 只显示2级
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
        SpsGoodCategory spsCategory=new SpsGoodCategory();
        spsCategory.setName("无");
        List<SpsGoodCategory> listJson = goodCategoryService.getTwoCategoryJson(categoryList);
        listJson.add(spsCategory);
        String  jsonString = JSON.toJSONString(listJson);
        return jsonString;
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
                if(spsGoodCategory!=null&&spsGoodCategory.getCategoryParentId()!=null){
                    model.addAttribute("categoryParentName",  goodCategoryService.findEntityById(spsGoodCategory.getCategoryParentId()).getCategoryName());
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
     *
     * 根据分类ID查找详情
     * @param id 分类ID
     * @return
     */


    @RequestMapping(value = "/findEntity")
    public String findEntity(Integer id, Model model) {
        SpsGoodCategory category = null;
        //categoryParentName
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
