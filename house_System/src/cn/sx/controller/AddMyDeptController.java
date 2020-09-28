package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加部门信息控制器
 *@Time: 2020/8/28  16:15
 */

import cn.sx.entity.MyDept;
import cn.sx.service.MyDeptService;
import cn.sx.utils.NumberUtils;
import cn.sx.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/dept/add")
public class AddMyDeptController extends SystemBaseController{

    /**
     * 房屋类别的业务层实现类
     */
    private MyDeptService myDeptService = new MyDeptService();


    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pname = req.getParameter("pname");

        String pname2 = req.getParameter("dept.pname");
        String premark = req.getParameter("dept.premark");

        if(pname != null){
            getByName(req,resp,pname);
        }
        if(pname2 != null && premark != null){
            insert(req,resp,pname2,premark);
        }
    }

    public void insert(HttpServletRequest req, HttpServletResponse resp,String pname,String premark) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);

        int allcount = myDeptService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyDept myDept = new MyDept();
        myDept.setPremark(premark);
        myDept.setPname(pname);
        myDept.setPflag(Long.valueOf("0"));

        String s = myDeptService.Universal_RUD(myDept)+"";
        ResponseOutput(resp,s);
    }

    public void getByName(HttpServletRequest req, HttpServletResponse resp , String new_pname) throws IOException {
        String jsonStr = "";
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        Object[] objects = new Object[]{new_pname};

        System.out.println("objects[]"+objects.length);

        List<MyDept> list = myDeptService.getByName(pageMap,objects);

        if (list.size() > 0) {
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }

        ResponseOutput(resp,jsonStr);
    }
}
