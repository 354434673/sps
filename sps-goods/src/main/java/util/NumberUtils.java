package util;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO class purpose description
 *
 * @author zhangweidong
 * @version 1.0 Revise History:
 */
public class NumberUtils {

    /**
     * 把String数据转换成Long类型数组
     *
     * @param array
     * @return
     */
    public static Long[] convertStringArrayToLong(String[] array) {
        List<Long> list = new ArrayList<Long>();
        for (String num : array) {
            if (num != null && !num.trim().equals("")) {
                list.add(Long.parseLong(num));
            }

        }
        return list.toArray(new Long[list.size()]);
    }



    /**
     * 把String数据转换成List<Long>
     *
     * @param array
     * @return
     */
    public static List<Long> convertStringArrayToList(String[] array) {
        List<Long> list = new ArrayList<Long>();
        for (String num : array) {
            if (num != null && !num.trim().equals("")) {
                list.add(Long.parseLong(num));
            }

        }
        return list;
    }



    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,2);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String numberFormat(double num, int degree) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.setMaximumFractionDigits(degree);
        return df.format(num);
    }


    public static String random(int length){
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<length;i++){
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }




    public static String getRandomNumber(Integer limit){
        String no = "";
        int num[] = new int[limit];
        int c = 0;
        for (int i = 0; i < limit; i++) {
            num[i] = new Random().nextInt(10);
            c = num[i];
            for (int j = 0; j < i; j++) {
                if (num[j] == c) {
                    i--;
                    break;
                }
            }
        }
        if (num.length > 0) {
            for (int i = 0; i < num.length; i++) {
                no += num[i];
            }
        }
        return no;
    }
}
