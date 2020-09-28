package cn.sx.dao.Impl;

import cn.sx.dao.SystemDao;
import org.apache.commons.collections.PredicateUtils;

/**
 * @program: house_System
 * Author sx
 * @desc 收入信息dao实现类
 * @create: 2020-08-25 13:51
 **/
public class MyShouRuDao extends SystemDao {
    private String QuerySqlAll;/*查询全部*/
    private String QuerySqlAllCount;/*计数*/
    private String insertSQL;


    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT h.SID,h.SMONEY,h.STM,h.SREMARK,h.STIME,e.EREALNAME  FROM myshouru h  JOIN myemp e ON e.EID = h.EID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from myshouru";
    }
    public String getInsertSQL(){
        return insertSQL="INSERT INTO myshouru(SID,EID, SMONEY,STM,STIME,SREMARK)VALUE(null,1,?,?,now(),?)";
    }
}
