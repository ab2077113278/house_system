package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MySort;

/**
 * 房屋类别持久层
 * @program: house_System
 * Author sx
 * @desc 房屋类别
 *
 **/
public class MySortDao extends BaseDao<MySort> {
    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll() {
        return QuerySqlAll = "Select * from mysort";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mysort";
    }
}
