package cn.sx.service;



import cn.sx.dao.Impl.MyDeptDao;
import cn.sx.entity.MyDept;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 部门信息service实现类
 * @create: 2020-08-11 11:40
 **/
public class MyDeptService {
    //持久层对象
    private MyDeptDao myDeptDao = new MyDeptDao();
    //sql语句
    private String allSql = "Select * from mydept ";
    private String updateSql = "update mydept set PNAME=?,premark=?,pflag=? WHERE PID = ?";
    private String insertSql = "insert mydept (PNAME,PFLAG,PREMARK) value  ( ?,?,?)";
    private String delSql = "delete from mydept where pid = ?";
    private String quantitySql = "Select count(*) as count from mydept";
    private String getById = "Select * from mydept  where  pname = ?";




    public  int calculationQuantity(Object... args){
        return myDeptDao.calculationQuantity(quantitySql,args);
    }

    public List<MyDept> getAllMyDept(Map<String, Object> map , Object... objects){
        return myDeptDao.queryBaserecords(allSql , map, MyDept.class , objects);
    }

    public List<MyDept> getByName(Map<String, Object> map , Object... objects){
        return myDeptDao.queryBaserecords( getById , map , MyDept.class , objects);
    }

    public  int Universal_RUD(MyDept myDept){
        Object[] objects = new Object[3];
        objects[0] = myDept.getPname();
        objects[1] = myDept.getPflag();
        objects[2] = myDept.getPremark();
        if(myDeptDao.Universal_RUD(insertSql,objects)){
            return 1;
        }else {
            return 0;
        }
    }

}
