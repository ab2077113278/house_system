package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 支出信息service实现类
 *@Time: 2020/8/26  19:23
 */

import cn.sx.dao.Impl.MyZhiChuDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyJs;
import cn.sx.entity.MyZhiChu;

import java.util.List;
import java.util.Map;

public class MyZhiChuService extends SystemDao {
    private MyZhiChuDao myZhiChuDao = new MyZhiChuDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myZhiChuDao.calculationQuantity(myZhiChuDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyZhiChu> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myZhiChuDao.queryBaserecords(myZhiChuDao.getQuerySqlAll(), pageMap, MyZhiChu.class , objects);
    }

    public  boolean Universal_RUD(String sql , Object... args){
        return myZhiChuDao.Universal_RUD(myZhiChuDao.getInsertSql(),args);
    }

    public  int Universal_RUD(MyZhiChu myZhiChu){
        Object[] objects = new Object[3];

        objects[0] = myZhiChu.getZmoney();
        objects[1] = myZhiChu.getZtm();
        objects[2] = myZhiChu.getZremark();

        if(myZhiChuDao.Universal_RUD(myZhiChuDao.getInsertSql(),objects)){
            return 1;
        }else {
            return 0;
        }
    }
    /**
     *查询记录(支持分页)，返回List实体类数据
     k @param ob jects
     * @return
     * */
    public List<MyZhiChu> queryRecordsListDto(Object[] objects, Map<String, Object> pageMap){
        return myZhiChuDao . getSelectAll (myZhiChuDao. getQuerySqlAll(), null, pageMap, MyZhiChuDao.class);
    }
}
