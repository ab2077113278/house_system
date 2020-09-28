package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 用户登录和修改service
 *@Time: 2020/8/28  0:15
 */

import cn.sx.dao.Impl.LoginDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyEmp;

import java.util.List;
import java.util.Map;

public class LoginService   {

    /*实例化对象*/
    private LoginDao loginDao = new LoginDao();

    public List<MyEmp> getSelectAll(Map<String,Object> pageMap, Object... objs ){
        return loginDao.queryBaserecords(loginDao.getGetUser(),pageMap,MyEmp.class,objs);
    }

    public  List<MyEmp> getById(Map<String,Object> pageMap, Object... objs ){
        return loginDao.queryBaserecords(loginDao.getById(),pageMap,MyEmp.class,objs);
    }

    public boolean update(Object... objs){
        return loginDao.Universal_RUD(loginDao.getUpdatePWd(),objs);
    }


}
