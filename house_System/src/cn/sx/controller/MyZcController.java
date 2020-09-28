package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 租房政控制器策
 *@Time: 2020/8/28  16:00
 */

import cn.sx.entity.MyZc;
import cn.sx.service.MyZcService;
import cn.sx.utils.JacksonUtils;
import cn.sx.utils.NumberUtils;
import cn.sx.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@WebServlet("/myZc")
public class MyZcController extends SystemBaseController{
    private MyZcService myZcService = new MyZcService();/*实例化对象*/


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> pageMap = initData(req);

        int allcount = myZcService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyZc> list = myZcService.getSelectAll(pageMap);

        for(int i = 0; i<list.size(); i++){
            MyZc myZc = list.get(i);
            myZc.setCurrent(current);
            myZc.setAllcount(allcount);
            myZc.setUp(up);
            myZc.setNext(next);
            myZc.setAllpages(allPages);
            reList.add(myZc);
        }

        //响应到客户端
        ResponseOutput(resp);


    }
}
