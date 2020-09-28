package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 支出信息实体类
 *@Time: 2020/8/26  19:15
 */

import cn.sx.dao.SystemDao;

public class MyZhiChuDao extends SystemDao {

    private String QuerySqlAll;/*查询全部*/
    private String QuerySqlAllCount;/*计数*/
    private String insertSql;

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT h.ZID,h.ZMONEY,h.ZTM,h.ZREMARK,h.ZTIME,e.EREALNAME  FROM myzhichu h  JOIN myemp e ON e.EID = h.EID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from myzhichu";
    }

    public String getInsertSql(){
        return insertSql = "INSERT INTO  myzhichu(ZID,EID, ZMONEY,ZTM,ZTIME,ZREMARK) VALUE(null,1,?,?,now(),?)";
    }

}
