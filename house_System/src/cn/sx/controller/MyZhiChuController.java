package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 支出信息控制器
 *@Time: 2020/8/26  19:25
 */

import cn.sx.entity.MyZhiChu;
import cn.sx.service.MyZhiChuService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/myZhiChu")
public class MyZhiChuController extends SystemBaseController{
    private MyZhiChuService myZhiChuService =new MyZhiChuService();/*实例化对象*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> pageMap = initData(req); //intiData初始化方法
        /*分页*/
        int allcount = myZhiChuService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MyZhiChu> list = myZhiChuService.getSelectAll(pageMap , objects);

        for(int i = 0; i<list.size(); i++){
            MyZhiChu myZhiChu = list.get(i);
            myZhiChu.setCurrent(current);
            myZhiChu.setAllcount(allcount);
            myZhiChu.setUp(up);
            myZhiChu.setNext(next);
            myZhiChu.setAllpages(allPages);
            reList.add(myZhiChu);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
