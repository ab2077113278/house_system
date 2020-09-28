package cn.sx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @program: house_System
 * Author sx
 * @desc json工具类
 * @create: 2020-08-14 11:19
 **/
public class JacksonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     *  列表数组转换为json字符串
     * @param object
     * @return
     */
    public static String obj2json(Object object){
        try {
            return objectMapper.writeValueAsString(object); //writeValueAsString 将Java对象转换成json对象并返回json对象
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
