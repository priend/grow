package com.github.grow.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static final String LAST_TIME_DAY = " 23:59:59";

	/**
	 * yyyyMMdd
	 * 
	 * @param dateStr 时间字符串
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static Date parseDate(String dateStr) throws Exception {

		return new java.text.SimpleDateFormat("yyyyMMdd").parse(dateStr);
	}

	/**
	 * yyyyMMdd
	 * 
	 * @param date 时间
	 * @return String
	 * @throws Exception 转换异常
	 */
	public static String valueDate(Date date) throws Exception {

		return new java.text.SimpleDateFormat("yyyyMMdd").format(date);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @return String
	 * @throws Exception 转换异常
	 */
	public static String currentDateTime() throws Exception {

		return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param dateStr 时间字符串
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static Date parseDateTime(String dateStr) throws Exception {

		return new java.text.SimpleDateFormat("yyyyMMddHHmmss").parse(dateStr);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param date 时间
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static String valueDateTime(Date date) throws Exception {

		return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param dateStr 时间字符串
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static Date parseBarDate(String dateStr) throws Exception {

		return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param date 时间
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static String valueBarDate(Date date) throws Exception {

		return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr 时间字符串
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static Date parseBarDateTime(String dateStr) throws Exception {

		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date 时间
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static String valueBarDateTime(Date date) throws Exception {

		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 获取当月最后一天的时间
	 * 
	 * @param dateTime 时间
	 * @return Date
	 * @throws Exception 转换异常
	 */
	public static Date getBarLastDayTime(Date dateTime) throws Exception {

		return parseBarDateTime(
				new SimpleDateFormat("yyyy-MM-dd").format(getLastDayOfMonth(dateTime)).concat(LAST_TIME_DAY));
	}

	/**
	 * 获取当月最后一天
	 * 
	 * @param dateTime 时间
	 * @return Date
	 */
	public static Date getLastDayOfMonth(Date dateTime) {
		Calendar g = Calendar.getInstance();
		g.setTime(dateTime);
		g.set(Calendar.DAY_OF_MONTH, g.getActualMaximum(Calendar.DAY_OF_MONTH));
		return g.getTime();
	}

	/**
	 * 获取增加月的日期
	 * 
	 * @param dateTime 时间
	 * @param number   月
	 * @return Date
	 */
	public static Date addMonthDate(Date dateTime, Integer number) {
		Calendar g = Calendar.getInstance();
		g.setTime(dateTime);
		g.add(Calendar.MONTH, number);
		return g.getTime();
	}
}
