package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 登记入住添加
 *@Time: 2020/8/30  14:16
 */

import cn.sx.entity.MyDj;
import cn.sx.entity.MyHouse;
import cn.sx.service.MyDjServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@WebServlet("/myDj/add")
public class AddMyDjController extends SystemBaseController{
    private MyDjServiceImpl myDjService = new MyDjServiceImpl();

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
        int allcount = myDjService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyDj myDj = new MyDj();
        myDj.setCid(Long.valueOf(req.getParameter("cid")));
        myDj.setHid(Long.valueOf(req.getParameter("hid")));
        myDj.setMyj(Float.valueOf(req.getParameter("myj")));
        myDj.setMyzj(Float.valueOf(req.getParameter("myzj")));
        myDj.setMbegintime(req.getParameter("time"));

//        System.out.println("req.getParameter(\"hid\"):  "+req.getParameter("hid"));

        Object[] arges = new Object[]{myDj.getHid()};

        List<MyDj> myHouseList = myDjService.getMyHouse(null,arges);

//        System.out.println("myHouseList.get(0).getHflag():  "+myHouseList.get(0).getHflag());
        if(myHouseList.get(0).getMflag() == 0){
            myDj.setMflag(Long.valueOf("1"));
        }else {
            myDj.setMflag(Long.valueOf("0"));
        }

        myDj.setEid(Long.valueOf("3"));
        System.out.println("myDj.toString():  "+myDj.toString());
        int i = myDjService.Universal_RUD(myDj);
        ResponseOutput(resp,i+"");
    }
}
