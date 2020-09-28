package cn.sx.service;

import cn.sx.dao.Impl.MyTfDao;
import cn.sx.entity.MyTf;
import cn.sx.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 客户信息service实现类
 * @create: 2020-08-23 01:49
 **/
public class MyTfServiceImpl implements BaseService<MyTf> {

    MyTfDao myTfDao = new MyTfDao();/*实例化对象*/



    @Override
    public int calculationQuantity(Object... args) {
        return myTfDao.calculationQuantity(myTfDao.getQuerySqlAllCount(),args);
    }

    @Override
    public List<MyTf> getSelectAll(Map<String, Object> pageMap, Object... objects) {
        return myTfDao.getSelectAll(myTfDao.getQuerySqlAll(),MyTf.class,pageMap,objects);
    }
}
