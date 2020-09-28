package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 到期收租service实现类
 *@Time: 2020/8/27  16:25
 */

import cn.sx.dao.Impl.MyDaoQiShouZuDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyDaoQiShouZu;

import java.util.List;
import java.util.Map;

public class MyDaoQiShouZuService extends SystemDao {
    private MyDaoQiShouZuDao myDaoQiShouZuDao = new MyDaoQiShouZuDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myDaoQiShouZuDao.calculationQuantity(myDaoQiShouZuDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyDaoQiShouZu> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myDaoQiShouZuDao.queryBaserecords(myDaoQiShouZuDao.getQuerySqlAll(), pageMap, MyDaoQiShouZu.class , objects);
    }
}
