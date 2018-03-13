package com.sps.controller.ShopkeeperPersonal;

import com.sps.common.Common;
import com.sps.common.EntityUtiles;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodShopSkuService;
import com.sps.service.goods.PurchaseOrderService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
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
@RequestMapping(value = "/api/shopkeeperPersonal")
public class ShopkeeperPersonalController {

    @Resource
    private ShopkeeperPersonService shopkeeperPersonService;




    /**
     * 根据ID查询个人信息
     *
     * @return
     */
    @RequestMapping(value = "/findPersonInfo", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findSkuById(String customerNum) {
        ReturnInfo ri = new ReturnInfo();
        if ("0".equals(ri.getCode())) return ri;
        try {
            SpsShopkeeperPersonal personInfo = shopkeeperPersonService.findEntityByCustomerNum(customerNum);
            String[] pro = new String[]{"personalNickname","url","balanceAmount","amountUsable","balance","repayAmount","threeDayRepayment","weekRepayment"};
            if (personInfo != null) {
                ri.setResult(EntityUtiles.reloadEntityPropertyValue(personInfo, pro));
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



}
