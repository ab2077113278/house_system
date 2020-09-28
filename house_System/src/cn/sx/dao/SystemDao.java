package cn.sx.dao;

import cn.sx.utils.JdbcUtils;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 系统持久层基类
 * @create: 2020-08-11 11:34
 **/
public abstract class SystemDao extends BaseDao{
    /**
     * 查询所有
     * @param sql
     * @param objects
     * @return
     */
    public  List<Map<String,Object>> getSelectAll(String sql, Object... objects) {
        return JdbcUtils.getSelectAll(sql,objects);
    }

    /**
     * 修改
     * @param sql
     * @param args
     * @return
     */
    public boolean update(String sql , Object... args){
         return JdbcUtils.update(sql,args);
    }

    /**
     * 添加
     * @param sql
     * @param args
     * @return
     */
    public  boolean insert(String sql , Object... args){
        return JdbcUtils.insert(sql,args);
    }

    /**
     * 删除
     * @param sql
     * @param objects
     * @return
     */
    public  boolean delete(String sql , Object... objects){
        return JdbcUtils.delete(sql,objects);
    }

    public  int calculationQuantity(String sql , Object... args){
        return JdbcUtils.calculationQuantity(sql,args);
    }
}
