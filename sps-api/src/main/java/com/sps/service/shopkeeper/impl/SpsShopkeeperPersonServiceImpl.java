package com.sps.service.shopkeeper.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.shopkeeper.SpsShopkeeperCarPrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperHousePrppertyDao;
import com.sps.dao.shopkeeper.SpsShopkeeperPersonalDao;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.base.BaseOperate;


@RestController
public class SpsShopkeeperPersonServiceImpl  extends BaseOperate {
    @Autowired
    private SpsShopkeeperPersonalDao personDao;
    @Autowired
    private SpsShopkeeperCarPrppertyDao carDao;
    @Autowired
    private SpsShopkeeperHousePrppertyDao houseDao;
    /** 获取昵称和图像的个人信息方法
     * liucailing
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/person/query/{id}", method = RequestMethod.POST)
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @ResponseBody
    public String queryPersonInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") int id) throws Exception {
       //入参检查
        if (StringUtil.isEmpty(String.valueOf(id)))
            return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);
        SpsShopkeeperPersonal person = personDao.getByPersonId(id);
        JSONObject jsonO = new JSONObject();
        if (StringUtil.isEmpty(person.getPersonalNickname())) {
            String phone = person.getPersonalPhone();
            String src = person.getPic().getPicSrc();
            jsonO.put("name", phone);
            jsonO.put("src", src);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        } else {
            String name = person.getPersonalNickname();
            String src = person.getPic().getPicSrc();
            jsonO.put("name", name);
            jsonO.put("src", src);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
    }

    /**保存图像的方法
     *
     * @param request
     * @param response
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/person/saveSrc/{id}/{src}", method = RequestMethod.POST)
    @ResponseBody
    public String saveSrc(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") int id,@RequestParam("src") String src) throws Exception {
        //入参检查
       if (StringUtil.isEmpty(String.valueOf(id))|| StringUtil.isEmpty(src))
           return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);
        try{
            SpsShopkeeperPersonal person = personDao.getByPersonId(new Integer(id));
            personDao.saveSrc(person.getPic().getPicId(),src);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
    /**保存昵称的方法
     *
     * @param request
     * @param response
     * @param id
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/api/person/updateNicknamerc/{id}/{nickName}", method = RequestMethod.POST)
    @ResponseBody
    public String updateNicknamerc(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") int id,@RequestParam("nickName") String nickName) throws Exception {
        //入参检查
        if (StringUtil.isEmpty(String.valueOf(id))|| StringUtil.isEmpty(nickName))
            return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);
        try{

            personDao.updateNickName(new Integer(id),nickName);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }

    /**
     * 刘彩玲
     * 保存车辆基本信息
     * @param request
     * @param response
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/person/saveCarInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveCarInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //入参检查
        String jsonIn = getReqContent(request);
        if (StringUtil.isEmpty(jsonIn))
            return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);
        JSONObject jsonObject = JSON.parseObject(jsonIn);
        //获取请求参数中的值
        String id = jsonObject.getString("id");
        String carChassisNum = jsonObject.getString("carChassisNum");
        String carPlateNum = jsonObject.getString("carPlateNum");
        String carBrand = jsonObject.getString("carBrand");
        String carUsername = jsonObject.getString("carUsername");
        SpsShopkeeperCarProperty carInfo = new SpsShopkeeperCarProperty();
        //上传行车证件的标志 ----"1"为已经上传，”0“ 为没有上传
        String flag= jsonObject.getString("flag");
        try {
            if (StringUtil.isEmpty(carChassisNum) && StringUtil.isEmpty(carPlateNum) && StringUtil.isEmpty(carBrand) && "1".equals(flag)) {
                //1表示有车
                carInfo.setCarIsHave(1);
                carInfo.setCarBrand(carBrand);
                carInfo.setCarPlateNum(carPlateNum);
                carInfo.setCarChassisNum(carChassisNum);
                carInfo.setCarUsername(carUsername);
                carInfo.setShopkeeperCustomerid(id);
                carInfo.setCarCreatTime(new Date());
                carDao.saveCarInfo(carInfo);
            } else {
                //0表示没车
                carInfo.setCarIsHave(0);
                carInfo.setCarBrand(carBrand);
                carInfo.setCarPlateNum(carPlateNum);
                carInfo.setCarChassisNum(carChassisNum);
                carInfo.setCarUsername(carUsername);
                carInfo.setShopkeeperCustomerid(id);
                carInfo.setCarCreatTime(new Date());
                carDao.saveCarInfo(carInfo);
            }
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
    /**
     * 保存房子基本信息的方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/person/saveHouseInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveHouseInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //入参检查
        String jsonIn = getReqContent(request);
        if (StringUtil.isEmpty(jsonIn))
            return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);
        JSONObject jsonObject = JSON.parseObject(jsonIn);
        //获取请求参数中的值
        String id = jsonObject.getString("id");
        String houseArea = jsonObject.getString("houseArea");
        String houseAddr = jsonObject.getString("houseAddr");
        String houseUsername = jsonObject.getString("houseUsername");
        SpsShopkeeperHouseProperty houseInfo = new SpsShopkeeperHouseProperty();
        //上传行车证件的标志 ----"1"为已经上传，”0“ 为没有上传
        String flag= jsonObject.getString("flag");
        try {
            if (StringUtil.isEmpty(houseArea) && StringUtil.isEmpty(houseAddr)  && "1".equals(flag)) {
                //1表示有房
                houseInfo.setHouseIsHave(1);
                houseInfo.setHouseArea(new Double(houseArea));
                houseInfo.setHouseAddr(houseAddr);
                houseInfo.setHouseUsername(houseUsername);
                houseInfo.setShopkeeperCustomerid(id);
                houseInfo.setHouseCreatTime(new Date());
                houseDao.saveHouseInfo(houseInfo);
            } else {
                //0表示没房
                houseInfo.setHouseIsHave(0);
                houseInfo.setHouseArea(new Double(houseArea));
                houseInfo.setHouseAddr(houseAddr);
                houseInfo.setHouseUsername(houseUsername);
                houseInfo.setShopkeeperCustomerid(id);
                houseInfo.setHouseCreatTime(new Date());
                houseDao.saveHouseInfo(houseInfo);
            }
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }

}