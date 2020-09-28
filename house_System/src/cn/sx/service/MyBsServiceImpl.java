package cn.sx.service;



import cn.sx.dao.Impl.MyBsDao;
import cn.sx.dao.Impl.MyCusDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyBs;
import cn.sx.entity.MyCus;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 报损信息实现类
 * @create: 2020-08-20 16:04
 **/
public class MyBsServiceImpl extends SystemDao {
    private MyBsDao myBsDao = new MyBsDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myBsDao.calculationQuantity(myBsDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyBs> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myBsDao.queryBaserecords(myBsDao.getQuerySqlAll(), pageMap, MyBs.class, objects);
    }
    public  boolean Universal_RUD(String sql , Object... args){
        return myBsDao.Universal_RUD(myBsDao.getInsertSQL(),args);
    }

    public  int Universal_RUD(MyBs myBs){
        Object[] objects = new Object[2];
        objects[0] = myBs.getHid();
        objects[1] = myBs.getBremark();
        if(myBsDao.Universal_RUD(myBsDao.getInsertSQL(),objects)){
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
    public List<MyBs> queryRecordsListDto(Object[] objects, Map<String, Object> pageMap){
        return myBsDao . getSelectAll (myBsDao. getQuerySqlAll(), null, pageMap, MyBsDao.class);
    }
}
