package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加收入
 *@Time: 2020/8/31  19:43
 */

import cn.sx.entity.MyShouRu;
import cn.sx.service.MyShouRuServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myShouRu/add")
public class AddMyShouRuController extends SystemBaseController{
    private MyShouRuServiceImpl myShouRuService = new MyShouRuServiceImpl();
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
        int allcount = myShouRuService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyShouRu myShouRu = new MyShouRu();
        myShouRu.setSmoney(Float.valueOf(req.getParameter("sr.smoney")));
        myShouRu.setStm(req.getParameter("sr.stm"));
        myShouRu.setSremark(req.getParameter("sr.sremark"));
        System.out.println("myShouRu.toString():  "+myShouRu.toString());
        String s = myShouRuService.Universal_RUD(myShouRu)+"";
        ResponseOutput(resp,s);
    }
}
