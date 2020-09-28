package cn.sx.controller;

import cn.sx.entity.MyBiao;
import cn.sx.entity.MyDept;
import cn.sx.service.MyBiaoServiceImpl;
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

/**
 * @program: house_System
 * Author sx
 * @desc 操表记录控制器
 * @create: 2020-08-23 01:53
 **/
@WebServlet("/myBiao")
public class MyBiaoController extends SystemBaseController {
    /*实例化对象*/
    private MyBiaoServiceImpl myBiaoService = new MyBiaoServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jsonStr = "";
        reList = new ArrayList<MyBiao>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myBiaoService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyBiao> list = myBiaoService.getSelectAll(pageMap);


        for(int i = 0; i<list.size(); i++){
            MyBiao myBiao = list.get(i);
            myBiao.setCurrent(current);
            myBiao.setAllcount(allcount);
            myBiao.setUp(up);
            myBiao.setNext(next);
            myBiao.setAllpages(allPages);
            reList.add(myBiao);
        }
        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);
        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
