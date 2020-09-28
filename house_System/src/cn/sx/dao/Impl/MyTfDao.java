package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MyTf;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-23 01:47
 **/
public class MyTfDao extends BaseDao<MyTf> {
    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll() {
        return QuerySqlAll = "SELECT t.MID,h.HADDRESS,h.HFH,c.CNAME,c.CTEL,d.MDATE,d.MBEGINTIME from mydj d JOIN mytf t on d.MID = t.MID JOIN mycus c on c.CID = d.CID join myhouse h on h.HID = d.HID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mytf";
    }
}
