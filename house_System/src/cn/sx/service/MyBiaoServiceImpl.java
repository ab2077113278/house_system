package cn.sx.service;

import cn.sx.dao.Impl.MyBiaoDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyBiao;
import cn.sx.entity.MyEmp;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 操表信息service实现类
 * @create: 2020-08-20 16:04
 **/
public class MyBiaoServiceImpl extends SystemDao {
    private MyBiaoDao myBiaoDao = new MyBiaoDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myBiaoDao.calculationQuantity(myBiaoDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyBiao> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myBiaoDao.queryBaserecords(myBiaoDao.getQuerySqlAll(), pageMap, MyBiao.class,objects);
    }

    public  int Universal_RUD(MyBiao myBiao){
        Object[] objects = new Object[4];
        objects[0] = myBiao.getHid();
        objects[1] = myBiao.getDkd();
        objects[2] = myBiao.getSkd();
        objects[3] = myBiao.getMkd();
        if(myBiaoDao.Universal_RUD(myBiaoDao.getInsertSql(),objects)){
            return 1;
        }else {
            return 0;
        }
    }
}
