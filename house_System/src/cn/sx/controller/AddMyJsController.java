package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加岗位控制器
 *@Time: 2020/8/29  12:27
 */

import cn.sx.entity.MyJs;
import cn.sx.service.MyJsService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myJs/add")
public class AddMyJsController extends SystemBaseController{

    private MyJsService myJsService = new MyJsService();

    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        query(req,resp);
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);
        int allcount = myJsService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyJs myJs = new MyJs();
        myJs.setJname(req.getParameter("js.jname"));
        System.out.println("myJs.toString():  "+myJs.toString());
        String s = myJsService.Universal_RUD(myJs)+"";
        ResponseOutput(resp,s);
    }
}
