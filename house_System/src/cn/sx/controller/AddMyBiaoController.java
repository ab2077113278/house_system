package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加操表记录
 *@Time: 2020/8/31  19:05
 */

import cn.sx.entity.MyBiao;
import cn.sx.service.MyBiaoServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myBiao/add")
public class AddMyBiaoController extends SystemBaseController{
    private MyBiaoServiceImpl myBiaoService = new MyBiaoServiceImpl();
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
        int allcount = myBiaoService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyBiao myBiao = new MyBiao();
        myBiao.setHid(Long.valueOf(req.getParameter("biao.hid")));
        myBiao.setDkd(Long.valueOf(req.getParameter("biao.dkd")));
        myBiao.setSkd(Long.valueOf(req.getParameter("biao.skd")));
        myBiao.setMkd(Long.valueOf(req.getParameter("biao.mkd")));
        System.out.println("myEmp.toString():  "+myBiao.toString());
        String s = myBiaoService.Universal_RUD(myBiao)+"";
        ResponseOutput(resp,s);
    }
}
