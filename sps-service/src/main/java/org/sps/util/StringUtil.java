package org.sps.util;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


public class StringUtil {

	/**
	 * 判断是否是一个中文汉字
	 * @param c
	 *            字符 
	 * @return true表示是中文汉字，false表示是英文字母
	 * @throws UnsupportedEncodingException    使用了JAVA不支持的编码格式
	 */
	public static boolean isChineseChar(char c) throws UnsupportedEncodingException {
		// 如果字节数大于1，是汉字
		// 以这种方式区别英文字母和中文汉字并不是十分严谨，但在这个题目中，这样判断已经足够了
		return String.valueOf(c).getBytes("utf-8").length > 1;
	}


	/**
	 * 计算当前String字符串所占的总Byte长度
	 * @param args
	 *              要截取的字符串
	 * @return
	 *              返回值int型，字符串所占的字节长度，如果args为空或者“”则返回0
	 * @throws UnsupportedEncodingException
	 */
	public static int getStringByteLenths(String args) throws UnsupportedEncodingException{
		return args!=null&&args!=""? args.getBytes("utf-8").length:0;
	}

	/**
	 * 获取与字符串每一个char对应的字节长度数组
	 * @param  args
	 *              要计算的目标字符串
	 * @return int[]
	 *              数组类型，返回与字符串每一个char对应的字节长度数组
	 * @throws UnsupportedEncodingException
	 */
	public static int[] getByteLenArrays(String args) throws UnsupportedEncodingException{
		char[] strlen=args.toCharArray();
		int[] charlen=new int[strlen.length];
		for (int i = 0; i < strlen.length; i++) {
			charlen[i]=String.valueOf(strlen[i]).getBytes("utf-8").length;
		}
		return charlen;
	}

