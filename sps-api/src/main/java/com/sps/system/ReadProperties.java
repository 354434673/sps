package com.sps.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 用来读取配置文件中的信息
 * @author：yangxl
 * @date: 2016-1-20 上午10:31:10
 * @param
 * @return
 */
public class ReadProperties {

	public static String FILE_COMMON = ReadProperties.class.getResource("/") + "properties/dev.properties";

	public static Properties loadSetting(String uri) {
		Properties prop = new Properties();
		InputStream is = ReadProperties.class.getResourceAsStream(uri);
		if (is != null) {
			try {
				prop.load(is);
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if (is != null) {
					safeClose(is);
				}
			}
		
		} else {
			return null;
		}

		return prop;

	}

	/**
	 * 读取配置文件中的路径信息
	 */
	public static String read(String key) {
		String str = null;
		Properties prop = loadSetting(FILE_COMMON);
		if (prop != null) {
			str = prop.getProperty(key);
		}
		return str;
	}


	public static void safeClose(InputStream fis) { 
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) { 
				e.printStackTrace();;
			}
		}
	}

}
