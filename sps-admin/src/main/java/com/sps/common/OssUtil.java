package com.sps.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.sps.exception.ImgException;

/**
 * 上传到阿里云存储
 * @ClassName:  OssUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月30日 下午3:09:02
 */
public class OssUtil {
	private static final Logger logger = LoggerFactory.getLogger(OssUtil.class);  
	//endpoint  
	private static final String END_POINT = "http://oss-cn-beijing.aliyuncs.com";
	//accessKey  
	private static final String ACCESS_KEY_ID = "LTAINyhXHyuamvL1";
	private static final String ACCESS_KEY_SECRET = "OqFhfSQKUGbHlOInfsd0IBmwIy72kp";
	//空间
	private static final String BUCKET_NAME  = "dianfu-test";
	private static final String KEY  = "dianfu-test";
	
	   // 文件存储目录  
    private String filedir = "";  
  
    private OSSClient ossClient;  
    
    public OssUtil() {  
        ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);  
    }  
    /** 
     * 初始化 
     */  
    public void init() {  
        ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);  
    }  
    /** 
     * 销毁 
     */  
    public void destory() {  
    	System.out.println("销毁");
        ossClient.shutdown();  
    }  
    /**
     * 上传图片
     * @Title: uploadImg2Oss   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param url
     * @param: @throws ImgException  
     * @author YangNingSheng    
     * @date 2018年3月31日 上午11:57:01
     * @return: void      
     * @throws
     */
    public void uploadImg2Oss(String url) throws ImgException {  
        File fileOnServer = new File(url);  
        FileInputStream fin;  
        try {  
            fin = new FileInputStream(fileOnServer);  
            String[] split = url.split("/");  
            this.uploadFile2OSS(fin, split[split.length - 1]);  
        } catch (FileNotFoundException e) {  
            throw new ImgException("图片上传失败");  
        }  
    }  
    public String uploadImg2Oss(MultipartFile file) throws ImgException {  
        if (file.getSize() > 10 * 1024 * 1024) {  
            throw new ImgException("上传图片大小不能超过10M！");  
        }  
        String originalFilename = file.getOriginalFilename();  
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();  
        Random random = new Random();  
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;  
        try {  
            InputStream inputStream = file.getInputStream();  
            this.uploadFile2OSS(inputStream, name);  
            return name;  
        } catch (Exception e) {  
            throw new ImgException("图片上传失败");  
        }  
    }  
    /**
     * 获得图片路径
     * @Title: getImgUrl   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param fileUrl
     * @param: @return  
     * @author YangNingSheng    
     * @date 2018年3月31日 下午12:18:07
     * @return: String      
     * @throws
     */
    public String getImgUrl(String fileUrl) {  
        System.out.println(fileUrl);  
        if (!StringUtils.isEmpty(fileUrl)) {  
            String[] split = fileUrl.split("/");  
            return this.getUrl(this.filedir + split[split.length - 1]);  
        }  
        return null;  
    }  
    /**
     * 上传到oss服务器 如果同名文件会覆盖服务器上的
     * @Title: uploadFile2OSS   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param instream 文件流
     * @param: @param fileName 文件名称,包括后缀
     * @param: @return  出错返回"" ,唯一MD5数字签名
     * @author YangNingSheng    
     * @date 2018年3月31日 下午12:16:16
     * @return: String      
     * @throws
     */
    public String uploadFile2OSS(InputStream instream, String fileName) {  
        String ret = "";  
        try {  
            // 创建上传Object的Metadata  
            ObjectMetadata objectMetadata = new ObjectMetadata();  
            objectMetadata.setContentLength(instream.available());  
            objectMetadata.setCacheControl("no-cache");  
            objectMetadata.setHeader("Pragma", "no-cache");  
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));  
            objectMetadata.setContentDisposition("inline;filename=" + fileName);  
            // 上传文件  
            PutObjectResult putResult = ossClient.putObject(BUCKET_NAME, filedir + fileName, instream, objectMetadata);  
            ret = putResult.getETag();  
        } catch (IOException e) {  
            logger.error(e.getMessage(), e);  
        } finally {  
            try {  
                if (instream != null) {  
                    instream.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return ret;  
    }  
    /**
     * 判断OSS服务文件上传时文件的contentTyp
     * @Title: getcontentType   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param filenameExtension 文件后缀 
     * @param: @return  
     * @author YangNingSheng    
     * @date 2018年3月31日 下午12:15:01
     * @return: String      
     * @throws
     */
    public static String getcontentType(String filenameExtension) {  
        if (filenameExtension.equalsIgnoreCase("bmp")) {  
            return "image/bmp";  
        }  
        if (filenameExtension.equalsIgnoreCase("gif")) {  
            return "image/gif";  
        }  
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")  
                || filenameExtension.equalsIgnoreCase("png")) {  
            return "image/jpeg";  
        }  
        if (filenameExtension.equalsIgnoreCase("html")) {  
            return "text/html";  
        }  
        if (filenameExtension.equalsIgnoreCase("txt")) {  
            return "text/plain";  
        }  
        if (filenameExtension.equalsIgnoreCase("vsd")) {  
            return "application/vnd.visio";  
        }  
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {  
            return "application/vnd.ms-powerpoint";  
        }  
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {  
            return "application/msword";  
        }  
        if (filenameExtension.equalsIgnoreCase("xml")) {  
            return "text/xml";  
        }  
        return "image/jpeg";  
    }  
    /**
     * 获得url连接
     * @Title: getUrl   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param key
     * @param: @return  
     * @author YangNingSheng    
     * @date 2018年3月31日 下午12:14:50
     * @return: String      
     * @throws
     */
    public String getUrl(String key) {  
        // 设置URL过期时间为10年 3600l* 1000*24*365*10  
  
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);  
        // 生成URL  
        URL url = ossClient.generatePresignedUrl(BUCKET_NAME, key, expiration);  
        if (url != null) {  
            return url.toString();  
        }  
        return null;  
    }  
}
