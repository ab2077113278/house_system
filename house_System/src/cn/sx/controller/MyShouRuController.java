package cn.sx.controller;

import cn.sx.entity.MyShouRu;
import cn.sx.service.MyShouRuServiceImpl;
import cn.sx.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 收入信息控制器
 * @create: 2020-08-23 01:53
 **/
@WebServlet("/myShouRu")
public class MyShouRuController extends SystemBaseController {
    /*实例化对象*/
    private MyShouRuServiceImpl myShouRuService = new MyShouRuServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> pageMap = initData(req); //intiData初始化方法
        /*分页*/
        int allcount = myShouRuService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};;
        List<MyShouRu> list = myShouRuService.getSelectAll(pageMap , objects);

        for(int i = 0; i<list.size(); i++){
            MyShouRu shouRu = list.get(i);
            shouRu.setCurrent(current);
            shouRu.setAllcount(allcount);
            shouRu.setUp(up);
            shouRu.setNext(next);
            shouRu.setAllpages(allPages);
            reList.add(shouRu);
        }
        //响应到客户端
        ResponseOutput(resp);

    }
}
