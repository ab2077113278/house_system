package cn.sx.dao.Impl;

import cn.sx.dao.SystemDao;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-25 13:51
 **/
public class MyBiaoDao extends SystemDao {
    private String QuerySqlAll;
    private String QuerySqlAllCount;
    private String insertSql;

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT b.BID,h.HADDRESS,h.HFH,b.DKD,b.SKD,b.MKD,b.MTIME,e.EREALNAME  FROM myhouse h JOIN mybiao b ON h.hid = b.hid JOIN myemp e ON e.EID = b.EID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mybiao";
    }

    public String getInsertSql(){
        return insertSql="INSERT INTO mybiao(BID,HID,DKD,SKD,MKD,MTIME,EID)VALUE(null,?,?,?,?,now(),1)";
    }

}
