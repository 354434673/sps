package com.sps.controller.goods;
import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ResultCodeEnum;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.service.goods.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    private BrandService brandService;
    @Resource
    private GoodCategoryService goodCategoryService;
    @Resource
    private GoodsService goodService;
    @Resource
    private ApiGoodShopService goodShopService;
    @Resource
    private GoodShopSkuService goodShopSkuService;

    /**
     * 根据ID商品详情
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map, "id");
        if("0".equals(ri.getCode())) return ri;
        try {
            Integer id = (Integer) map.get("id");
            SpsGoodShop goods = goodShopService.findById(id);
            if(goods != null){
                ri.setData(goods);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(Message.API_SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

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
     * 根据ID查询Sku
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/findSkuById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map, "goodsId");
        if("0".equals(ri.getCode())) return ri;
        try {
            List<SpsGoodShopSku> skuList = goodShopSkuService.findList(map);
            if(skuList != null){
                ri.setData(skuList);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(Message.API_SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


}
