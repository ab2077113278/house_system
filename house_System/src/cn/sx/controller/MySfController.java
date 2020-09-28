package cn.sx.controller;

import cn.sx.entity.MySf;
import cn.sx.service.MySfServiceImpl;
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
 * @create: 2020-08-23 01:55
 **/
@WebServlet("/mySf")
public class MySfController extends SystemBaseController {
    private MySfServiceImpl mySfService = new MySfServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法

        int allcount = mySfService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MySf> list = mySfService.getSelectAll(pageMap , objects);

        for(int i = 0; i<list.size(); i++){
            MySf mySf = list.get(i);
            mySf.setCurrent(current);
            mySf.setAllcount(allcount);
            mySf.setUp(up);
            mySf.setNext(next);
            mySf.setAllpages(allPages);
            reList.add(mySf);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
