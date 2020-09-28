package cn.sx.service;

import cn.sx.dao.Impl.MyAreaDao;
import cn.sx.dao.Impl.MyCusDao;
import cn.sx.dao.Impl.MyJsDao;
import cn.sx.entity.MyArea;
import cn.sx.entity.MyJs;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 片区service实现类
 * @create: 2020-08-11 11:40
 **/
public class MyAreaService implements BaseService<MyArea>{
    //持久层对象
    private MyAreaDao myAreaDao = new MyAreaDao();
    //sql语句
    private String allSql = "Select * from myarea";
    private String updateSql = "update myarea set ANAME=? WHERE AID = ?";
    private String insertSql = "insert myarea (ANAME) value (?)";
    private String delSql = "delete from myarea where AID = ?";
    private String quantitySql = "Select count(*) as count from myarea";

    public  int calculationQuantity(Object... args){
        return myAreaDao.calculationQuantity(quantitySql,args);
    }

    public final List<MyArea> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myAreaDao.queryBaserecords(allSql, pageMap ,MyArea.class,objects);
    }

    public  int Universal_RUD(MyArea myArea){
        Object[] objects = new Object[1];
        objects[0] = myArea.getAname();
        if(myAreaDao.Universal_RUD(insertSql,objects)){
            return 1;
        }else {
            return 0;
        }
    }

}
