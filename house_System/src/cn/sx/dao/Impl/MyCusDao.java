package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MyCus;

/**
 * @program: house_System
 * Author sx
 * @desc 客户信息实现类
 * @create: 2020-08-21 16:08
 **/
public class MyCusDao extends BaseDao<MyCus> {
    private String QuerySqlAll;/*查询全部sql语句*/
    private String QuerySqlAllCount;/*计数*/
    private String insertSql;/*插入*/

    /*查询全部方法*/
    public String getQuerySqlAll() {
        return QuerySqlAll = "Select * from mycus";
    }

    /*计数方法a*/
    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mycus";
    }

    /*插入数据方法*/
    public String getInsertSql() {
        return insertSql = "insert mycus (CNAME,CSEX,CTEL,CTEL1,CCARD)values (?,?,?,?,?)";
    }
}
