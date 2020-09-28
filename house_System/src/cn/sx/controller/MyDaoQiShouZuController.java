package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 到期收租控制器
 *@Time: 2020/8/27  16:27
 */

import cn.sx.entity.MyDaoQiShouZu;
import cn.sx.service.MyDaoQiShouZuService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/myDaoQiShouZu")
public class MyDaoQiShouZuController extends SystemBaseController{
    private MyDaoQiShouZuService myDaoQiShouZuService =new MyDaoQiShouZuService();/*实例化对象*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> pageMap = initData(req); //intiData初始化方法
        /*分页*/
        int allcount = myDaoQiShouZuService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MyDaoQiShouZu> list = myDaoQiShouZuService.getSelectAll(pageMap , objects);

        for(int i = 0; i<list.size(); i++){
            MyDaoQiShouZu myDaoQiShouZu = list.get(i);
            myDaoQiShouZu.setCurrent(current);
            myDaoQiShouZu.setAllcount(allcount);
            myDaoQiShouZu.setUp(up);
            myDaoQiShouZu.setNext(next);
            myDaoQiShouZu.setAllpages(allPages);
            reList.add(myDaoQiShouZu);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
