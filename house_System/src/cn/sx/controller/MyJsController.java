package cn.sx.controller;

import cn.sx.entity.MyDept;
import cn.sx.entity.MyJs;
import cn.sx.service.MyJsService;
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
 * @desc 岗位信息控制器
 * @create: 2020-08-12 15:39
 **/
@WebServlet("/myJs")
public class MyJsController extends SystemBaseController {
    private MyJsService myJsService = new MyJsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyDept>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myJsService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyJs> list = myJsService.getSelectAll(pageMap);

        System.out.println(list.size());

        MyJs myJs = null;
        for(int i = 0; i<list.size(); i++){
            myJs = new MyJs();
            myJs.setJid(list.get(i).getJid());
            myJs.setJname(list.get(i).getJname());

            myJs.setCurrent(current);
            myJs.setMypages(mypages);
            myJs.setAllcount(allcount);
            myJs.setUp(up);
            myJs.setNext(next);
            myJs.setAllPages(allPages);
            reList.add(myJs);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);
        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
