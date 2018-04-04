package com.sps.controller.app.person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.OptionUtil;
import com.sps.common.StringUtil;
import com.sps.entity.shopkeeper.SpsShopkeeperCarProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperHouseProperty;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.juzifenqi.core.EjavashopSequence.getKey;

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
    @Autowired
    private ShopkeeperPicService shopkeeperPicService;
    /**
     * 获取昵称和头像的方法
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/queryPersonInfo", method = RequestMethod.POST)
    @ResponseBody
    public String queryPersonInfo(@RequestParam("customerId") String  customerId,@RequestParam("phone")String phone) {
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        SpsShopkeeperPic pic = shopkeeperPicService.findByCustomerId(customerId);
        JSONObject jsonO = new JSONObject();
        if(person !=null){
            if(pic==null){
                if (StringUtil.isNotEmpty(person.getPersonalNickname())) {
                    jsonO.put("name", person.getPersonalNickname());
                }else{
                    jsonO.put("name", phone);
                }
                jsonO.put("src", null);
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
            }else{
                if (StringUtil.isNotEmpty(person.getPersonalNickname())) {
                    jsonO.put("name", person.getPersonalNickname());
                }else{
                    jsonO.put("name", phone);
                }
                jsonO.put("src", pic.getPicSrc());
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
            }
        }
        return Message.responseStr(Message.FAILURE_CODE, "该客户编号不存在");
    }

    /**
     * 修改头像的方法
     * @param customerId
     * @param src
     * @return
     */
    @RequestMapping(value = "/saveSrc", method = RequestMethod.POST)
    @ResponseBody
    public String saveSrc(@RequestParam("customerId") String customerId, @RequestParam("src") String src) {
        //入参检查
            Boolean flag = shopkeeperPersonService.saveSrc(customerId, src);
            if (flag) {
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
    }

    /**
     * 修改昵称的方法
     * @param customerId
     * @param nickName
     * @return
     */
    @RequestMapping(value = "updateNicknamerc", method = RequestMethod.POST)
    @ResponseBody
    public String updateNicknamerc(@RequestParam("customerId") String customerId, @RequestParam("nickName") String nickName)  {
        //入参检查
         Boolean flag = shopkeeperPersonService.updateNickName(customerId, nickName);
        if(flag){
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
        }
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }

    /**
     *   获取汽车类型
      * @return
     */
    @RequestMapping(value = "/queryCarType", method = RequestMethod.POST)
    @ResponseBody
    public String queryCarType(){
        JSONObject jsonO = new JSONObject();
        String carBrandSmail = OptionUtil.CAR_BRAND_SMAIL;
        String carBrandBig = OptionUtil.CAR_BRAND_BIG;
        List<String> carType = new ArrayList<>();
        carType.add(carBrandSmail);
        carType.add(carBrandBig);
        jsonO.put("carType",carType);
        return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG,jsonO);
    }

    /**
     * 刘彩玲
     * 保存车辆基本信息
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveCarInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveCarInfo(@RequestParam("carChassisNum") String carChassisNum,@RequestParam("carPlateNum") String carPlateNum,@RequestParam("carBrand") String carBrand,@RequestParam("carUsername") String carUsername,@RequestParam("customerId") String customerId,@RequestParam("src") String src)  {
        SpsShopkeeperCarProperty carInfo = new SpsShopkeeperCarProperty();
        Boolean flag;
        //上传行车证件的标志 ----"1"为已经上传，”0“ 为没有上传
        if ( StringUtil.isNotEmpty(src)) {
            //1表示有车
            carInfo.setCarIsHave(1);
            carInfo.setCarBrand(carBrand);
            carInfo.setCarPlateNum(carPlateNum);
            carInfo.setCarChassisNum(carChassisNum);
            carInfo.setCarUsername(carUsername);
            carInfo.setShopkeeperCustomerid(customerId);
            carInfo.setCarCreatTime(new Date());
             flag=shopkeeperPersonService.saveCarInfo(carInfo,src);
            if (flag){
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
            carInfo.setShopkeeperCustomerid(customerId);
            carInfo.setCarCreatTime(new Date());
            flag = shopkeeperPersonService.saveCarInfo(carInfo,src);
            if(flag){
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
            }
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
    /**
     * 保存房子基本信息的方法
     * @return
     * @throws Exception
     */
    @RequestMapping(value ="/saveHouseInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveHouseInfo(@RequestParam("houseArea") Double  houseArea,@RequestParam("houseAddr") String houseAddr,@RequestParam("houseUsername") String  houseUsername,@RequestParam("customerId") String customerId,@RequestParam("srcList") List<String> srcList)  {
        SpsShopkeeperHouseProperty houseInfo = new SpsShopkeeperHouseProperty();
        //上传行车证件的标志 ----"1"为已经上传，"0" 为没有上传
        String[] strs=houseAddr.split("-");
        for(int i=0,len=strs.length;i<len;i++){
            strs[i].toString().trim();
        }
        Boolean flag;
        if (srcList.size()>0) {
            //1表示有房
            houseInfo.setHouseIsHave(1);
            houseInfo.setHouseProvinceName(strs[0]);
            houseInfo.setHouseProvinceCode(strs[1]);
            houseInfo.setHouseCityName(strs[2]);
            houseInfo.setHouseCityCode(strs[3]);
            houseInfo.setHouseAreaName(strs[4]);
            houseInfo.setHouseAreaCode(strs[5]);
            houseInfo.setHouseArea(houseArea);
            houseInfo.setHouseAddr(strs[6]);
            houseInfo.setHouseUsername(houseUsername);
            houseInfo.setShopkeeperCustomerid(customerId);
            houseInfo.setHouseCreatTime(new Date());
            flag= shopkeeperPersonService.saveHouseInfo(houseInfo, srcList);
            if (flag) {
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
            }
                return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
         } else {
                //0表示没房
                houseInfo.setHouseIsHave(0);
                houseInfo.setHouseArea(houseArea);
                houseInfo.setHouseProvinceName(strs[0]);
                houseInfo.setHouseProvinceCode(strs[1]);
                houseInfo.setHouseCityName(strs[2]);
                houseInfo.setHouseCityCode(strs[3]);
                houseInfo.setHouseAreaName(strs[4]);
                houseInfo.setHouseAreaCode(strs[5]);
                houseInfo.setHouseAddr(strs[6]);
                houseInfo.setHouseUsername(houseUsername);
                houseInfo.setShopkeeperCustomerid(customerId);
                houseInfo.setHouseCreatTime(new Date());
                 flag=shopkeeperPersonService.saveHouseInfo(houseInfo,null);
                if (flag){
                    return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG);
                }
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
    }
}
