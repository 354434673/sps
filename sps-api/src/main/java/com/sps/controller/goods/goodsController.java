package com.sps.controller.goods;
import com.sps.common.*;
import com.sps.entity.goods.SpsCustomCategory;
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
    private ApiGoodShopService goodShopService;
    @Resource
    private GoodShopSkuService goodShopSkuService;
    @Resource
    private CustomCategoryService customCategoryService;



    /**
     * 根据ID商品详情
     * @return
     */
    @RequestMapping(value = "/findCustomerCategory", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findCustomerCategory(Integer enterpriseId){
        ReturnInfo ri = new ReturnInfo();
        try {
            List<SpsCustomCategory> categoryList = customCategoryService.findByEnterpriseId(enterpriseId);
            String[] pro = new String[]{"customId","customName","customWide"};
            if(categoryList != null){
                ri.setResult(EntityUtiles.reloadListPropertyValue(categoryList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
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

    /**
     * 根据ID商品详情
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(Integer id){
        ReturnInfo ri = new ReturnInfo();
        try {
            HashMap<String, Object> data = new HashMap<String, Object>();//封装对象
            SpsGoodShop goods = goodShopService.findById(id);
            data.put("gId", goods.getgId());
            data.put("gSpuName", goods.getgSpuName());
            data.put("gMinPrice", goods.getgMinPrice());
            data.put("albumList", goods.getAlbumList());
            data.put("albumDetailList", goods.getAlbumDetailList());
            if(goods != null){
                ri.setResult(data);
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
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
    /**
     * 根据ID查询Sku
     * @return
     */
    @RequestMapping(value = "/findSkuById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(Integer goodsId){
        Map<String, Object> map = new HashMap<>();
        ReturnInfo ri = new ReturnInfo();
        try {
            map.put("goodsId", goodsId);
            List<SpsGoodShopSku> skuList = goodShopSkuService.findList(map);
            String[] pro = new String[]{"gId","gGid","gColorSize","gColor","gSize","gPrice","gQuantity","gStock"};
            if(skuList != null){
                ri.setResult(EntityUtils.reloadListPropertyValue(skuList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
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
