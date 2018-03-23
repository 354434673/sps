package com.sps.system;

import com.sps.common.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by baipan
 * Date: 2017-11-23
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String post(String json, String url) throws Exception {
        logger.info("POST请求URL："+url);
        logger.info("POST请求报文："+json);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (StringUtil.isNotEmpty(json)){
            StringEntity entity = new StringEntity(json, "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
        }
        HttpResponse response = client.execute(httpPost);
        InputStream inputStream = response.getEntity().getContent();
        InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferReader = new BufferedReader(inputReader);
        String result = read(bufferReader);
        logger.info("POST请求结果："+result);
        return result;
    }


    public static String get(String url, Map<String, Object> params) throws Exception{
        logger.info("GET请求URL："+url);
        logger.info("GET请求参数：");
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> pairs = new ArrayList<>(params.size());
            for (String key : params.keySet()) {
                logger.info(String.format("\tGET请求参数key：%s，value：%s", key, params.get(key).toString()));
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            url += (url.contains("?")?"&":"?") + EntityUtils.toString(new UrlEncodedFormEntity(pairs, "UTF-8"));
        }
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        //httpGet.setHeader("Connection", "close");
        HttpResponse response = client.execute(httpGet);
        InputStream inputStream = response.getEntity().getContent();
        InputStreamReader inputReader = new InputStreamReader(inputStream,"UTF-8");
        BufferedReader bufferReader = new BufferedReader(inputReader);
        String result=read(bufferReader);
        logger.info("GET请求结果："+result);
        return result;
    }


    private static String read(BufferedReader bufferReader) throws Exception{
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp=bufferReader.readLine())!=null){
            sb.append(temp);
        }
        return sb.toString();
    }

}
