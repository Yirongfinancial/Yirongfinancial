/*
 * syw
 * 16/05/07
 * 指定编码获取properties文件中的属性值（解决中文乱码问题）
 */
package com.edu.zzti.yirongfinancial.common;
import java.io.UnsupportedEncodingException;
import java.util.Properties;



public class PropertiesUtil {

	public PropertiesUtil() {
	}

	/**
	 * 指定编码获取properties文件中的属性值（解决中文乱码问题）
	 * 
	 * @param properties
	 *            java.util.Properties
	 * @param key
	 *            属性key
	 * @return
	 */
	public String getProperty(Properties properties, String key, String encoding)
			throws UnsupportedEncodingException {
		if (properties == null)
			return null;
		String value = properties.getProperty(key);// 如果此时value是中文，则应该是乱码
		if (value == null)
			return null;
		value = new String(value.getBytes("ISO8859-1"), encoding); // 编码转换，从ISO8859-1转向指定编码
		return value;
	}

	
}