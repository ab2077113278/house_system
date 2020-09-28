package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房费用收入查询
 *@Time: 2020/8/27  9:24
 */

import cn.sx.entity.MyRsci;
import cn.sx.service.MyRsciService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/myRsci")
public class MyRsciController extends SystemBaseController{

    /*实例化对象*/
    private MyRsciService myRsciService = new MyRsciService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> pageMap = initData(req); //intiData初始化方法
        /*接受参数*/
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        String hid = req.getParameter("hid");
        /*定义条件变量*/
        String where = "Where ";

        /*判断*/
        if(!aid.equals("0")){
            where += "aid = "+aid;

            if(!sid.equals("0")){
                where += " and "+" sid = "+sid ;

                if(!hid.equals("-1")){
                    where += " and "+" h.hid = "+hid;
                }

            }else {
                if(!hid.equals("-1")){
                    where += " and "+" h.hid = "+hid;
                }
            }
        }else {
            if(!sid.equals("0")){
                where +=  "sid = "+sid;

                if(!hid.equals("-1")){
                    where += " and "+" h.hid = "+hid;
                }

            }else {
                if(!hid.equals("-1")){
                    where += " h.hid = "+hid;
                }else {
                    where = "";
                }
            }
        }

        Object[] objects = new Object[]{};
        /*分页*/
        int allcount = myRsciService.calculationQuantity(where,objects);
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        List<MyRsci> list = myRsciService.getSelectTiaoJian(pageMap,where ,objects);

        MyRsci myRsci = new MyRsci();
        for(int i = 0; i<list.size(); i++){
            myRsci = list.get(i);
            myRsci.setCurrent(current);
            myRsci.setAllcount(allcount);
            myRsci.setUp(up);
            myRsci.setNext(next);
            myRsci.setAllpages(allPages);
            reList.add(myRsci);
        }

        if (list.size() == 0){
            myRsci.setCurrent(0);
            myRsci.setAllcount(0);
            myRsci.setUp(0);
            myRsci.setNext(0);
            myRsci.setAllpages(0);
            reList.add(myRsci);
        }

        //响应到客户端
        ResponseOutput(resp);
    }
}
