package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 添加片区控制器
 *@Time: 2020/8/29  17:01
 */

import cn.sx.entity.MyArea;
import cn.sx.entity.MyJs;
import cn.sx.service.MyAreaService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myArea/add")
public class AddMyAreaController extends SystemBaseController{
    /**
     * 房屋类别的业务层实现类
     */
    private MyAreaService myAreaService = new MyAreaService();


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
        int allcount = myAreaService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyArea myArea = new MyArea();
        myArea.setAname(req.getParameter("area.aname"));
        System.out.println("myArea.toString():  "+myArea.toString());
        String s = myAreaService.Universal_RUD(myArea)+"";
        ResponseOutput(resp,s);
    }
}
