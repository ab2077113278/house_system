package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加登记报损控制器
 *@Time: 2020/8/31  9:49
 */

import cn.sx.entity.MyBs;
import cn.sx.service.MyBsServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myBs/add")
public class AddMyBsController extends SystemBaseController{

    private MyBsServiceImpl myBsService = new MyBsServiceImpl();/*实例化对象*/

    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);
        /**/
        int allcount = myBsService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyBs myBs = new MyBs();
        myBs.setHid(Long.valueOf(req.getParameter("bs.hid")));
        myBs.setBremark(req.getParameter("bs.bremark"));

        System.out.println("myCus.toString():  "+myBs.toString());
        int i = myBsService.Universal_RUD(myBs);
        ResponseOutput(resp,i+"");

    }
}
