package cn.sx.service;

import cn.sx.dao.Impl.MyDjDao;
import cn.sx.entity.MyDj;
import cn.sx.entity.MyHouse;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 登记入住service
 * @create: 2020-08-22 10:37
 **/
public class MyDjServiceImpl implements BaseService<MyDj> {
    private MyDjDao dao = new MyDjDao();

    @Override
    public int calculationQuantity(Object... args) {
        return dao.calculationQuantity(dao.getQuerySqlAllCount(),args);
    }

    @Override
    public List<MyDj> getSelectAll(Map<String, Object> pageMap, Object... objects) {
        return dao.queryBaserecords(dao.getQuerySqlAll(),pageMap,MyDj.class,objects);
    }
    public  int Universal_RUD(MyDj myDj){
        Object[] objects = new Object[7];
        objects[0] = myDj.getEid();
        objects[1] = myDj.getCid();
        objects[2] = myDj.getHid();
        objects[3] = myDj.getMyj();
        objects[4] = myDj.getMyzj();
        objects[5] = myDj.getMflag();
        objects[6] = myDj.getMbegintime();
        if(dao.Universal_RUD(dao.getInsertSql(),objects)){
            return 1;
        }else {
            return 0;
        }
    }

    public List<MyDj> getMyHouse(Map<String, Object> pageMap, Object... objects){
        return dao.queryBaserecords(dao.getGetMyHouse(),pageMap,MyDj.class,objects);
    }
}
