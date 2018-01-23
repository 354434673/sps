package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.goods.SpsGoodSku;
import org.sps.entity.goods.SpsGoods;
import org.sps.service.goods.GoodSkuService;
import org.sps.service.goods.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/goodSku")
public class GoodSkuController {
    @Reference
    private GoodSkuService goodskuService;

    /**
     * @param page
     * @param limit
     * @param goodsName
     * @param spuNo
     * @return
     */
    @RequestMapping("/goodSkuList")
    @ResponseBody
    public HashMap<String, Object> userList(Integer page, Integer limit,String goodsName, String spuNo, String size) {
        HashMap<String, Object> goodSkuList = goodskuService.findGoodSkuList(page, limit, goodsName, spuNo,size);
        return goodSkuList;
    }

    /**
     * 修改价格和库存
     * @return
     */
    @RequestMapping(value="/updatePrice",method=RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> updatePrice(@RequestBody List<SpsGoodSku> goodShopSku){
        HashMap<String, Object> updatePriceOrStock = goodskuService.updatePrice(goodShopSku);
        return  updatePriceOrStock;
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
                SpsGoodSku goodSku = goodskuService.findEntityById(id);
                model.addAttribute("goodSku", goodSku);
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
    public Map<String, Object> saveOrUpdate( SpsGoodSku goodSku , Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodskuService.saveOrUpdate(goodSku);
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
                SpsGoodSku goodSku = goodskuService.findEntityById(id);
                resultMap.put("goodSku", goodSku);
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
    @RequestMapping(value = "/delGood")
    @ResponseBody
    public Map<String, Object> dellab(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            goodskuService.falseDeletion(id);
            resultMap.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
}
