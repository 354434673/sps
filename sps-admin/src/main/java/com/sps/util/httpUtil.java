package com.sps.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class httpUtil {

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";






    /**
     * 发送json格式的post请求
     *
     * @param url  请求地址
     * @param json 请求内容，json格式
     * @return 响应的内容
     * @throws Exception
     */
    public static String httpPostWithJSONstr(String url, String json) throws Exception {
        String result = null;
        // 将JSON进行UTF-8编码,以便传输中文
        //String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        StringEntity se = new StringEntity(json, "UTF-8");
        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
        httpPost.setEntity(se);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse respon = httpClient.execute(httpPost);
        if (respon.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = respon.getEntity();
            result = EntityUtils.toString(httpEntity, "UTF-8");//取出应答字符串
        }
        respon.close();
        httpClient.close();
        return result;
    }
}
