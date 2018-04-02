package com.sps.controller.ShopkeeperPersonal;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.sps.common.*;
import com.sps.controller.BaseApi;
import com.sps.entity.shopkeeper.vo.SpsShopFindPersonInfoVo;
import com.sps.enums.ReturnCode;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/shopkeeperPersonal")
public class ShopkeeperPersonalController extends BaseApi {

    private static Logger log = LoggerFactory.getLogger(ShopkeeperPersonalController.class);

    @Resource
    private ShopkeeperPersonService shopkeeperPersonService;




    /**
     * 根据ID查询个人信息
     *
     * @return
     */
    @RequestMapping(value = "/findPersonInfo")
    public JsonResult findSkuById(String customerNum) {
        log.info("start--根据用户ID查询用户信息,请求参数"+customerNum);
        ReturnInfo ri = new ReturnInfo();
        if(StringUtils.isBlank(customerNum)){
            return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
        }
        try {
            SpsShopFindPersonInfoVo personInfo = shopkeeperPersonService.findEntityByCustomerNum(customerNum);
            if(personInfo == null){
                return returnFaild(ReturnCode.ERROR_SELECT_IS_NULL.getMsg());
            }
            log.info("start--根据用户ID查询用户信息,返回参数"+ JSON.toJSONString(personInfo));
            return returnSuccess(personInfo);
        } catch (Exception e) {
            log.info("end--根据用户ID查询用户信息异常"+e.getMessage());
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
           return returnFaild();
        }
    }



}
