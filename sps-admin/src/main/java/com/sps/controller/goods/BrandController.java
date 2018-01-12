package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsBrand;
import org.sps.service.goods.BrandService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

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
        return "brand/index";
    }

    /**
     * @param page
     * @param limit
     * @param brandName
     * @param brandEnglishName
     * @return
     */
    @RequestMapping("/brandList")
    public @ResponseBody
    HashMap<String, Object> userList(Integer page, Integer limit, String brandName, String brandEnglishName) {
        HashMap<String, Object> brandList = brandService.findBrandList(page, limit, brandName, brandEnglishName);
        return brandList;
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
                SpsBrand spsBrand = brandService.findEntityById(id);
                model.addAttribute("spsBrand", spsBrand);
            }
            model.addAttribute("flag", 1);
        } catch (Exception e) {
            model.addAttribute("tips", "操作失败");
            model.addAttribute("flag", 0);
        }
        return "brand/addBrand";
    }

    /**
     * 添加或者修改
     *
     * @return
     */

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SpsBrand brand, Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            brandService.saveOrUpdate(brand);
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
                SpsBrand spsBrand = brandService.findEntityById(id);
                resultMap.put("spsBrand", spsBrand);
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
    @RequestMapping(value = "/delBrand")
    @ResponseBody
    public Map<String, Object> dellab(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            brandService.falseDeletion(id);
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
    @RequestMapping(value = "/findBrandList")
    @ResponseBody
    public Map<String, Object> findBrandList(Integer categoryId) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("categoryId", categoryId);
            List<SpsBrand> spsBrandList = brandService.findList(map);
            resultMap.put("data", spsBrandList);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
}
