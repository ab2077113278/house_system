package cn.sx.controller;

import cn.sx.entity.MyArea;
import cn.sx.service.MyAreaService;
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
 * @desc 片区信息控制器
 * @create: 2020-08-12 15:39
 **/
@WebServlet("/myArea")
public class MyAreaController extends SystemBaseController {
    private MyAreaService myDeptService = new MyAreaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyArea>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myDeptService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyArea> list = myDeptService.getSelectAll(pageMap);

        System.out.println(list.size());

        MyArea myArea = null;
        for(int i = 0; i<list.size(); i++){
            myArea = new MyArea();
            myArea.setAid(list.get(i).getAid());
            myArea.setAname(list.get(i).getAname());
            myArea.setCurrent(current);
            myArea.setMypages(mypages);
            myArea.setAllcount(allcount);
            myArea.setUp(up);
            myArea.setNext(next);
            myArea.setAllPages(allPages);
            reList.add(myArea);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);

        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);

        resp.getWriter().write(jsonStr);
    }
}
