package com.sps.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSONObject;

public class TestZx {
    Logger logger = LoggerFactory.getLogger(getClass());

    public void testCreateOrder() throws ClientProtocolException, IOException {
        String url = "http://39.106.207.241:8080/m/assets/order/createOrder";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appId", "123");//总线分配的客户端id
        jsonObject.put("data", "miwen");//密文
        jsonObject.put("sign", "qianming");//签名
        String result = postHttpJson(url, jsonObject);
        System.out.println("result：" + result);
    }

    public String postHttpJson(String url, JSONObject json) {
        Map<String, String> header = new HashMap<>();
        //        header.put("accept", "*/*");
        //        header.put("connection", "Keep-Alive");
        //        header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        HttpResponse response = doPost4fastjson(url, header, json);
        return getStringFromResponse(response);
    }

    public static HttpResponse doPost4fastjson(String url, Map<String, String> headers,
                                               JSONObject json) {
        HttpClient client = createHttpClient();
        HttpPost postMethod = new HttpPost(url);
        HttpResponse response = null;
        try {
            if (headers != null && headers.keySet().size() > 0) {
                for (String key : headers.keySet()) {
                    postMethod.addHeader(key, headers.get(key));
                    System.out.println(key + "\t" + headers.get(key));
                }
            }
            StringEntity entity = new StringEntity(json.toJSONString(), HTTP.PLAIN_TEXT_TYPE,
                "UTF-8");
            postMethod.setEntity(entity);
            response = client.execute(postMethod);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }

    private final static HttpClient createHttpClient() {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager clientmanager = new ThreadSafeClientConnManager();
        clientmanager.setMaxTotal(20);
        HttpClient client = new DefaultHttpClient(clientmanager, params);
        //设置socket链接超时时间
        client.getParams().setParameter("http.socket.timeout", new Integer(600000));
        client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
        HttpProtocolParams.setUseExpectContinue(client.getParams(), false);
        //      ConnManagerParams.setTimeout(params, 6000000);
        // 连接超时
        HttpConnectionParams.setConnectionTimeout(params, 600000);
        // 请求超时
        HttpConnectionParams.setSoTimeout(params, 600000);
        return client;
    }

    public static String getStringFromResponse(HttpResponse response) {
        if (response == null) {
            return null;
        }
        HttpEntity httpEntity = response.getEntity();
        Header[] headers = response.getHeaders("Content-Encoding");
        for (Header h : headers) {
            if (h.getValue().contains("gzip")) {
                httpEntity = new GzipDecompressingEntity(httpEntity);
                break;
            }
        }
        InputStream in = null;
        try {
            in = httpEntity.getContent();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseText = null;
        if (in != null) {
            responseText = getStringFromStreamUTF8(in);
        }
        return responseText;
    }

    //从流中得到字符串格式内容
    public static String getStringFromStreamUTF8(InputStream in) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        String str = null;
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str + "\n");
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return buffer.toString();
    }
}
