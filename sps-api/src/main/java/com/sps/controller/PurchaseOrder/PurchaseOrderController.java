package com.sps.controller.PurchaseOrder;

import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodShopSkuService;
import com.sps.service.goods.GoodsService;
import com.sps.service.goods.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
     *
     * @param order 地址对象
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(@RequestBody SpsPurchaseOrder order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            purchaseOrderService.saveOrUpdate(order);
            ri.setSuccess(Message.API_SUCCESS_FLAG);
            ri.setCode(Message.API_SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
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
     * @param map id
     * @return
     */
    @RequestMapping(value = "/findListByCustomerNum", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(@RequestBody Map<String, Object> map) {
        ReturnInfo ri = Common.validate(map, "customerNum");
        if ("0".equals(ri.getCode())) return ri;
        try {
            List<SpsPurchaseOrder> purchaseOrderList = purchaseOrderService.findList(map);
            if (purchaseOrderList != null) {
                ri.setData(purchaseOrderList);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(Message.API_SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
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
     * @param map id
     * @return
     */
    @RequestMapping(value = "/deleteSku", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo deleteSku(@RequestBody Map<String, Object> map) {
        ReturnInfo ri = Common.validate(map, "id");
        if ("0".equals(ri.getCode())) return ri;
        try {
            Integer id = (Integer) map.get("id");
            purchaseOrderService.falseDeletion(id);
            ri.setSuccess(Message.API_SUCCESS_FLAG);
            ri.setCode(Message.API_SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

}
