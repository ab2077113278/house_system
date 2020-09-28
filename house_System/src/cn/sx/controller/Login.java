package cn.sx.controller;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 用户登录和修改密码
 *@Time: 2020/8/27  20:21
 */

import cn.sx.entity.MyEmp;
import cn.sx.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class Login extends SystemBaseController {
    /*实例化对象*/
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);

        /*//从ServletContext域中获得 保存用户信息集合:
        List<User> list = (List<User>) this. getServletContext() . getAttribute("list");
        for(User user : list){
        //判断用户名是否正确:
            if(username . equals(user . getUserName())){
                //用户名正确
                if(password.equals(user.getPassword())){
                    //密码也正确
                    //登录成功
                    //将用户的信息保存到session中
                    req.getSession().setAttribute("user",user);
                    resp.sendRedirect("http://localhost:8081/web_example_war_exploded/main/main.html");//跳转到主界面
                    return;
                }
            }
        }
        //登录失败yong
        req.setAttribute("msg","用户名或者密码错误");

        req.getRequestDispatcher("http://localhost:8081/web_example_war_exploded/index.html").forward(req,resp);
*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*获取参数*/
        String ename = req.getParameter("ename");
        String emp_ename = req.getParameter("emp.ename");
        String emp_epsw = req.getParameter("emp.epsw");

        String oldpsw = req.getParameter("oldpsw");
        String newpsw = req.getParameter("newpsw");

        /*判断用户名是否为空*/
        if ( ename != null ) {
            Login(req, resp, ename);
        }
        /*判断用户名和密码是否为空*/
        if (emp_ename != null && emp_epsw != null) {
            Login(req, resp, emp_ename, emp_epsw);
        }
        /*判断旧密码是否为空*/
        if (oldpsw != null ) {
            /*将数据存储在session中并根据id*/
            Login(req, resp, oldpsw, Long.valueOf(req.getSession().getAttribute("EID").toString()));
        }
        /*判断旧密码和新密码*/
        if(oldpsw == null && newpsw != null){
            update(req,resp,newpsw);/*修改密码为新密码*/
        }

    }


    public void Login(HttpServletRequest req, HttpServletResponse resp, String oldpsw, Long Eid) throws IOException {
        String json = "";

        List<MyEmp> list = loginService.getById(null, Eid);
        if (list.get(0).getEpsw().equals(oldpsw)) {
            json = list.get(0).getEpsw();
            ResponseOutput(resp, json);
        }
        ResponseOutput(resp, json);
    }
    public void Login(HttpServletRequest req, HttpServletResponse resp, String emp_ename, String emp_epsw) throws IOException {

        List<MyEmp> list = loginService.getSelectAll(null, emp_ename);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEpsw().equals(emp_epsw)) {
//                System.out.println("list.get(i).getEid() " + list.get(i).getEid());
                req.getSession().setAttribute("EID", list.get(i).getEid());
                ResponseOutput(resp, "1");
                return;
            }
        }
        ResponseOutput(resp, "0");
    }


    public void Login(HttpServletRequest req, HttpServletResponse resp, String ename) throws IOException {
        Object[] objects = new Object[1];
        objects[0] = ename;
        List<MyEmp> list = loginService.getSelectAll( null, objects);
        ResponseOutput(resp, list.size() + "");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp, String newpsw) throws IOException {
        Object[] objects = new Object[]{newpsw, req.getSession().getAttribute("EID")};
        if (loginService.update(objects)) {
            ResponseOutput(resp, "1");
        } else {
            ResponseOutput(resp, "0");
        }
    }
}
