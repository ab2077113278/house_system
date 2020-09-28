package cn.sx.controller;

import cn.sx.entity.MyArea;
import cn.sx.entity.MyCus;
import cn.sx.service.MyCusServiceImpl;
import cn.sx.utils.JacksonUtils;
import cn.sx.utils.NumberUtils;
import cn.sx.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 客户信息实现类控制器
 * @create: 2020-08-21 16:15
 **/
@WebServlet("/myCus")
public class MyCusController extends SystemBaseController {


    private MyCusServiceImpl myCusServiceImpl = new MyCusServiceImpl();/*实例化对象*/


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyCus>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myCusServiceImpl.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyCus> list = myCusServiceImpl.getSelectAll(pageMap);

        System.out.println(list.size());

        MyCus myCus = null;
        for(int i = 0; i<list.size(); i++){
            myCus = list.get(i);
            myCus.setCurrent(current);
            myCus.setAllcount(allcount);
            myCus.setUp(up);
            myCus.setNext(next);
            myCus.setAllpages(allPages);
            reList.add(myCus);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);

        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);

        resp.getWriter().write(jsonStr);
    }
}
