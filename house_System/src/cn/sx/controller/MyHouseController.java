package cn.sx.controller;

import cn.sx.entity.MyHouse;
import cn.sx.service.MyHouseServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-20 16:06
 **/
@WebServlet("/myHouse")
public class MyHouseController extends SystemBaseController {
    private MyHouseServiceImpl myHourseService = new MyHouseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法

        int allcount = myHourseService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{pageMap.get("sid")};;
        List<MyHouse> list = myHourseService.getSelectAll(pageMap , objects);

//        System.out.println("list.get(0)   "+list.get(0).toString());

        MyHouse myHouse = null;
        for(int i = 0; i<list.size(); i++){
            myHouse = list.get(i);
            myHouse.setCurrent(current);
            myHouse.setAllcount(allcount);
            myHouse.setUp(up);
            myHouse.setNext(next);
            myHouse.setAllpages(allPages);
            reList.add(myHouse);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
