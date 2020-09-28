package cn.sx.controller;

import cn.sx.common.Constants;
import cn.sx.common.Pages;
import cn.sx.utils.JacksonUtils;
import cn.sx.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-12 15:00
 **/
public class SystemBaseController extends HttpServlet {
    //序列化标识，ID
    protected Long serialVersionUID  = 1000L;
    //分页的工具
    protected Pages pages = new Pages();
    //当前页数
    protected Integer current = Integer.parseInt(Constants.PAGE_COUNT_DEFAULT);
    //页面默认显示10条记录
    protected int mypages= Constants.PAGE_SIZE_DEFAULT;
    //数据库查询的数据,结果集
    protected List reList;

    /**
     * doGet方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    /**
     * 初始化方法
     * @param req
     * @return
     */
    protected Map<String,Object> initData(HttpServletRequest req){
        reList = new ArrayList();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);
        return pageMap;
    }

    /**
     * 响应客户端请求
     * @param resp
     * @throws IOException
     */
    protected void ResponseOutput(HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");

        String jsonStr = JacksonUtils.obj2json(reList);

        System.out.println("jsonStr:  "+jsonStr);

        resp.getWriter().write(jsonStr);
    }

    /**
     * 响应客户端请求
     * @param resp
     * @throws IOException
     */
    protected void ResponseOutput(HttpServletResponse resp , String jsonStr) throws IOException {
        resp.setContentType("application/json;charset=utf-8");

        String obj2json = JacksonUtils.obj2json(jsonStr);

        System.out.println("jsonStr:  "+obj2json);

        resp.getWriter().write(obj2json);
    }
}
