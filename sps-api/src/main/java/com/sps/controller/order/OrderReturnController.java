package com.sps.controller.order;

import com.alibaba.fastjson.JSON;
import com.sps.common.JsonResult;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.controller.BaseApi;
import com.sps.entity.order.SpsOrderReturn;
import com.sps.service.order.OrderReturnService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/orderReturn")
public class OrderReturnController extends BaseApi{

    private static final Log log= LogFactory.getLog(OrderReturnController.class);
    @Resource
    private OrderReturnService orderReturnService;

    /**
     * 退货申请
     * @return
     */
    @RequestMapping(value = "/returnOrder")
    public JsonResult saveOrUpdate(SpsOrderReturn order) {
        log.info("start--退货申请，请求参数{}"+ JSON.toJSONString(order));
        try {
            if(!orderReturnService.saveOrUpdate(order)){
                return returnFaild();
            }
            log.info("end--退货申请");
            return returnSuccess();
        } catch (Exception e) {
            log.info("end--退货申请,异常{}"+e.getMessage());
            return returnFaildSys();
        }
    }
}
