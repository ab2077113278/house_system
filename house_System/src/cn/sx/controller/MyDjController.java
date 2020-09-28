package cn.sx.controller;

import cn.sx.entity.MyDj;
import cn.sx.service.MyDjServiceImpl;
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
 * @desc 登记入住控制器
 * @create: 2020-08-22 10:40
 **/
@WebServlet("/myDj")
public class MyDjController extends SystemBaseController {
    private MyDjServiceImpl myDjService = new MyDjServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法

        int allcount = myDjService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyDj> list = myDjService.getSelectAll(pageMap , objects);

        System.out.println("list.get(0)   "+list.size());

        MyDj myDj = null;
        for(int i = 0; i<list.size(); i++){
            myDj = list.get(i);
            myDj.setCurrent(current);
            myDj.setAllcount(allcount);
            myDj.setUp(up);
            myDj.setNext(next);
            myDj.setAllpages(allPages);
            reList.add(myDj);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
