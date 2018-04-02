package com.sps.controller.app;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.app.Help;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.service.app.help.HelpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

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
    private static  final Log logger= LogFactory.getLog(HelpController.class);
    @Autowired
    private HelpService helpService;
    /**
     * 获取所有的标题
     * @return
     */
    @RequestMapping(value = "/findAllTittle", method = RequestMethod.POST)
    @ResponseBody
    public String findAllTittle(){
        JSONObject jsonO = new JSONObject();
        List<Help> helps = helpService.queryAllTittle();
        if(helps.size()>0){
            jsonO.put("helps",helps);
            return Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG, jsonO);

        }
        jsonO.put("helps",null);
        logger.info("newssss" +Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, jsonO));
        return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, jsonO);
    }

    /**
     * 获取根据标题id
     * 获取内容
     * @return
     */
    @RequestMapping(value = "/findContentById", method = RequestMethod.POST)
    @ResponseBody
    public String findContentById( @RequestParam("helpId") Integer helpId){
        JSONObject jsonO = new JSONObject();
            Help help = helpService.queryContent(helpId);
            if(help !=null){
                jsonO.put("help",help);
                return Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG, jsonO);
            }
        jsonO.put("help",help);
        return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, jsonO);
    }


}
