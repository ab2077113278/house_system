package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MySf;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-23 01:47
 **/
public class MySfDao extends BaseDao<MySf> {
    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll() {
        return QuerySqlAll = "select s.MID,h.HADDRESS,h.HFH,c.CNAME,c.CTEL,d.MDATE,d.MBEGINTIME from mysf s join mydj d on s.MID = d.MID JOIN mycus c on c.CID = d.CID JOIN myhouse h on h.HID = d.HID";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from mysf";
    }
}
