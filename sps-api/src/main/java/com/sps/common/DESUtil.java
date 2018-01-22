package com.sps.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DESUtil {

	private static final String MAC_NAME = "HmacSHA1";
	private static final String ENCODING = "UTF-8";
	private static final byte[] IV = {9, 3, 1, 2, 7, 0, 8, 6};
	private static final String DES_KEY = "o!20&^/@";

	private static Logger logger = LoggerFactory.getLogger(DESUtil.class);

	/**
	 * base64加密算法
	 */
	public static String encryptBase64(String str) {
		try {
			byte[] b = Base64.encodeBase64(str.getBytes(ENCODING));
			return new String(b);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String encryptBase64(byte[] bt) {
		byte[] b = Base64.encodeBase64(bt);
		return new String(b);
	}

	/**
	 * base64解密算法
	 */
	public static String decodeBase64(String str) {
		try {
			byte[] b = Base64.decodeBase64(str.getBytes(ENCODING));
			return new String(b);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * hamcsha1加密算法
	 */
	public static byte[] hamcsha1(byte[] data, byte[] key) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, MAC_NAME);
			Mac mac = Mac.getInstance(MAC_NAME);
			mac.init(signingKey);
			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过加密得到token
	 */
	public static String encryptAccessToken(String appKey, String SecretKey, String... apis)
			throws UnsupportedEncodingException {
		JSONObject obj = new JSONObject();
		obj.put("expiredTime", System.currentTimeMillis() + (10 * 1000 * 60));
		obj.put("scope", "USER");
		obj.put("apis", apis);
		String encodedAppKey = encryptBase64(appKey);
		String signingStr = encryptBase64(obj.toString());
		byte[] sign = hamcsha1(signingStr.getBytes(ENCODING), SecretKey.getBytes(ENCODING));
		String encodeSign = encryptBase64(sign);
//		logger.info(obj.toString());
//		logger.info("expiredTime："+obj.getString("expiredTime"));
//		logger.info("encodedAppKey：" + encodedAppKey);
//		logger.info("signingStr：" + signingStr);
//		logger.info("encodeSign：" + encodeSign);
		return encodedAppKey + ":" + encodeSign + ":" + signingStr;
	}


	/**
	 * 加密
	 */
	public static String encryptDES(String encryptString) throws Exception {
		if(StringUtil.isNotEmpty(encryptString)){
			IvParameterSpec zeroIv = new IvParameterSpec(IV);
			SecretKeySpec key = new SecretKeySpec(DES_KEY.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
			byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
			return Base64Utils.encode(encryptedData);
		}else{
			return null;
		}
	}


	/**
	 * 解密
	 */
	public static String decryptDES(String decryptString) throws Exception {
		if (StringUtil.isEmpty(decryptString)) {
			return "";
		}
		if (decryptString.startsWith("\"") && decryptString.endsWith("\"")) {
			decryptString = decryptString.substring(1, decryptString.length()-1);
		}
		byte[] byteMi = Base64Utils.decode(decryptString);
		IvParameterSpec zeroIv = new IvParameterSpec(IV);
		SecretKeySpec key = new SecretKeySpec(DES_KEY.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte decryptedData[] = cipher.doFinal(byteMi);
		return new String(decryptedData);
	}

	public static void main(String[] args) throws Exception {
		String pwd = "123456789";
		String en = encryptDES(pwd);
		String du = decryptDES(en);
		System.out.println("en:"+en);
		System.out.println(en.length());
		System.out.println("du:"+du);
		//System.out.println(encryptAccessToken("MY_APP_KEY", "MY_SECRET_KEY", "registerByPhone"));
	}
}
