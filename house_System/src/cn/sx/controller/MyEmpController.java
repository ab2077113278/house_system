package cn.sx.controller;

import cn.sx.entity.MyDept;
import cn.sx.entity.MyEmp;
import cn.sx.service.MyEmpService;
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
 * @desc
 * @create: 2020-08-12 15:39
 **/
@WebServlet("/myEmp")
public class MyEmpController extends SystemBaseController {
    private MyEmpService myEmpService = new MyEmpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyDept>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myEmpService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyEmp> list = myEmpService.getSelectAll(pageMap);


        MyEmp myEmp = null;
        for(int i = 0; i<list.size(); i++){
            myEmp = new MyEmp();
            myEmp.setEaddress(list.get(i).getEaddress());
            myEmp.setEflag(list.get(i).getEflag());
            myEmp.setEid(list.get(i).getEid());
            myEmp.setErealname(list.get(i).getErealname());
            myEmp.setEtel(list.get(i).getEtel());
            myEmp.setJname(list.get(i).getJname());
            myEmp.setEaddress(list.get(i).getEremark());
            myEmp.setEpsw(list.get(i).getEpsw());
            myEmp.setPname(list.get(i).getPname());
            myEmp.setEname(list.get(i).getEname());

            myEmp.setCurrent(current);
            myEmp.setMypages(mypages);
            myEmp.setAllcount(allcount);
            myEmp.setUp(up);
            myEmp.setNext(next);
            myEmp.setAllPages(allPages);
            reList.add(myEmp);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);
        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
