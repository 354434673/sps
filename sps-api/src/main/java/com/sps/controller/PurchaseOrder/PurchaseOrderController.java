package com.sps.controller.PurchaseOrder;

import com.sps.common.*;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodShopSkuService;
import com.sps.service.goods.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/purchaseOrder")
public class PurchaseOrderController {
    @Resource
    private PurchaseOrderService purchaseOrderService;
    @Resource
    private ApiGoodShopService goodShopService;
    @Resource
    private GoodShopSkuService goodShopSkuService;


    /**
     * 进货单添加
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(SpsPurchaseOrder order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            purchaseOrderService.saveOrUpdate(order);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
            ri.setSuccess(Message.API_SUCCESS_FLAG);
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
     * @return
     */
    @RequestMapping(value = "/findListByCustomerNum", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(String customerNum,Integer id) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("customerNum", customerNum);
            map.put("enterpriseId", id);
            List<SpsPurchaseOrder> purchaseOrderList = purchaseOrderService.findList(map);
            String[] pro = new String[]{"orderId","orderEnterpriseId","orderSkuId","goodsName","price","quantity","size","url","stock","orderGoodsNum","color"};
            if (purchaseOrderList != null) {
                ri.setResult(EntityUtiles.reloadListPropertyValue(purchaseOrderList, pro));
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
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
    @RequestMapping(value = "/deleteSku", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo deleteSku(String  ids) {
        ReturnInfo ri = new ReturnInfo();
        if ("0".equals(ri.getCode())) return ri;
        try {
            purchaseOrderService.falseDeletion(ids);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
            ri.setSuccess(Message.API_SUCCESS_FLAG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

}
