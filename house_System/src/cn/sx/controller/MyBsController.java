package cn.sx.controller;

import cn.sx.entity.MyBs;
import cn.sx.service.MyBsServiceImpl;
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
 * @desc 报损信息控制器
 * @create: 2020-08-23 01:53
 **/
@WebServlet("/myBs")
public class MyBsController extends SystemBaseController {
    /*实例化对象*/
    private MyBsServiceImpl myBsService = new MyBsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法
        /*分页*/
         int allcount = myBsService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MyBs> list = myBsService.getSelectAll(pageMap , objects);

//        System.out.println("list.get(0)   "+list.get(0).toString());

        for(int i = 0; i<list.size(); i++){
            MyBs myBs = list.get(i);
            myBs.setCurrent(current);
            myBs.setAllcount(allcount);
            myBs.setUp(up);
            myBs.setNext(next);
            myBs.setAllpages(allPages);
            reList.add(myBs);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
