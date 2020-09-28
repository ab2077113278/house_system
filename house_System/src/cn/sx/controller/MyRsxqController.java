package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 房屋出租分类查询控制器
 *@Time: 2020/8/27  8:54
 */

import cn.sx.entity.MyRsxq;
import cn.sx.service.MyRsxqService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/myRsxq")
public class MyRsxqController extends SystemBaseController{
    /*初始化对象*/
    private MyRsxqService myRsxqService = new MyRsxqService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> pageMap = initData(req); //intiData初始化方法

        /*接受参数*/
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        String zt = req.getParameter("zt");
        String where = "Where ";

        /*判断*/
       if(!aid.equals("0")){
            where += "a.aid = "+aid;
            if(!sid.equals("0")){
                where += " and "+" s.sid = "+sid ;
                if(!zt.equals("-1")){
                    where += " and "+" HFLAG = "+zt;
                }
            }else {
                if(!zt.equals("-1")){
                    where += " and "+" HFLAG = "+zt;
                }
            }
        }else {
            if(!sid.equals("0")){
                where +=  " s.sid = "+sid;

                if(!zt.equals("-1")){
                    where += " and "+" HFLAG = "+zt;
                }

            }else {
                if(!zt.equals("-1")){
                    where += " HFLAG = "+zt;
                }else {
                    where = "";
                }
            }
        }

        Object[] objects = new Object[]{};
        int allcount = myRsxqService.calculationQuantity(where,objects);
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        List<MyRsxq> list = myRsxqService.getSelectAll(pageMap,where );

        MyRsxq myRsxq = new MyRsxq();

        for(int i = 0; i<list.size(); i++){
            myRsxq = list.get(i);
            myRsxq.setCurrent(current);
            myRsxq.setAllcount(allcount);
            myRsxq.setUp(up);
            myRsxq.setNext(next);
            myRsxq.setAllpages(allPages);
            reList.add(myRsxq);
        }

        if (list.size() == 0){
            myRsxq.setCurrent(0);
            myRsxq.setAllcount(0);
            myRsxq.setUp(0);
            myRsxq.setNext(0);
            myRsxq.setAllpages(0);
            reList.add(myRsxq);
        }
        //响应到客户端
        ResponseOutput(resp);

    }

}
