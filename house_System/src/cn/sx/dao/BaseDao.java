package cn.sx.dao;

import cn.sx.entity.MyDj;
import cn.sx.utils.JdbcUtils;
import cn.sx.utils.SystemStringUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-08 14:41
 **/
public abstract class BaseDao<T> {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

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

    /**
     * 查询返回值为List集合对象
     * @param sql
     * @param tClass
     * @param objects
     * @return
     */
    public final List<T> getSelectAll(String sql, Class<T> tClass , Map<String,Object> pageMap , Object... objects ){
        try {
            conn = JdbcUtils.getConnection();
            if(pageMap != null && pageMap.get("start") != null && pageMap.get("pageSize") != null ){
                sql +=  "  limit "+pageMap.get("start")+","+pageMap.get("pageSize");
//                System.out.println("sql   "+sql);
            }
            ps = conn.prepareStatement(sql);
            //给sql语句赋值
            if(objects != null && objects.length >=1 ){
                for(int i=0;i<objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
            }
            rs = ps.executeQuery();
            List<T> list = new ArrayList<T>();
            //获取本次查询结果集有多少列
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            while(rs.next()){

                T bean = tClass.newInstance();

                //for循环  遍历所有的列
                for(int i=0;i<count;i++){

                    String fName = resultSetMetaData.getColumnLabel(i + 1);

//                    System.out.println("fName  "+fName);

                    //因为列的名字和我们EMP中的属性名是一样的，所以通过列的名字获得其EMP中属性
                    Field field = null;
                    field = tClass.getDeclaredField(fName.toLowerCase());

//                    System.out.println((Class<?>) field.getGenericType());

                    //因为属性是私有的，所有获得其对应的set 方法。set+属性名首字母大写+其他小写
                    String setName = "set" + fName.toUpperCase().substring(0, 1) + fName.substring(1).toLowerCase();

//                    System.out.println("setName  "+setName);

                    //因为属性的类型和set方法的参数类型一致，所以可以获得set方法
                    Method setMethod = tClass.getMethod(setName,  field.getType());
                    if(Long.class ==  field.getType()){
                        setMethod.invoke(bean, rs.getLong(fName));
                    }
                    if(String.class == field.getType()){
                        setMethod.invoke(bean, rs.getString(fName));
                    }

                    if(Integer.class == field.getType()){
                        setMethod.invoke(bean, rs.getInt(fName));
                    }

                    if(Float.class == field.getType()){
                        setMethod.invoke(bean, rs.getFloat(fName));
                    }

                    /*if(get( field.getType(),rs.getObject(fName)) == null){
                        setMethod.invoke(bean, rs.getObject(fName));
                    }else {
                        setMethod.invoke(bean, get( field.getType(),rs.getObject(fName)));
                    }*/

                    //执行set方法，把resultSet中的值传入emp中，  再继续循环传值

                    /*if (fName.equals("JID") || fName.equals("AID")){
                        System.out.println(fName+"    "+rs.getObject(fName));
                        System.out.println("field.getType()  "+field.getType());
                        System.out.println( "get( field.getType(),rs.getObject(fName))   "+get( field.getType(),rs.getObject(fName)));
                    }*/

                }
                //把所有的map集合添加到List集合中
                list.add(bean);
            }
            //返回值
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.closeAll(conn,ps,rs);
        }

        return null;
    }

    public  boolean Universal_RUD(String sql , Object... args){
        return JdbcUtils.Universal_RUD(sql,args);
    }

    //搞不懂这方法的尿性
    public static  <T> T get(Class<T> clz,Object o){
        if(clz.isInstance(o)){
            return clz.cast(o);
        }
        return null;
    }

    /**
     *用于实例化
     * 查询所有记录
     */

    public final List<T> queryBaserecords(String sql, Map<String, Object> map , Class<T> clazz, Object... objects){

        List<T> list = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtils.getConnection();
            if(conn == connection){
                System.out.println("相等");
            }
            System.out.println("objects queryBaseRecords "+objects.length);
            //设置分页参数
            if(map != null && map.get("start") != null && map.get("pageSize") != null ){
                sql +=  "  limit "+map.get("start")+","+map.get("pageSize");
//                System.out.println("sql   "+sql);
            }
            pre = connection.prepareStatement(sql);

            //给sql语句赋值，设置查询参数
            if(objects != null && objects.length >=1 ){
                for(int i=0;i<objects.length;i++){
                    pre.setObject(i+1,objects[i]);
                }
            }
            //执行查询
            rs = pre.executeQuery();
            while (rs.next()){
                //实例化
                T bean = clazz.newInstance();
                getRecordToBean(rs,bean);
                list.add(bean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,pre,rs);
        }
        return list;
    }

    //获取一行记录(从结果集中获取)
    //0bject bean用于装一行记录
    public void getRecordToBean(ResultSet rs,Object bean) {
        //只获取到日期
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //获取结果集元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                // 获取列名 和对应的数据
                String columnName = metaData.getColumnName(i);
                //这种也可以，不过这种取日期时要使用转换器ConvertUtil. getDateConverter();
                Object columnValue = rs.getObject(i);
                columnName = SystemStringUtils.convertString(columnName);
                //System . out. println(coLumnName + "=" + coLumnValue) ;
                map.put(columnName, columnValue);

            }
            //这个方法会遍历map<key, value>中的key, 如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
            BeanUtils.populate(bean, map);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
