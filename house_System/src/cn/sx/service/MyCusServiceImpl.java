package cn.sx.service;

import cn.sx.dao.Impl.MyCusDao;
import cn.sx.entity.MyCus;
import cn.sx.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-21 16:11
 **/
public class MyCusServiceImpl implements BaseService<MyCus> {
    private MyCusDao myCusDao = new MyCusDao();

    @Override
    public int calculationQuantity(Object... args) {
        return myCusDao.calculationQuantity(myCusDao.getQuerySqlAllCount(),args);
    }

    @Override
    public List<MyCus> getSelectAll(Map<String, Object> pageMap, Object... objects) {
        return myCusDao.getSelectAll(myCusDao.getQuerySqlAll(),MyCus.class,pageMap,objects);
    }

    public  boolean Universal_RUD(String sql , Object... args){
        return myCusDao.Universal_RUD(myCusDao.getInsertSql(),args);
    }

    public  int Universal_RUD(MyCus myCus){
        Object[] objects = new Object[5];
        objects[0] = myCus.getCname();
        objects[4] = myCus.getCcard();
        objects[1] = myCus.getCsex();
        objects[2] = myCus.getCtel();
        objects[3] = myCus.getCtel1();
        if(myCusDao.Universal_RUD(myCusDao.getInsertSql(),objects)){
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
    public List<MyCus> queryRecordsListDto(Object[] objects, Map<String, Object> pageMap){
        return myCusDao . getSelectAll (myCusDao. getQuerySqlAll(), null, pageMap, MyCusDao.class);
    }

}
