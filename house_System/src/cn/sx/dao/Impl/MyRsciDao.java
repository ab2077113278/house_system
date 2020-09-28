package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房费用查询dao
 *@Time: 2020/8/27  9:19
 */

import cn.sx.dao.SystemDao;

public class MyRsciDao extends SystemDao {
    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll(String where) {
        return QuerySqlAll = "SELECT s.MID, h.HADDRESS,h.HFH,c.CNAME,c.CTEL,e.EREALNAME,d.MDATE,d.MYJ,d.MYZJ,s.MYZJ,d.MFLAG  FROM myhouse h JOIN mydj d ON d.HID = h.HID  JOIN mysf s ON s.MID = d.MID JOIN mycus c ON c.CID = d.CID JOIN myemp  e ON e.EID = s.EID"+where;
    }

    public String getQuerySqlAllCount(String where) {
        return QuerySqlAllCount = "SELECT s.MID, h.HADDRESS,h.HFH,c.CNAME,c.CTEL,e.EREALNAME,d.MDATE,d.MYJ,d.MYZJ,s.MYZJ,d.MFLAG  FROM myhouse h JOIN mydj d ON d.HID = h.HID  JOIN mysf s ON s.MID = d.MID JOIN mycus c ON c.CID = d.CID JOIN myemp  e ON e.EID = s.EID"+where;
    }
}
