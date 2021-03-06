package com.sps.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static ThreadLocal<DateFormat> dateFormatStore = new ThreadLocal<DateFormat>();

	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMM = "yyyy-MM";
	public static final String yyyy = "yyyy";
	public static final String HHmmss = "HH:mm:ss";
	public static final String MM = "MM";
	public static final String week = "E";
	/**
	 * yyyy-MM-dd
	 */
	public final static String PNYYYYMMDD = "yyyyMMdd";

	/**
	 * 通过格式获取格式化对象,线程安全
	 * 
	 * @param datePattern
	 * @return
	 */
	public static DateFormat getDateFormat(String datePattern) {
		DateFormat fmt = dateFormatStore.get();
		if (fmt == null) {
			fmt = new SimpleDateFormat(datePattern);
			dateFormatStore.set(fmt);
		}
		return fmt;
	}

	/**
	 * 将字符串日期转换成Date对象
	 * 
	 * @param dateStr 日期字符串
	 * @param datePattern 日期格式
	 * @return
	 */
	public static Date parse(String dateStr, String datePattern) {
		try {
			return getDateFormat(datePattern).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将Date对象转换成字符串日期
	 * 
	 * @param date 日期对象
	 * @param datePattern 日期格式
	 * @return
	 */
	public static String format(Date date, String datePattern) {
		return getDateFormat(datePattern).format(date);
	}
	
	/**
	 * 取得特定时间对应的字符串,格式化为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date 日期对象
	 * @return
	 */
	public static String ymdhmsFormat(Date date) {
		return format(date, yyyyMMddHHmmss);
	}

	/**
	 * 取得特定时间对应的字符串,格式化为yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String ymdFormat(Date date) {
		return format(date, yyyyMMdd);
	}

	/**
	 * 根据当前日期,得到当前年月
	 * 
	 * @param date
	 * @return str
	 */
	public static final String ymFormat(Date date) {
		if (date == null)
			return "";
		return format(date, yyyyMM);
	}

	/**
	 * 根据当前日期,得到当前年份
	 * 
	 * @param date
	 * @return str
	 */
	public static final String yFormat(Date date) {
		if (date == null)
			return "";
		return format(date, yyyy);
	}

	/**
	 * 根据当前日期,得到当前月份
	 * 
	 * @param date
	 * @return str
	 */
	public static final String mFormat(Date date) {
		if (date == null)
			return "";
		return format(date, MM);
	}
	
	/**
	 * 返回当前的时间，格式为H:mm:ss
	 * 
	 * @return 时间字符串
	 */
	public static final String getTimeNow() {
		return format(new Date(), HHmmss);
	}

	/**
	 * 把字符串形式转换成日期形式，字符串的格式必须为yyyy-MM-dd
	 * 
	 * @param ymdStringDate
	 * @return date
	 */
	public static final Date ymdString2Date(String ymdStringDate) {
		if (ymdStringDate == null)
			return null;
		return parse(ymdStringDate, yyyyMMdd);
	}

	/**
	 * 把字符串形式转换成日期形式，字符串的格式必须为yyyy-MM-dd
	 * 
	 * @param ymdhmsStringDate
	 * @return date
	 */
	public static final Date ymdhmsString2Date(String ymdhmsStringDate) {
		if (ymdhmsStringDate == null)
			return null;
		return parse(ymdhmsStringDate, yyyyMMddHHmmss);
	}

	/**
	 * 
	 * 得到当前时间,把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
	 * 
	 * @return date
	 */
	public static Date getCurrentDate() {
		Date date = new Date();
		return zerolizedTime(date);
	}

	/**
	 * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
	 * 
	 * @param fullDate
	 * @return Date
	 */
	public static final Date zerolizedTime(Date fullDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fullDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到两个时间的间隔
	 * 
	 * @param bDate
	 * @param eDate
	 * @return
	 */
	static public long dateDiffByDay(Date bDate, Date eDate) {
		if (bDate == null || eDate == null)
			return 0L;
		return (bDate.getTime() - eDate.getTime()) / (1000 * 3600 * 24);
	}


	/**
	 * 取得指定日期的星期数
	 * 
	 * @return String
	 */
	public static final String getWeek(Date date) {
		if (date == null)
			return null;
		return format(date, week);
	}
	/**
	 * 获得指定日期的前一天或者后一天（由传入的num决定）的 date 对象 后几天的日期
	 * @param date
	 * @param num：0表示当前天 -1 表示上一天，1表示后一天，其他以此类推
	 * @return
	 */
	public static Date dateGapDays(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, num);
		return cal.getTime();
	}
	/**
	 * 获取系统当前时间，精确到天
	 * @return
	 */
	public static Date getNowDD(){
		Date date = new Date();
		String dateStr = dateToStr(date, PNYYYYMMDD);
		return strToDate(dateStr, PNYYYYMMDD);
	}
	/**
	 * 字符串格式日期转日期格式日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date strToDate(String date,String pattern){
		if(isEmpty(date) || isEmpty(pattern)){
			return null ;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date) ;
		} catch (ParseException e) {
			e.printStackTrace();
			return null ;
		}
	}
	/**
	 * 检测Date
	 * @param date
	 * @return
	 */
	private static boolean isEmpty(Date date){
		return null == date ? true : isEmpty(date.toString()) ;
	}
	/**
	 * 日期格式日期转字符串格式日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToStr(Date date,String pattern){
		if(isEmpty(date) || isEmpty(pattern)){
			return null ;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date) ;
	}
	/**
	 * 检查字符串
	 * @param str
	 * @return
	 */
	private static boolean isEmpty(String str) {
		return null == str ? true : "".equals(str.replaceAll(" +", ""));
	}

	/**
	 * 判断两个日期字符串是否相等,格式必需为yyyy-MM-dd
	 * 
	 * @param one
	 *            第一个日期字符串
	 * @param two
	 *            第二个日期字符串
	 * @return Boolean
	 */
	public static final boolean  isEqual(String one, String two) {
		return ymdString2Date(one).equals(ymdString2Date(two));
	}

	/**
	 * 判断两个日期字符串是否相等
	 * 
	 * @param one
	 *            第一个日期字符串
	 * @param two
	 *            第二个日期字符串
	 * @param datePattern
	 *            包含日期格式的字符串
	 * @return Boolean
	 */
	public static final boolean  isEqual(String one, String two, String datePattern) {

		return isEqual(one, two, datePattern, datePattern);
	}

	/**
	 * 判断两个日期字符串是否相等
	 * 
	 * @param one
	 *            第一个日期字符串
	 * @param two
	 *            第二个日期字符串
	 * @param datePatternOne
	 *            对应第一个日期字符串的包含日期格式的字符串
	 * @param datePatternTwo
	 *            对应第二个日期字符串的包含日期格式的字符串
	 * @return Boolean
	 */
	public static final Boolean isEqual(String one, String two,
			String datePatternOne, String datePatternTwo) {

		return parse(one, datePatternOne).equals(parse(two, datePatternTwo));
	}

	/**
	 * 返回两时间的时间间隔（以分计算）
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	static public long spaceMinute(Date date1, Date date2) {
		Long num1 = date1.getTime();
		Long num2 = date2.getTime();
		Long space = (num2 - num1) / (1000 * 60);
		return space;
	}

	/**
	 * 返回两时间的时间间隔（以天计算）
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	static public Long spaceDay(Date date1, Date date2) {
		Long num1 = date1.getTime();
		Long num2 = date2.getTime();
		Long space = (num2 - num1) / (1000 * 3600 * 24);
		return space;
	}

	static public Date getDateAfterDay(Date somedate, int day) {
		if (somedate == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(somedate);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return new Date(cal.getTime().getTime());
	}

	static public Timestamp getDateAfterDay(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, day);
		return new Timestamp(cal.getTime().getTime());
	}

	static public Timestamp getTSAfterDay(Date somedate, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(somedate);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return new Timestamp(cal.getTime().getTime());
	}

	// 取得本月第一天时间
	static public Date getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
}
