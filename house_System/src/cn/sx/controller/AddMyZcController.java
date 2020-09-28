package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 增加政策信息控制器
 *@Time: 2020/8/28  16:52
 */

import cn.sx.entity.MyZc;
import cn.sx.service.MyZcService;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/myZc/add")
public class AddMyZcController extends SystemBaseController {
    private MyZcService myZcService = new MyZcService();/*实例化对象*/

    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ctitle = req.getParameter("zc.ctitle");
        String content = req.getParameter("content");
        if(ctitle != null && content != null){
            insert(req,resp,ctitle,content);
        }
    }

    public void insert(HttpServletRequest req, HttpServletResponse resp , String ctitle , String content) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        Map<String,Object> pageMap = initData(req);
        int allcount = myZcService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        MyZc myZc = new MyZc();
        myZc.setCtime("now()");
        myZc.setCtitle(ctitle);
        myZc.setCremark(content);
        String s = "";
        if(myZcService.Universal_RUD(myZc) == 1){
            s = "添加成功！！！";
        }else {
            s = "失败！！！";
        }
        ResponseOutput(resp,s);
    }
}
