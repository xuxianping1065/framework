package com.framework.common.util;

/**
 * 字符串工具类
 * @version 1.0
 * @author xxp
 */
public class StringUtils {

	
	/**
	 * 判断字符串是否非空
	 * @param str 字符串
	 * @return 
	 */
	public static boolean isNotEmpty(String str){
		return str != null && str.length() > 0;
	}
	
	
	/**
	 * 判断字符串是否非空（包括占位符）
	 * @param str 字符串
	 * @return 
	 */
	public static boolean isNotBlank(String str){
		return str != null && str.trim().length() > 0;
	}
	
}
