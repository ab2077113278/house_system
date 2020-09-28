package cn.sx.controller;



import cn.sx.entity.MyDept;
import cn.sx.service.MyDeptService;
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
 * Author HLY
 * @desc
 * @create: 2020-08-12 15:39
 **/
@WebServlet("/dept")
public class MyDeptController extends SystemBaseController {
    private MyDeptService myDeptService = new MyDeptService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyDept>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = myDeptService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        System.out.println("pageMap.get(\"currPage\"):"+pageMap.get("currPage"));

        System.out.println("current:"+current);

        Object[] objects = new Object[]{};

        System.out.println(("******:"+(current.intValue()-1)*NumberUtils.getIntegerValue(pageMap.get("pageSize"),1)+"    "+pageMap.get("pageSize")));
        List<MyDept> list = myDeptService.getAllMyDept(pageMap,objects);

        System.out.println(list.size());

        MyDept myDept = null;
        for(int i = 0; i<list.size(); i++){
            myDept = new MyDept();
            myDept.setPname(list.get(i).getPname());
            myDept.setPid(list.get(i).getPid());
            myDept.setPflag(list.get(i).getPflag());
            myDept.setPremark(list.get(i).getPremark());
            myDept.setCurrent(current);
            myDept.setMypages(mypages);
            myDept.setAllcount(allcount);
            myDept.setAllPages(allPages);
            myDept.setUp(up);
            myDept.setNext(next);
            reList.add(myDept);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);
        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
