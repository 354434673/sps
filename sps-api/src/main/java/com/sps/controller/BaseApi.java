package com.sps.controller;


import com.sps.common.DateEditor;
import com.sps.common.JsonResult;
import com.sps.common.StringUtil;
import com.sps.enums.ReturnCode;
import com.sps.service.ApiServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 基础封装
 */
public class BaseApi {

    private static final Logger log = LoggerFactory.getLogger(BaseApi.class);


    /**
     * 处理时间的转换器，默认格式是yyyy-MM-dd HH:mm:ss可以被重载
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @ExceptionHandler
    @ResponseBody
    public final JsonResult handleException(HttpServletRequest request, Exception ex) {
        if (ex instanceof ApiServiceException) {
            ApiServiceException be = (ApiServiceException) ex;
            ex.printStackTrace();
            if(StringUtil.checkNotEmpty(be.getKey()) && StringUtil.checkNotEmpty(be.getMsg())){
                return returnFaild(be.getKey(),be.getMsg());
            }
            if(StringUtil.checkNotEmpty(ex.getMessage())){
                return returnFaild(ex.getMessage());
            }
            return returnFaild(be.getCode());
        }
        ex.printStackTrace();
        return returnFaild();
    }


    public static JsonResult returnSuccess() {
        return JsonResult.createCode(ReturnCode.ACTIVE_SUCCESS);
    }

    public static JsonResult returnSuccess(Object obj, ReturnCode code) {
        return JsonResult.createCode(code, obj);
    }

    public static JsonResult returnSuccess(Object obj, String msg) {
        return returnSuccess(obj);
    }


    public static JsonResult returnSuccess(Object obj) {
        return JsonResult.createSuccessApi(obj);
    }

    public JsonResult returnFaild(ReturnCode code) {
        return JsonResult.createCode(code);
    }

    public JsonResult returnFaild(String key,String message){

        return JsonResult.createCode(key,message);
    }

    public JsonResult returnFaild() {
        return JsonResult.createFaildApi();
    }

    public JsonResult returnFaild(String msg) {
        return JsonResult.createFaildApi(msg);
    }
    public JsonResult returnFaildSys() {
        return JsonResult.createFaildApi();
    }
}
