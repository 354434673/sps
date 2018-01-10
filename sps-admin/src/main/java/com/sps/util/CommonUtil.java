package com.sps.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * 保存上传文件等工具类
 *
 * @author unknown
 * @date 2015年1月6日 下午8:56:52
 */
public class CommonUtil {

    /**
     * check Id is Legal DB table Id
     * @param id
     * @return
     */
    public static boolean isLegalId(Integer id) {
        return (id != null && id > 0);

    }

    /**
     * add years,months,days to date
     *
     * @param date
     * @param years
     * @param months
     * @param days
     * @return
     */
    public static Date addToDate(Date date, int years, int months, int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    /**
     * 保存上传文件
     * @return 文件名
     * @throws IOException
     */
    public static String saveFile(MultipartFile[] myfiles, String path, String imgName)
            throws IOException {
        // String realPath = propertiesUtil.get("adfile");//读取配置文件中的图片保存目录
        // 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
        // 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
        // 并且上传多个文件时，前台表单中的所有<input
        // type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
        for (MultipartFile myfile : myfiles) {
            if (myfile.isEmpty()) {
                imgName = null;
            } else {
                if (null == imgName) {
                    imgName = myfile.getOriginalFilename();
                } else {
                    imgName = imgName + "." + myfile.getOriginalFilename().split("\\.")[1];// 新文件名+扩展名
                }
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(path, imgName));
            }
        }
        return imgName;
    }

    /**
     * 使用UUID保存上传文件
     *
     * @param myfiles
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveFileUUID(MultipartFile[] myfiles, String path) throws IOException {
        return saveFile(myfiles, path, UUIDFactory.getUUIDStr());
    }

    /**
     * 单个文件上传
     * @param file
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveFileUUID(MultipartFile file, String path) throws IOException {
        String imgName = UUIDFactory.getUUIDStr();
        if (file.isEmpty()) {
            imgName = null;
        } else {
            if (null == imgName) {
                imgName = file.getOriginalFilename();
            } else {
                imgName = imgName + "." + file.getOriginalFilename().split("\\.")[1];// 新文件名+扩展名
            }
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, imgName));
        }
        return imgName;
    }


    /**
     * 保存上传文件（支持多文件自定义名称）
     *
     * @param files
     * @param path
     * @param names
     * @throws IOException
     */
    public static void saveFiles(List<CommonsMultipartFile> files, String path, List<String> names)
            throws IOException {
        for (int i = 0; i < files.size(); i++) {
            if (!files.get(i).isEmpty()) {
                FileUtils.copyInputStreamToFile(files.get(i).getInputStream(),
                        new File(path, names.get(i)));
            }
        }
    }

    /**
     * 保存上传文件
     *
     * @param myfiles
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveFile(MultipartFile[] myfiles, String path) throws IOException {
        return saveFile(myfiles, path, null);
    }

    public static Date strToDate(String DateStr){
        if(null==DateStr||"".trim().equals(DateStr))return null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(DateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public Map<String, Object> uploadPicture(@RequestParam(value = "file", required = false) MultipartFile[] file,
            String path, HttpServletRequest request) {
            Map<String, Object> resultMap = new HashMap<>();
            File targetFile = null;
            String msg = "";//返回存储路径
            List imgList = new ArrayList();
            if (file != null && file.length > 0) {
                for (int i = 0; i < file.length; i++) {
                    String fileName = file[i].getOriginalFilename();//获取文件名加后缀
                    if (fileName != null && fileName != "") {
                        String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
                        fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名
                        Date date = new Date();
                        //先判断文件是否存在
                        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                        // 转换成String
                        String d = format.format(date);// 得到的值20130802
                        File file1 = new File(path);
                        //如果文件夹不存在则创建
                        if (!file1.exists() && !file1.isDirectory()) {
                            file1.mkdirs();
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
