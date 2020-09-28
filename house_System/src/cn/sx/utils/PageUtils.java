package cn.sx.utils;

import cn.sx.common.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: house_System
 * Author sx
 * @desc 分页工具类
 * @create: 2020-08-14 10:52
 **/
public class PageUtils {

    /**
     *
     * @param httpServletRequest 构造分页参数
     *
     */
    public static Map<String,Object> getPageParams(HttpServletRequest httpServletRequest){
        int pageSize = Constants.PAGE_SIZE_DEFAULT;
        int currPage = NumberUtils.getIntegerValue(Constants.PAGE_COUNT_DEFAULT,1);
        int sid = 2;

        String currentPage = httpServletRequest.getParameter("current"); //当前页

//        System.out.println("currentPage  "+currentPage);

        if(!SystemStringUtils.isEmpty(currentPage)){
            currPage = NumberUtils.getIntegerValue(currentPage,1);
//            System.out.println("currPage: "+currPage);
        }



        Object currentPageSize = httpServletRequest.getParameter("limit");//当前显示多少条记录
        if(!SystemStringUtils.isEmpty(currentPageSize)){
            pageSize = NumberUtils.getIntegerValue(currentPageSize,Constants.PAGE_SIZE_DEFAULT);
        }

        Object currentsid = httpServletRequest.getParameter("sid");//获取当前房屋类别id
        if(!SystemStringUtils.isEmpty(currentPageSize)){
            sid = NumberUtils.getIntegerValue(currentsid,2);
        }

//        System.out.println("currentsid:   "+currentsid);

        //构造分页参数
        Map<String,Object> param = new ConcurrentHashMap<>();
        param.put("currPage",currPage);
        param.put("pageSize",pageSize);
        param.put("start",(currPage-1) * pageSize);
        param.put("sid",sid);
        return param;
    }
}
