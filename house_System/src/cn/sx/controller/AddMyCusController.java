package cn.sx.controller;

import cn.sx.entity.MyCus;
import cn.sx.service.MyCusServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 添加客户登记控制器
 * @create: 2020-08-21 16:15
 **/
@WebServlet("/myCus/add")
public class AddMyCusController extends SystemBaseController {

    private MyCusServiceImpl myCusServiceImpl = new MyCusServiceImpl();/*实例化对象*/

    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setCharacterEncoding("utf-8");
            Map<String,Object> pageMap = initData(req);
            /**/
            int allcount = myCusServiceImpl.calculationQuantity();
            int allPages = pages.getAllPages(allcount,mypages);

            current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
            int up = pages.getUp(current);
            int next = pages.getNext(current,allPages);

            MyCus myCus = new MyCus();
            myCus.setCname(req.getParameter("cus.cname"));
            myCus.setCcard(req.getParameter("cus.ccard"));
            myCus.setCsex(req.getParameter("cus.csex"));
            myCus.setCtel(req.getParameter("cus.ctel"));
            myCus.setCtel1(req.getParameter("cus.ctel1"));
            System.out.println("myCus.toString():  "+myCus.toString());
            int i = myCusServiceImpl.Universal_RUD(myCus);
            ResponseOutput(resp,i+"");

    }
}
