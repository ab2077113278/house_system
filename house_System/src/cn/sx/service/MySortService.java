package cn.sx.service;

import cn.sx.dao.Impl.MyCusDao;
import cn.sx.dao.Impl.MySortDao;
import cn.sx.entity.MyCus;
import cn.sx.entity.MySort;

import java.util.List;
import java.util.Map;

/**
 * 房屋类别业务层
 * @program: house_System
 * Author sx
 * @desc 房屋类别service实现类
 **/
public class MySortService {
    //持久层对象
    private MySortDao mySortDao = new MySortDao();
    //sql语句
    private String updateSql = "update mysort set JNAME=? WHERE JID = ?";
    private String insertSql = "insert mysort (SNAME)value (?)";
    private String delSql = "delete from mysort where JID = ?";

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return mySortDao.calculationQuantity(mySortDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public  List<MySort> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return mySortDao.getSelectAll(mySortDao.getQuerySqlAll(), MySort.class,pageMap,objects);
    }

    public  int Universal_RUD(MySort mySort){
        Object[] objects = new Object[1];
        objects[0] = mySort.getSname();
        if(mySortDao.Universal_RUD(insertSql,objects)){
            return 1;
        }else {
            return 0;
        }
    }

}
