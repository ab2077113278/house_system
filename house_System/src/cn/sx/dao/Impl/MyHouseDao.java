package cn.sx.dao.Impl;

import cn.sx.dao.BaseDao;
import cn.sx.entity.MyHouse;

/**
 * @program: house_System
 * Author sx
 * @desc 房屋资料
 * @create: 2020-08-20 15:29
 **/
public class MyHouseDao extends BaseDao<MyHouse> {

    private String QuerySqlAll;
    private String QuerySqlAllCount;

    public String getQuerySqlAll() {
        return QuerySqlAll = "select h.*,s.SNAME,a.aname  from myhouse h JOIN mysort s on h.SID = s.SID JOIN myarea a on h.AID = a.AID where s.SID = ?";
    }

    public String getQuerySqlAllCount() {
        return QuerySqlAllCount = "Select count(*) as count from myhouse";
    }
}
