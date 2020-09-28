package cn.sx.controller;

import cn.sx.entity.MyArea;
import cn.sx.entity.MySort;
import cn.sx.service.MySortService;
import cn.sx.utils.JacksonUtils;
import cn.sx.utils.NumberUtils;
import cn.sx.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 房屋类别控制器
 * @program: house_System
 * Author sx
 * @desc 房屋类别控制器
 **/
@WebServlet("/mySort")
public class MySortController extends SystemBaseController {

    /**
     * 房屋类别的业务层实现类
     */
    private MySortService mySortService = new MySortService();


    /**
     * doPost()方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonStr = "";
        reList = new ArrayList<MyArea>();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);

        int allcount = mySortService.calculationQuantity();
        int allPages = pages.getAllPages(allcount,mypages);

        current = NumberUtils.getIntegerValue(pageMap.get("currPage"),1);
        int up = pages.getUp(current);
        int next = pages.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MySort> list = mySortService.getSelectAll(pageMap);

        MySort mySort = null;
        for(int i = 0; i<list.size(); i++){
            mySort = new MySort();
            mySort.setSid(list.get(i).getSid());
            mySort.setSname(list.get(i).getSname());
            mySort.setCurrent(current);
            mySort.setAllcount(allcount);
            mySort.setUp(up);
            mySort.setNext(next);
            mySort.setAllpages(allPages);
            reList.add(mySort);
        }

        resp.setContentType("application/json;charset=utf-8");

        jsonStr = JacksonUtils.obj2json(reList);

        String result = "jsonStr"+jsonStr;
        System.out.println("jsonStr"+jsonStr);

        resp.getWriter().write(jsonStr);
    }
}
