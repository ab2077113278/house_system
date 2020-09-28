package cn.sx.service;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 租房政策service
 *@Time: 2020/8/28  15:56
 */

import cn.sx.dao.Impl.MyCusDao;
import cn.sx.dao.Impl.MyZcDao;
import cn.sx.entity.MyZc;

import java.util.List;
import java.util.Map;

public class MyZcService implements BaseService<MyZc>{
    private MyZcDao myZcDao = new MyZcDao();

    @Override
    public int calculationQuantity(Object... args) {
        return myZcDao.calculationQuantity(myZcDao.getQuerySqlAllCount(),args);
    }

    @Override
    public List<MyZc> getSelectAll(Map<String, Object> pageMap, Object... objects) {
        return myZcDao.getSelectAll(myZcDao.getQuerySqlAll(),MyZc.class,pageMap,objects);
    }

    public  boolean Universal_RUD(String sql , Object... args){
        return myZcDao.Universal_RUD(myZcDao.getInsertSql(),args);
    }

    public  int Universal_RUD(MyZc myZc){
        Object[] objects = new Object[3];
        objects[0] = myZc.getCtitle();
        objects[1] = myZc.getCtime();
        objects[2] = myZc.getCremark();
        if(myZcDao.Universal_RUD(myZcDao.getInsertSql(),objects)){
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
    public List<MyZc> queryRecordsListDto(Object[] objects, Map<String, Object> pageMap){
        return myZcDao . getSelectAll (myZcDao. getQuerySqlAll(), null, pageMap, MyCusDao.class);
    }
}
