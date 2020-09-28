package cn.sx.controller;

import cn.sx.entity.MyTf;
import cn.sx.service.MyTfServiceImpl;
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
 * @create: 2020-08-23 01:53
 **/
@WebServlet("/myTf")
public class MyTfController extends SystemBaseController {
    private MyTfServiceImpl myTfService = new MyTfServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法

        int allcount = myTfService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MyTf> list = myTfService.getSelectAll(pageMap , objects);

//        System.out.println("list.get(0)   "+list.get(0).toString());

        MyTf myTf = null;
        for(int i = 0; i<list.size(); i++){
            myTf = list.get(i);
            myTf.setCurrent(current);
            myTf.setAllcount(allcount);
            myTf.setUp(up);
            myTf.setNext(next);
            myTf.setAllpages(allPages);
            reList.add(myTf);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
