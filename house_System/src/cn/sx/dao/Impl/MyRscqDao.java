package cn.sx.dao.Impl;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房费用收入查询dao
 *@Time: 2020/8/27  8:48
 */

import cn.sx.dao.SystemDao;

public class MyRscqDao extends SystemDao {
    private String QuerySqlAll;/*查询条件*/
    private String QuerySqlAllCount;/*计数*/

    public String getQuerySqlAll(String where) {
        return QuerySqlAll = "select h.HID,h.HADDRESS,h.HFH,h.HHX,h.HMJ,h.HCX,h.HMONEY,h.HFLAG,s.SNAME,a.ANAME  from myhouse h  join mysort s on s.SID = h.SID join myarea a on a.AID = h.AID    "+where;
    }

    public String getQuerySqlAllCount(String where) {
        return QuerySqlAllCount = "select h.HID,h.HADDRESS,h.HFH,h.HHX,h.HMJ,h.HCX,h.HMONEY,h.HFLAG,s.SNAME,a.ANAME  from myhouse h  join mysort s on s.SID = h.SID join myarea a on a.AID = h.AID    "+where;
    }
}
