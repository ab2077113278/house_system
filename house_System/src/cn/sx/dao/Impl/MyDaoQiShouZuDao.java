package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 到期收租dao
 *@Time: 2020/8/27  16:00
 */

import cn.sx.dao.SystemDao;

public class MyDaoQiShouZuDao extends SystemDao {
    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT m.MID,h.HADDRESS,h.HFH,c.CNAME,c.CTEL,m.MDATE,m.MBEGINTIME FROM mydj m JOIN myhouse h ON m.HID =h.HID JOIN mycus c ON c.CID=m.CID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "SELECT m.MID,h.HADDRESS,h.HFH,c.CNAME,c.CTEL,m.MDATE,m.MBEGINTIME FROM mydj m JOIN myhouse h ON m.HID =h.HID JOIN mycus c ON c.CID=m.CID";
    }
}
