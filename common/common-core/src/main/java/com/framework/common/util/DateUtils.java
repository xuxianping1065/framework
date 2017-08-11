package com.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils {
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	public static final String yyyy_MM_dd_MM_mm_ss = "yyyy-MM-dd MM:mm:ss";

	
	/**
	 * 将时间格式化成默认格式（"yyyy-MM-dd MM:mm:ss"）的字符串
	 * @param date 时间对象
	 * @return 如果时间不为null并且时间格式正确,则返回格式化后的字符串;否则返回null
	 */
	public static String formatDate(Date date) {
		return formatDate(date, yyyy_MM_dd_MM_mm_ss);
	}

	
	/**
	 * 将时间格式化成指定格式的字符串
	 * @param date 时间对象
	 * @param pattern 时间格式
	 * @return 如果时间不为null并且时间格式正确,则返回格式化后的字符串;否则返回null
	 */
	public static String formatDate(Date date, String pattern) {
		if( date == null ) {
			return null;
		}
		String dateStr = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			dateStr = null;
		}
		return dateStr;
	}

	/**
	 * 将默认格式（"yyyy-MM-dd MM:mm:ss"）的时间字符串转换成Date对象
	 * @param dateStr 时间字符串
	 * @return 如果字符串不为空并且符合指定的时间格式,则返回时间对象Date对象, 否则返回null
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, yyyy_MM_dd_MM_mm_ss);
	}

	/**
	 * 将指定格式的时间字符串转换成Date对象
	 * @param dateStr 时间字符串
	 * @param pattern 指定的时间格式
	 * @return 如果字符串不为空并且符合指定的时间格式,则返回时间对象Date对象; 否则返回null
	 */
	public static Date parseDate(String dateStr, String pattern) {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 将时间加（减）一定时间后得到新的时间
	 * @param date 待处理的时间
	 * @param field 时间属性,年、月、日、时、分、秒、星期;具体值参考 <a>java.util.Calendar</a>
	 * @param offset 加减的值,减为负数
	 * @return 返回处理后的时间
	 */
	public static Date addDate(Date date, int field, int offset){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, offset);
		
		return calendar.getTime();
	}
	
	
	/**
	 * 将指定时间加减指定天数后的时间
	 * @param date 指定时间
	 * @param offset 加减的天数,减为负数
	 * @return 返回处理后的时间
	 */
	public static Date addDays(Date date, int offset){
		return addDate(date, Calendar.DAY_OF_MONTH, offset);
	}
}
