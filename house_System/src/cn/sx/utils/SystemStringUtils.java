package cn.sx.utils;

import org.springframework.util.StringUtils;

/**
 * @program: house_System
 * Author sx
 * @desc 操作字符串日常操作的类
 * @create: 2020-08-06 20:27
 **/
public class SystemStringUtils extends StringUtils {

    /**
     *
     * @param s 截取的字符串要
     * @param position 起始位置
     * @param number 截取数量
     * @return
     */
    public static String stringIntercept(String s ,int position , int number){
        return s.substring(position,number);
    }

    /**
     *
     * @param s 截取的字符串
     * @param position 截取位置
     * @return
     */
    public static String stringIntercept(String s ,int position){
        return s.substring(position);
    }

    /**
     * 打印输出到控制台
     * @param o
     */
    public void outputString(Object o){
        System.out.println(o);
    }

    /**
     * 大写转换成小写
     * @param str
     * @return
     */
    public static String convertString(String str) {
        String upStr = str.toUpperCase();
        String LowStr = str.toLowerCase();
        StringBuffer buf = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == upStr.charAt(i)) {
                buf.append(LowStr.charAt(i));
            } else {
                buf.append(upStr.charAt(i));
            }
        }
        return buf.toString();
    }

}
