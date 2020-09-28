package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MyDj;

/**
 * @program: house_System
 * Author sx
 * @desc 登记入住dao实现类
 * @create: 2020-08-22 10:24
 **/
public class MyDjDao extends BaseDao<MyDj> {
    private String QuerySqlAll;
    private String QuerySqlAllCount;
    private String insertSql;
    private String getMyHouse;

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT d.*,e.ENAME,e.EREALNAME,c.CTEL,c.CNAME,h.HFH,h.HADDRESS FROM mydj d join myemp e on d.EID = e.EID JOIN mycus c on c.CID = d.CID JOIN myhouse h on d.HID = h.HID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mydj";
    }
    public String getInsertSql() {
        return insertSql = "insert mydj (mid,mdate,eid,cid,hid,mimg,myj,myzj,mflag,mbegintime)values (null, now() ,?,?,?,null,?,?,?,?)";
    }

    public String getGetMyHouse() {
        return getMyHouse="select h.*,s.SNAME,a.aname  from myhouse h JOIN mysort s on h.SID = s.SID JOIN myarea a on h.AID = a.AID where h.hid = ?";
    }
}
