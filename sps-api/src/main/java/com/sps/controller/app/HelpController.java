package com.sps.controller.app;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.app.Help;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.service.app.help.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-06.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping(value = "/api/help")
public class HelpController {
    @Autowired
    private HelpService helpService;
    /**
     * 获取所有的标题
     * @return
     */
    @RequestMapping(value = "/findAllTittle", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findAllTittle(){
        ReturnInfo returnInfo = new ReturnInfo();
        try {
            List<Help> helps = helpService.queryAllTittle();
            if(helps.size()>0){
                returnInfo.setResult(helps);
                returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
                returnInfo.setCode(Message.API_SUCCESS_CODE);
                returnInfo.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
    }

    /**
     * 获取根据标题id
     * 获取内容
     * @return
     */
    @RequestMapping(value = "/findContentById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findContentById( @RequestParam("helpId") Integer helpId){
        ReturnInfo returnInfo = new ReturnInfo();
        try{
            Help help = helpService.queryContent(helpId);
            returnInfo.setResult(help);
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return  returnInfo;
    }


}
