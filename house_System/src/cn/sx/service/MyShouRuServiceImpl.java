package cn.sx.service;




import cn.sx.dao.Impl.MyShouRuDao;
import cn.sx.dao.SystemDao;
import cn.sx.entity.MyBiao;
import cn.sx.entity.MyShouRu;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 收入信息serv诶实现类
 * @create: 2020-08-20 16:04
 **/
public class MyShouRuServiceImpl extends SystemDao {
    private MyShouRuDao myShouRuDao = new MyShouRuDao();

    /**
     * 统计房屋类别个数业务
     * @param args
     * @return
     */
    public  int calculationQuantity(Object... args){
        return myShouRuDao.calculationQuantity(myShouRuDao.getQuerySqlAllCount(),args);
    }

    /**
     * 查询所有房屋类别业务
     * @param pageMap
     * @param objects
     * @return
     */
    public List<MyShouRu> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myShouRuDao.queryBaserecords(myShouRuDao.getQuerySqlAll(), pageMap, MyShouRu.class , objects);
    }
    public  int Universal_RUD(MyShouRu myShouRu){
        Object[] objects = new Object[3];
        objects[0] = myShouRu.getSmoney();
        objects[1] = myShouRu.getStm();
        objects[2] = myShouRu.getSremark();
        if(myShouRuDao.Universal_RUD(myShouRuDao.getInsertSQL(),objects)){
            return 1;
        }else {
            return 0;
        }
    }
}
