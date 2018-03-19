package com.sps.controller.system;

import com.sps.common.Message;
import com.sps.common.Result;
import com.sps.common.ReturnInfo;
import com.sps.entity.helpAndFeedback.Help;
import com.sps.service.help.help.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

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
@RequestMapping(value = "/help")
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
     * 获取所有的标题
     * @return
     */
    @RequestMapping(value = "/findContentById", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> findContentById(@RequestBody String data){

        HashMap<String, Object> hashMap = helpService.queryContent(data);
        return  hashMap;
    }

    /**
     *保存标题的方法
     */
    @RequestMapping(value = "/saveHelp", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> saveHelp(String tittle, String content){
        Result<Boolean> result = new Result<>();
        Boolean flag = helpService.saveHelp(tittle, content);
        if(flag){
            result.setBody(true);
            result.setMsg("保存成功");
            return result;
        }else{
            result.setBody(false);
            result.setMsg("保存失败");
            return  result;
        }

    }
}
