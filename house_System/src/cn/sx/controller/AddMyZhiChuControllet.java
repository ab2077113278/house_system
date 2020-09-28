package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 现金支出添加控制器
 *@Time: 2020/8/31  11:10
 */

import cn.sx.entity.MyJs;
import cn.sx.entity.MyZhiChu;
import cn.sx.service.MyJsService;
import cn.sx.service.MyZhiChuService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myZhiChu/add")
public class AddMyZhiChuControllet extends SystemBaseController{

    private MyZhiChuService myZhiChuService = new MyZhiChuService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);
        int allcount = myZhiChuService.calculationQuantity();
        int allPages =pages.getAllPages(allcount,mypages) ;
        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyZhiChu myZhiChu = new MyZhiChu();
        myZhiChu.setZmoney(Float.valueOf((req.getParameter("zc.zmoney"))));
        myZhiChu.setZtm(req.getParameter("zc.ztm"));
        myZhiChu.setZremark(req.getParameter("zc.zremark"));

        System.out.println("myCus.toString():  "+myZhiChu.toString());
        int i = myZhiChuService.Universal_RUD(myZhiChu);
        ResponseOutput(resp,i+"");
    }
}
