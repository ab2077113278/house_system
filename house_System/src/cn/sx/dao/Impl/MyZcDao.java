package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 租房政策dao
 *@Time: 2020/8/28  15:53
 */

import cn.sx.dao.SystemDao;

public class MyZcDao extends SystemDao {
    private String QuerySqlAll;/*查询全部sql语句*/
    private String QuerySqlAllCount;/*计数*/
    private String insertSql;/*插入*/

    /*查询全部方法*/
    public String getQuerySqlAll() {
        return QuerySqlAll = "Select * from myzc";
    }

    /*计数方法a*/
    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from myzc";
    }

    /*插入数据方法*/
    public String getInsertSql() {
        return insertSql = "insert myzc (CTITLE,CTIME,CREMARK)values (?,?,?)";
    }


}
