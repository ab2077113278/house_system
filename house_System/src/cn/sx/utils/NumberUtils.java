package cn.sx.utils;

/**
 * @program: house_System
 * Author sx
 * @desc 数字工具类
 * @create: 2020-08-14 10:39
 **/
public class NumberUtils {
    /**
     *
     * @param num 数字
     * @return 字符串，如果num为空，返回空字符串
     */
    public static String num2Str(Object num){
            if(num == null){
                return "";
            }else {
                return String.valueOf(num);
            }
    }

    public static  Integer getInteger(Object obj,int def){
        String str = obj == null ? "":obj.toString();

        Integer i = null;

        if(str.trim().length() == 0){
            i = new Integer(def);
        } else {
            i = Integer.valueOf(str);
        }
        return  i == null ? new Integer(def) : i;
    }

    /**
     *
     * @param object 字符串
     * @param def 默认值
     * @return Integer,字符串为null时返回def
     */
    public static  int getIntegerValue(Object object , int def){
        return getInteger(object , def).intValue();
    }


}
