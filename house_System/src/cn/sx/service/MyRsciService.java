package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房费用收入查询
 *@Time: 2020/8/27 9:20
 */

import cn.sx.dao.Impl.MyRsciDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyRsci;

import java.util.List;
import java.util.Map;

public class MyRsciService extends SystemDao {
    /*实例化对象*/
    private MyRsciDao myRsciDao = new MyRsciDao();

    /*统计房屋类别个数业务 */
    public  int calculationQuantity(String where , Object... args){
        return myRsciDao.calculationQuantity(myRsciDao.getQuerySqlAllCount(where),args);
    }

    /*查询所有房屋类别业务*/
    public List<MyRsci> getSelectTiaoJian(Map<String,Object> pageMap, String where, Object... objects ){
        return myRsciDao.queryBaserecords(myRsciDao.getQuerySqlAll(where) ,pageMap , MyRsci.class , objects);
    }
}
