package cn.sx.dao.Impl;

import cn.sx.dao.SystemDao;

/**
 * @program: house_System
 * Author sx
 * @desc 报损信息dao实现类
 * @create: 2020-08-25 13:51
 **/
public class MyBsDao extends SystemDao {
    private String QuerySqlAll;/*查询全部*/
    private String QuerySqlAllCount;/*计数*/
    private String insertSQL;/*插入*/

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT b.BID,h.HADDRESS,h.HFH,b.BREMARK,b.MTIME,e.EREALNAME  FROM myhouse h JOIN mybs b ON h.hid = b.hid JOIN myemp e ON e.EID = b.EID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mybs";
    }
    public String getInsertSQL(){
        return insertSQL = "INSERT into mybs(BID,HID,MTIME,BREMARK,EID) VALUES(null,?,now(),?,1)";
    }
}
