package cn.sx.service;


import cn.sx.dao.Impl.MyJsDao;
import cn.sx.entity.MyJs;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 岗位service
 * @create: 2020-08-11 11:40
 **/
public class MyJsService {
    //持久层对象
    private MyJsDao myJsDao = new MyJsDao();
    //sql语句
    private String allSql = "Select * from myjs";
    private String updateSql = "update myjs set JNAME=? WHERE JID = ?";
    private String delSql = "delete from myjs where jid = ?";
    private String quantitySql = "Select count(*) as count from myjs";
    private String insertSql = "insert myjs (JNAME)values (?)";

    public  int calculationQuantity(Object... args){
        return myJsDao.calculationQuantity(quantitySql,args);
    }

    public final List<MyJs> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myJsDao.getSelectAll(allSql, MyJs.class,pageMap,objects);
    }

    public  int Universal_RUD(MyJs myJs){
        Object[] objects = new Object[1];
        objects[0] = myJs.getJname();
        if(myJsDao.Universal_RUD(insertSql,objects)){
            return 1;
        }else {
            return 0;
        }
    }

}
