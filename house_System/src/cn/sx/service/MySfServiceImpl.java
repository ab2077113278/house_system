package cn.sx.service;

import cn.sx.dao.Impl.MySfDao;
import cn.sx.entity.MySf;
import cn.sx.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-23 01:51
 **/
public class MySfServiceImpl implements BaseService<MySf> {
    MySfDao mySfDao = new MySfDao();

    @Override
    public int calculationQuantity(Object... args) {
        return mySfDao.calculationQuantity(mySfDao.getQuerySqlAllCount(),args);
    }

    @Override
    public List<MySf> getSelectAll(Map<String, Object> pageMap, Object... objects) {
        return mySfDao.getSelectAll(mySfDao.getQuerySqlAll(), MySf.class,pageMap,objects);
    }
}
