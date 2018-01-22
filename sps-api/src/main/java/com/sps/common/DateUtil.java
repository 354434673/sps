package com.sps.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {

	/**
	 * 返回每天、每月、每年中每个时间点的对应的数据list
	 * 
	 * @param hasYield
	 *            是否包括收益列表
	 * @param datalist
	 *            数据
	 * @param sdf
	 *            日期格式
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 * @param datetype
	 *            'hour'-每小时，'day'-每天,'month'-每月,'year'-每年
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> dateData(List<Map<String, Object>> datalist, String starttime, String endtime,
			String datetype) throws Exception {
		Map<String, Object> resultList = new HashMap<>();
		List<String> dayList = new ArrayList<String>();
		List<Double> data = new ArrayList<Double>();
		List<Double> yield = new ArrayList<Double>();
		List<Date> days = new ArrayList<>();
		SimpleDateFormat sdf = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (datalist != null && datalist.size() > 0) {
			Date begin = format.parse(starttime);
			Date end = format.parse(endtime);
			if (datetype.equals("hour")) {
				days = findDates(begin, end, Calendar.HOUR_OF_DAY);
				sdf = new SimpleDateFormat("yyyyMMddHH");
			} else if (datetype.equals("day")) {
				days = findDates(begin, end, Calendar.DAY_OF_MONTH);
				sdf = new SimpleDateFormat("yyyyMMdd");
			} else if (datetype.equals("month")) {
				days = findDates(begin, end, Calendar.MONTH);
				sdf = new SimpleDateFormat("yyyyMM");
			} else if (datetype.equals("year")) {
				days = findDates(begin, end, Calendar.YEAR);
				sdf = new SimpleDateFormat("yyyy");
			}
			int j = 0;
			for (Map<String, Object> map : datalist) {
				for (int i = j; i < days.size(); i++) {
					String key = sdf.format(days.get(i));
					dayList.add(key);
					if (key.equals(sdf.format(map.get(datetype)))) {
						data.add(Double.parseDouble(map.get("sum").toString()));
						yield.add(Double.parseDouble(map.get("yield").toString()));
						j = i + 1;
						break;
					} else {
						data.add(0.00);
						yield.add(0.00);
					}
				}
			}
			while (j < days.size()) {
				String key = sdf.format(days.get(j));
				dayList.add(key);
				data.add(0.00);
				yield.add(0.00);
				j++;
			}
		}
		resultList.put("time", dayList);
		resultList.put("gener", data);
		resultList.put("yield", yield);
		return resultList;
	}

	/**
	 * 返回每天、每月、每年中每个时间点的对应的数据list
	 * 
	 * @param datalist
	 *            数据
	 * @param sdf
	 *            日期格式
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 * @param datetype
	 *            'hour'-每小时，'day'-每天,'month'-每月,'year'-每年
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> powerDateData(List<Map<String, Object>> datalist, String starttime,
			String endtime, String datetype) throws Exception {
		Map<String, Object> resultList = new HashMap<>();
		List<String> dayList = new ArrayList<String>();
		List<Double> data = new ArrayList<Double>();
		List<Date> days = new ArrayList<>();
		SimpleDateFormat format = null;
		// SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		if (datalist != null && datalist.size() > 0) {

			if (datetype.equals("hour")) {
				format = new SimpleDateFormat("yyyyMMddHH");
				Date begin = format.parse(starttime);
				Date end = format.parse(endtime);
				days = findDates(begin, end, Calendar.HOUR_OF_DAY);
			} else if (datetype.equals("day")) {
				format = new SimpleDateFormat("yyyyMMdd");
				Date begin = format.parse(starttime);
				Date end = format.parse(endtime);
				days = findDates(begin, end, Calendar.DAY_OF_MONTH);
			} else if (datetype.equals("month")) {
				format = new SimpleDateFormat("yyyyMM");
				Date begin = format.parse(starttime);
				Date end = format.parse(endtime);
				days = findDates(begin, end, Calendar.MONTH);
			} else if (datetype.equals("year")) {
				format = new SimpleDateFormat("yyyy");
				Date begin = format.parse(starttime);
				Date end = format.parse(endtime);
				days = findDates(begin, end, Calendar.YEAR);
			}
			int j = 0;
			for (Map<String, Object> map : datalist) {
				for (int i = j; i < days.size(); i++) {
					String key = format.format(days.get(i));
					dayList.add(key);
					if (key.equals(map.get(datetype))) {
						data.add(Double.parseDouble(map.get("sum").toString()));
						j = i + 1;
						break;
					} else {
						data.add(0.00);
					}
				}
			}
			while (j < days.size()) {
				String key = format.format(days.get(j));
				dayList.add(key);
				data.add(0.00);
				j++;
			}
		}
		resultList.put("timelist", dayList);
		resultList.put("powerlist", data);
		return resultList;
	}

	public static List<Date> findDates(Date dBegin, Date dEnd, int param) {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 验证此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(param, 1);
			dateList.add(calBegin.getTime());
		}
		return dateList;
	}

	public static String dateFormat(String date, String type) throws ParseException {
		Date time = null;
		if (type.equals("hour")) {
			time = new SimpleDateFormat("yyyyMMddHH").parse(date);
		} else if (type.equals("day")) {
			time = new SimpleDateFormat("yyyyMMdd").parse(date);
		} else if (type.equals("month")) {
			time = new SimpleDateFormat("yyyyMM").parse(date);
		} else if (type.equals("year")) {
			time = new SimpleDateFormat("yyyy").parse(date);
		}
		return new SimpleDateFormat().format(time);
	}

	public static String getYesterday(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return format.format(calendar.getTime());
	}

	public static void main(String[] args) {

	}
}
