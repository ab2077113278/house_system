package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加员信息
 *@Time: 2020/8/30  23:55
 */

import cn.sx.entity.MyArea;
import cn.sx.entity.MyEmp;
import cn.sx.service.MyEmpService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myEmp/add")
public class AddMyEmpController extends SystemBaseController{
    /**
     * 房屋类别的业务层实现类
     */
    private MyEmpService myEmpService = new MyEmpService();


    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        query(req,resp);
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);
        int allcount = myEmpService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyEmp myEmp = new MyEmp();
        myEmp.setEflag("0");
        myEmp.setEremark(req.getParameter("emp.eremark"));
        myEmp.setErealname(req.getParameter("emp.erealname"));
        myEmp.setEtel(req.getParameter("emp.etel"));
        myEmp.setJid(Integer.valueOf(req.getParameter("emp.myjs.jid")));
        myEmp.setEaddress(req.getParameter("emp.eaddress"));
        myEmp.setEpsw(req.getParameter("emp.epsw"));
        myEmp.setEname(req.getParameter("emp.ename"));
        myEmp.setPid(Integer.valueOf(req.getParameter("emp.mydept.pid")));
        System.out.println("myEmp.toString():  "+myEmp.toString());
        String s = myEmpService.Universal_RUD(myEmp)+"";
        ResponseOutput(resp,s);
    }
}
