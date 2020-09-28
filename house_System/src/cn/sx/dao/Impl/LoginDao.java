package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 用户登录和修改的dao
 *@Time: 2020/8/28  0:12
 */

import cn.sx.dao.SystemDao;

public class LoginDao extends SystemDao {
    /*后去用户*/
    private String  getUser;
    /*更改密码*/
    private String updatePWd;
    /*条件*/
    private String byId;

    public String getGetUser() {
        return getUser = "select EPSW,EID FROM MYEMP where ename = ?";
    }

    public String getById() {
        return byId = "select EPSW FROM MYEMP where eid = ?";
    }

    public String getUpdatePWd() {
        return updatePWd = "update myemp set EPSW = ? where eid = ? ";
    }
}
