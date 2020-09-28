package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房分类查询service实现类
 *@Time: 2020/8/27  8:51
 */

import cn.sx.dao.Impl.MyRscqDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyRsxq;

import java.util.List;
import java.util.Map;

public class MyRsxqService extends SystemDao {

    /*实例化对象*/
    private MyRscqDao myRscqDao = new MyRscqDao();

    /*统计房屋类别个数业务*/
    public  int calculationQuantity(String where , Object... args){
        return myRscqDao.calculationQuantity(myRscqDao.getQuerySqlAllCount(where),args);
    }

    /*查询所有房屋类别业务*/
    public List<MyRsxq> getSelectAll(Map<String,Object> pageMap, String where, Object... objects ){
        return myRscqDao.queryBaserecords(myRscqDao.getQuerySqlAll(where) ,pageMap , MyRsxq.class , objects);
    }
}
