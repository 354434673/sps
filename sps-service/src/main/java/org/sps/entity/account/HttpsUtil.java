package org.sps.entity.account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpsUtil {
	  private static final int TIMEOUT = 45000;
	    public static final String ENCODING = "UTF-8";

	    /**
	     * 创建HTTP连接
	     *
	     * @param url
	     *            地址
	     * @param method
	     *            方法
	     * @param body
	     *            请求内容
	     * @return
	     * @throws Exception
	     */
	    private static HttpURLConnection createConnection(String url,String method,String body)
	            throws Exception {
	        URL Url = new URL(url);
	        trustAllHttpsCertificates();
	        HttpURLConnection httpConnection = (HttpURLConnection) Url.openConnection();
	        // 设置请求时间
	        httpConnection.setConnectTimeout(TIMEOUT);
	        httpConnection.setRequestProperty("accept", "*/*");
	        httpConnection.setRequestProperty("connection", "Keep-Alive");
	        httpConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        httpConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=" + ENCODING);
	        // 设置请求方法
	        httpConnection.setRequestMethod(method);
	        httpConnection.setDoOutput(true);
	        httpConnection.setDoInput(true);
	        // 写query数据流
	        if (!(body == null || body.trim().equals(""))) {
	            OutputStream writer = httpConnection.getOutputStream();
	            try {
	                writer.write(body.getBytes(ENCODING));
	            } finally {
	                if (writer != null) {
	                    writer.flush();
	                    writer.close();
	                }
	            }
	        }
	        // 请求结果
	        int responseCode = httpConnection.getResponseCode();
	        if (responseCode != 200) {
	            throw new Exception(responseCode+":"+ inputStream2String(httpConnection.getErrorStream(),ENCODING));
	        }

	        return httpConnection;
	    }
	    /**
	     * POST请求
	     * @param address 请求地址
	     * @param params 参数
	     * @param
	     * @return
	     * @throws Exception
	     */
	    public static String  post(String address,Map<String, String> params) throws Exception {
	            String result = null;
	            HttpURLConnection httpConnection = null;
	            try {
	                String bd ="";
	                StringBuilder body = new StringBuilder();
	                Iterator<String> iteratorHeader = params.keySet().iterator();
	                while (iteratorHeader.hasNext()) {
	                    String key = iteratorHeader.next();
	                    String value = params.get(key);
	                    body.append(key + "=" + URLEncoder.encode(value, ENCODING)+ "&");
	                }
	                bd = body.length() == 0 ? "" : body.substring(0, body.length()-1);
	                httpConnection = createConnection(address, "POST", bd);
	                String encoding = "UTF-8";
	                if (httpConnection.getContentType() != null && httpConnection.getContentType().indexOf("charset=") >= 0) {
	                    encoding = httpConnection.getContentType().substring(httpConnection.getContentType().indexOf("charset=") + 8);
	                }
	                result = inputStream2String(httpConnection.getInputStream(),encoding);
	                result = result.substring(result.indexOf("{"));
	            } catch (Exception e) {
	                // logger.info("HTTPproxy error: {}", e.getMessage());
	                throw e;
	            } finally {
	                if (httpConnection != null) {
	                    httpConnection.disconnect();
	                }
	            }
	            return result;
	    }

	    /**
	     * 读取inputStream 到 string
	     * @param input
	     * @param encoding
	     * @return
	     * @throws IOException
	     */
	    private static String inputStream2String(InputStream input, String encoding)
	            throws IOException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(input,encoding));
	        StringBuilder result = new StringBuilder();
	        String temp = null;
	        while ((temp = reader.readLine()) != null) {
	            result.append(temp);
	        }
	        return result.toString();

	    }
	    /**
	     * 设置 https 请求
	     * @throws Exception
	     */
	    private static void trustAllHttpsCertificates() throws Exception {
	        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
	            public boolean verify(String str, SSLSession session) {
	                return true;
	            }
	        });
	        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
	        javax.net.ssl.TrustManager tm = new miTM();
	        trustAllCerts[0] = tm;
	        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, null);
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    }


	    //设置 https 请求证书
	    private static class miTM implements javax.net.ssl.TrustManager,javax.net.ssl.X509TrustManager {

	        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }

	        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
	            return true;
	        }

	        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
	            return true;
	        }

	        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
	                throws java.security.cert.CertificateException {
	            return;
	        }

	        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
	                throws java.security.cert.CertificateException {
	            return;
	        }


	    }




	    //====================================================================
	    //============================= 测试调用   ============================
	    //====================================================================
	    public static void main(String[] args) {

	        try {
	            //test2();
	            test();

	        } catch (Exception e) {
	            // TODO 异常
	            e.printStackTrace();
	        }

	    }

	    private static void test() throws Exception{
	        String address = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/unified/auth/request";
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("merchantno","dfsfsdffdsdsf");
	        params.put("appkey","app_OxxqX4wGlpMjNWTQvMxnlt7gGHXHaHv6");
	        params.put("requestno","1235445555");
	        params.put("identityid","142325198903160519");
	        params.put("identitytype","USER_ID");
	        params.put("cardno","6228480402564890018 ");
	        params.put("idcardno","142325198903160519");
	        params.put("idcardtype","ID");
	        params.put("username","哈哈哈");
	        params.put("phone","18612174790");
	        params.put("issms","true");
	        params.put("advicesmstype","MESSAGE");
	        params.put("avaliabletime","2");
	        // params.put("callbackurl",null);
	        params.put("requesttime","2018-02-04 03:07:01");
	        params.put("authtype","COMMON_FOUR");
	        String res = post(address, params);
	       // JSONObject result = JSONObject.parseObject(res);//转JSON
	       // System.out.println(result.toString());//打印
	    }
}
