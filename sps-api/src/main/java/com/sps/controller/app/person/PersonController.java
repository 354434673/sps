package com.sps.controller.app.person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2018-03-23.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private ShopkeeperPersonService shopkeeperPersonService;


    /**
     * 获取昵称和头像的方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryPersonInfo", method = RequestMethod.POST)
    @ResponseBody
    public String queryPersonInfo(@RequestParam("id") Integer id) {

        SpsShopkeeperPersonal person = shopkeeperPersonService.getByPersonId(id);
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

    /**
     * 修改头像的方法
     * @param id
     * @param src
     * @return
     */
    @RequestMapping(value = "/saveSrc", method = RequestMethod.POST)
    @ResponseBody
    public String saveSrc(@RequestParam("id") Integer id, @RequestParam("src") String src) {
        //入参检查
            Boolean flag = shopkeeperPersonService.saveSrc(id, src);
            if (flag) {
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
    }

    /**
     * 修改昵称的方法
     * @param id
     * @param nickName
     * @return
     */
    @RequestMapping(value = "updateNicknamerc", method = RequestMethod.POST)
    @ResponseBody
    public String updateNicknamerc(@RequestParam("id") Integer id, @RequestParam("nickName") String nickName)  {
        //入参检查
         Boolean flag = shopkeeperPersonService.updateNickName(id, nickName);
        if(flag){
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    /**
     * 刘彩玲
     * 保存车辆基本信息
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/person/saveCarInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveCarInfo( @RequestParam("flag") String flag,@RequestParam("carChassisNum") String carChassisNum,@RequestParam("carPlateNum") String carPlateNum,@RequestParam("carBrand") String carBrand,@RequestParam("carUsername") String carUsername,@RequestParam("shopkeeperCustomerid") String shopkeeperCustomerid)  {
        SpsShopkeeperCarProperty carInfo = new SpsShopkeeperCarProperty();
        //上传行车证件的标志 ----"1"为已经上传，”0“ 为没有上传
        Boolean falg;
        try {
            if ( "1".equals(flag)) {
                //1表示有车
                carInfo.setCarIsHave(1);
                carInfo.setCarBrand(carBrand);
                carInfo.setCarPlateNum(carPlateNum);
                carInfo.setCarChassisNum(carChassisNum);
                carInfo.setCarUsername(carUsername);
                carInfo.setShopkeeperCustomerid(shopkeeperCustomerid);
                carInfo.setCarCreatTime(new Date());
                 falg = shopkeeperPersonService.saveCarInfo(carInfo);
                if (falg){
                    return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
                }
                return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
            } else {
                //0表示没车
                carInfo.setCarIsHave(0);
                carInfo.setCarBrand(carBrand);
                carInfo.setCarPlateNum(carPlateNum);
                carInfo.setCarChassisNum(carChassisNum);
                carInfo.setCarUsername(carUsername);
                carInfo.setShopkeeperCustomerid(shopkeeperCustomerid);
                carInfo.setCarCreatTime(new Date());
                 falg = shopkeeperPersonService.saveCarInfo(carInfo);
                if(falg){
                    return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
                }
                return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
            }
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
    /**
     * 保存房子基本信息的方法
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveHouseInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveHouseInfo(@RequestParam("houseArea") Double  houseArea,@RequestParam("houseAddr") String houseAddr,@RequestParam("houseUsername") String  houseUsername,@RequestParam("id") String id,@RequestParam("flag") int flag)  {
        SpsShopkeeperHouseProperty houseInfo = new SpsShopkeeperHouseProperty();
        //上传行车证件的标志 ----"1"为已经上传，”0“ 为没有上传
        Boolean falg;
        try {
            if ( flag==1) {
                //1表示有房
                houseInfo.setHouseIsHave(1);
                houseInfo.setHouseArea(houseArea);
                houseInfo.setHouseAddr(houseAddr);
                houseInfo.setHouseUsername(houseUsername);
                houseInfo.setShopkeeperCustomerid(id);
                houseInfo.setHouseCreatTime(new Date());
                falg= shopkeeperPersonService.saveHouseInfo(houseInfo);
                if (falg){
                    return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
                }
                return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
            } else {
                //0表示没房
                houseInfo.setHouseIsHave(0);
                houseInfo.setHouseArea(houseArea);
                houseInfo.setHouseAddr(houseAddr);
                houseInfo.setHouseUsername(houseUsername);
                houseInfo.setShopkeeperCustomerid(id);
                houseInfo.setHouseCreatTime(new Date());
                falg= shopkeeperPersonService.saveHouseInfo(houseInfo);
                if (falg){
                    return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
                }
                return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
            }
        }catch(Exception e){
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
}