	/**
	 * 按字节截取字符串 ，指定截取起始字节位置与截取字节长度
	 *
	 * @param orignal
	 *              要截取的字符串
	 * @param offset
	 *              截取Byte长度；
	 * @return
	 *              截取后的字符串
	 * @throws UnsupportedEncodingException
	 *              使用了JAVA不支持的编码格式
	 */
	public static String substringByte(String orignal,int start, int count){

		//如果目标字符串为空，则直接返回，不进入截取逻辑；
		if(orignal==null || "".equals(orignal))return orignal;

		//截取Byte长度必须>0
		if (count <= 0) return orignal;

		//截取的起始字节数必须比
		if(start<0) start=0;

		//目标char Pull buff缓存区间；
		StringBuffer buff = new StringBuffer();

		try {

			//截取字节起始字节位置大于目标String的Byte的length则返回空值
			if (start >= getStringByteLenths(orignal)) return null;

			// int[] arrlen=getByteLenArrays(orignal);
			int len=0;

			char c;

			//遍历String的每一个Char字符，计算当前总长度
			//如果到当前Char的的字节长度大于要截取的字符总长度，则跳出循环返回截取的字符串。
			for (int i = 0; i < orignal.toCharArray().length; i++) {

				c=orignal.charAt(i);

				//当起始位置为0时候
				if(start==0){

					len+=String.valueOf(c).getBytes("utf-8").length;
					if(len<=count) buff.append(c);
					else break;

				}else{

					//截取字符串从非0位置开始
					len+=String.valueOf(c).getBytes("utf-8").length;
					if(len>=start&&len<=start+count){
						buff.append(c);
					}
					if(len>start+count) break;

				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//返回最终截取的字符结果;
		//创建String对象，传入目标char Buff对象
		return new String(buff);
	}

	/**
	 * 截取指定长度字符串
	 * @param orignal 要截取的目标字符串
	 * @param count 指定截取长度
	 * @return 返回截取后的字符串
	 */
	public static String substringByte(String orignal, int count){
		return substringByte(orignal,0,count);
	}

	public static boolean isEmpty(String str){
		return str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim());
	}

	public static boolean isNotEmpty(String str){
		return str != null && str.trim().length() > 0 && !"null".equalsIgnoreCase(str.trim());
	}


	/**
	 * 检测List是否不为空
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean isNotEmpty(List<?> list){
		return list!=null && list.size()>0;
	}


	/**
	 * 检测List是否为空
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(List<?> list){
		return list==null || list.size()<1;
	}


	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(isEmpty(str)){
			return null;
		}
		return str.split(splitRegex);
	}


	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}


	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 */
	public static Date str2Date(String date){
		if(isNotEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}else{
			return null;
		}
	}

	public static boolean isIp(Object ip) {
		String is=(String) ip;
		return !isEmpty(is) && Pattern.compile("^(?:(?:1[0-9][0-9]\\.)|(?:2[0-4][0-9]\\.)|(?:25[0-5]\\.)"
				+ "|(?:[1-9][0-9]\\.)|(?:[0-9]\\.)){3}(?:(?:1[0-9][0-9])|(?:2[0-4][0-9])|(?:25[0-5])|(?:[1-9][0-9])|(?:[0-9]))$").matcher(is).matches();
	}

	public static boolean isUserId(Object userid) {
		String us=(String) userid;
		return !isEmpty(us) && us.length() <= 32;
	}

	public static boolean isDevName(Object devname) {
		return isName(devname);
	}
	/**
	 * 检查domain参数是否合法
	 */
	public static boolean isDomainId(Object domainid) {
		String ds=(String) domainid;
		return !isEmpty(ds) && ds.length() < 32;
	}

	public static boolean isParentId(Object parentId) {
		String ps=(String) parentId;
		return !isEmpty(ps)&&ps.length()<32 ;
	}

	public static boolean isDomainName(Object domainName) {
		return isName(domainName);
	}
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/**
	 * 是否为电站编号
	 * @param sn
	 * @return
	 */
	public static boolean isSn(Object sn) {
		String sns=(String) sn;
		return !isEmpty(sns) && sns.length() < 32;
	}

	/**
	 * 是否是经纬度
	 * @param position
	 * @return
	 */
	public static boolean isPosition(Object position) {
		String ps=(String) position;
		return !isEmpty(ps)&&Pattern.compile("(-|\\+)?(180\\.0{4,6}|(\\d{1,2}|1([0-7]\\d))\\.\\d{4,6})"
				+ ",(-|\\+)?(90\\.0{4,6}|(\\d|[1-8]\\d)\\.\\d{4,6})").matcher(ps).matches();
	}

	public static boolean isStartTime(Object time) {
		return isTime(time);
	}

	public static boolean isEndTime(Object time) {
		return isTime(time);
	}
	
	public static boolean isOnoff(Object pa) {
		return pa.toString().equals("0") || pa.toString().equals("1") || pa.toString().equals("2");
	}
	
	public static boolean isName(Object name){
		String n=(String) name;
		return !isEmpty(n) && n.length() < 32;
	}
	
	public static boolean isTime(Object time) {
		String t=(String) time;
		return !isEmpty(t) && Pattern.compile("^[1-9]\\d{3}||([1-9]\\d{3}(0[1-9]|1[0-2]))||([1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1]))"
				+ "||([1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])(20|21|22|23|[0-1]\\d))$")
				.matcher(t).matches();
	}
	
	public static boolean isFactoryName(Object name){
		return isName(name);
	}
	public static boolean isVersion(Object v){
		String ps=(String) v;
		return !isEmpty(ps)&&Pattern.compile("^\\d{1,2}.\\d{1,2}$").matcher(ps).matches();
	}
	public static boolean isVolume(Object vo){
		Integer v=(Integer) vo;
		return v>=0;
	}
	public static boolean isJoinTime(Object time){
		String t=(String) time;
		return !isEmpty(t) && Pattern.compile("^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d$")
				.matcher(t).matches();
	}
	public static boolean isDescribe(Object string){
		String ss=(String) string;
		return !isEmpty(ss)&&ss.length()<2018;
	}
	public static boolean isRuleId(Object id){
		String idString=(String) id;
		return !isEmpty(idString)&&idString.length()<32 ;
	}
	public static boolean isPrice(Object p){
		Double d=(Double) p;
		return d>=0.0&&d<10000.0;
	}
	public static boolean isIndex(Object index){
		if (index!=null) {
		    String d=index.toString();
		    return Pattern.compile("^[\\d]*$").matcher(d).matches();
		}
		return false;
	}
	public static boolean isPageSize(Object size){
		if (size!=null) {
		    String d=size.toString();
		    return Pattern.compile("^[\\d]*$").matcher(d).matches();
		}
		return false;
	}
	public static boolean isType(Object type){
		return "hour".equals(type)||"day".equals(type)||"month".equals(type)||"year".equals(type);
	}
	
	public static boolean isBuildStatus(Object type){
		return isOnoff(type);
	}
	
	public static boolean isPhone(Object phone){
		return Pattern.compile("^1\\d{10}$").matcher(phone.toString()).matches();
	}
}  