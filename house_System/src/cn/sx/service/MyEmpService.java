package cn.sx.service;

import cn.sx.dao.Impl.MyAreaDao;
import cn.sx.dao.Impl.MyEmpDao;
import cn.sx.entity.MyArea;
import cn.sx.entity.MyEmp;

import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc 员工信息service
 * @create: 2020-08-11 11:40
 **/
public class MyEmpService implements BaseService<MyEmp> {
    //持久层对象
    private MyEmpDao myEmpDao = new MyEmpDao();
    //sql语句
    private String allSql = "select e.*,d.PNAME,j.JNAME from myemp e JOIN mydept d on e.PID = d.PID JOIN myjs j on j.JID = e.JID";
    private String updateSql = "update myemp set PID=?,JID=?,ENAME=?,EPSW=?,EREALNAME=?,ETEL=?,EADDRESS=?,EFLAG=?,ERE,ARK=?  WHERE EID = ?";
    private String insertSql = "insert myemp (PID,JID,ENAME,EPSW,EREALNAME,ETEL,EADDRESS,EFLAG,EREMARK)value (?,?,?,?,?,?,?,?,?)";
    private String delSql = "delete from myemp where EID = ?";
    private String quantitySql = "Select count(*) as count from myemp";

    public  int calculationQuantity(Object... args){
        return myEmpDao.calculationQuantity(quantitySql,args);
    }

    public final List<MyEmp> getSelectAll(Map<String,Object> pageMap, Object... objects ){
        return myEmpDao.getSelectAll(allSql,MyEmp.class,pageMap,objects);
    }

    public  int Universal_RUD(MyEmp myEmp){
        Object[] objects = new Object[9];
        objects[0] = myEmp.getPid();
        objects[1] = myEmp.getJid();
        objects[2] = myEmp.getEname();
        objects[3] = myEmp.getEpsw();
        objects[4] = myEmp.getErealname();
        objects[5] = myEmp.getEtel();
        objects[6] = myEmp.getEaddress();
        objects[7] = myEmp.getEflag();
        objects[8] = myEmp.getEremark();
        if(myEmpDao.Universal_RUD(insertSql,objects)){
            return 1;
        }else {
            return 0;
        }
    }

}
