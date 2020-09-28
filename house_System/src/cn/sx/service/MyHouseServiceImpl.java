package cn.sx.service;

import cn.sx.dao.BaseDao;
import cn.sx.dao.Impl.MyHouseDao;
import cn.sx.entity.MyHouse;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-20 16:04
 **/
public class MyHouseServiceImpl extends BaseDao<MyHouse> {
    private MyHouseDao myHouseDao = new MyHouseDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myHouseDao.calculationQuantity(myHouseDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyHouse> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myHouseDao.getSelectAll(myHouseDao.getQuerySqlAll(), MyHouse.class,pageMap,objects);
    }
}
