package cn.sx.utils;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @program: house_System
 * Author sx
 * @desc 操作数据库的工具类
 * @create: 2020-08-06 16:57
 **/
public class JdbcUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    /**
     *
     * 连接数据库，获取Connection对象
     */
    public static Connection getConnection(){
        Properties properties = new Properties();
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mySql.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = (String) properties.get("user");
        password = (String) properties.get("password");
        url = (String) properties.get("url");
        driver = (String) properties.get("driver");
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源的方法
     */
    public static void closeAll(Connection conn, PreparedStatement pre, ResultSet res){
        try {
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(pre != null) pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(res != null) res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用的修改、添加、删除
     * @return
     */
    public static boolean Universal_RUD(String sql , Object... args){
        int i = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //设置参数
            System.out.println("args   "+args.length);
            if(args != null && args.length>0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return i>0;
    }

    /**
     * 添加数据
     * @param sql sql语句
     * @param args 可变参数，用于设置占位符
     * @return
     */
    public static boolean insert(String sql , Object... args){
        int i = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //设置参数
            if(args != null && args.length>0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }
            System.out.println(ps);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return i>0;
    }

    /**
     * 修改数据
     * @param sql
     * @param args
     * @return
     */
    public static boolean update(String sql , Object... args){
        int i = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //设置参数
            if(args != null && args.length>0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return i>0;
    }

    /**
     * 获取某张表的全部数据
     * @param sql
     * @param args
     * @return
     */
    public static List<Map<String,Object>> getSelectAll(String sql, Object... args){
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //设置参数
            if(args != null && args.length>0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }
            rs = ps.executeQuery();
            List<Map<String, Object>> list = new ArrayList<>();
            //获取本次查询结果集有多少列
            int count = rs.getMetaData().getColumnCount();
            while(rs.next()){
                //创建Map集合   获取一个数据封装成一个Map集合
                Map<String, Object> map = new HashMap<>();
                //for循环  遍历所有的列
                for(int i=0;i<count;i++){
                    //获取本次查询结果集的列名
                    String name = rs.getMetaData().getColumnLabel(i + 1);
                    map.put(name,rs.getObject(name));
                }
                //把所有的map集合添加到List集合中
                list.add(map);
            }
            //返回值
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(conn,ps,rs);
        }
        return null;
    }

    /**
     * 删除数据
     * @param sql
     * @return
     */
    public static boolean delete(String sql , Object... args){
        int i = 0;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if(args != null && args.length>0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return i>0;
    }

    public static int calculationQuantity(String sql , Object... args){
        int quantity = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //设置参数
            if(args != null && args.length>=0){
                for(int j=0; j < args.length; j++){
                    ps.setObject(j+1 , args[j]);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()){
                quantity = rs.getInt(1);
            }
            return quantity;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return quantity;
    }

}
