package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 房屋类别添加
 *@Time: 2020/8/31  0:15
 */

import cn.sx.entity.MyCus;
import cn.sx.entity.MySort;
import cn.sx.service.MyCusServiceImpl;
import cn.sx.service.MySortService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/mySort/add")
public class AddMySortController extends SystemBaseController{


    /**
     * 房屋类别的业务层实现类
     */
    private MySortService mySortService = new MySortService();


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
        int allcount = mySortService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MySort mySort = new MySort();
        mySort.setSname(req.getParameter("sort.sname"));
        System.out.println("mySort.toString():  "+mySort.toString());
        String s = mySortService.Universal_RUD(mySort)+"";
        ResponseOutput(resp,s);
    }
}
