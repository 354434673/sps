package com.sps.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sps.util.FinalData;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 37126 on 2018/1/3.
 */
@Controller
@RequestMapping("/common")
public class UploadController {
    /**
     * 通用文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/file/upload")
    @ResponseBody
    public Map<String, Object> uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file,
                                             HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        File targetFile = null;
        String msg = "";//返回存储路径
        int code = 1;
        String fileName = file.getOriginalFilename();//获取文件名加后缀
        if (fileName != null && fileName != "") {
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/src/main/webapp/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名
            Date date = new Date();
            //先判断文件是否存在
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            // 转换成String
            String d = format.format(date);// 得到的值20130802
            File file1 = new File("D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs" + "/" + d);
            //如果文件夹不存在则创建
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdir();
            }
            targetFile = new File(file1, fileName);
            try {
                file.transferTo(targetFile);
                //  msg=returnUrl+d+"/"+fileName;
                msg = fileName;
                code = 0;
                resultMap.put("code", 0);
                resultMap.put("fileName", fileName);
                resultMap.put("state", FinalData.STATE_SUCCESS);
               /* ri.setCode(0);
                ri.setMsg(fileName);*/
            } catch (Exception e) {
                resultMap.put("code", 0);
                resultMap.put("fileName", fileName);
                resultMap.put("state", FinalData.STATE_ERROR);
                e.printStackTrace();
            }
        }
        return resultMap;
    }


    /**
     * 通用文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/file/manyUpload")
    @ResponseBody
    public Map<String, Object> uploadPicture(@RequestParam(value = "file", required = false) MultipartFile[] file,
                                             HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        File targetFile = null;
        String msg = "";//返回存储路径
        List imgList = new ArrayList();
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                String fileName = file[i].getOriginalFilename();//获取文件名加后缀
                if (fileName != null && fileName != "") {
                    String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/src/main/webapp/upload/imgs/";//存储路径
                    String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
                    String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
                    fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名
                    Date date = new Date();
                    //先判断文件是否存在
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    // 转换成String
                    String d = format.format(date);// 得到的值20130802
                    File file1 = new File("D:/sps-ws/sps/sps-admin/src/main/webapp/upload/imgs" + "/");
                    //如果文件夹不存在则创建
                    if (!file1.exists() && !file1.isDirectory()) {
                        file1.mkdir();
                    }
                    targetFile = new File(file1, fileName);
                    try {
                        file[i].transferTo(targetFile);
                        //  msg=returnUrl+d+"/"+fileName;
                        imgList.add(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        resultMap.put("code", 0);
        resultMap.put("fileName", imgList);
        resultMap.put("state", FinalData.STATE_SUCCESS);
        return resultMap;
    }

}
