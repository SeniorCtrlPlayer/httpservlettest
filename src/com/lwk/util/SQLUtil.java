package com.lwk.util;

import java.sql.*;
import java.util.ArrayList;

import com.lwk.util.C3P0Util.*;

public class SQLUtil {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static Connection getConn() {
        return conn;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static ResultSet executeQuery(String sql, String[] params) {
        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement(sql);

            if (params != null && params.length > 0) {

                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("pwd"));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            JdbcUtil.release(null, ps, conn);延迟关闭
            System.out.println("数据库连接已释放");
            return rs;
//            返回的rs无法使用
        }
    }

    //executeQueryRightDown
    public static ArrayList<Object[]> executeQueryRD(String sql, Object params[]) {

        ArrayList<Object[]> arrayList=null;

        System.out.println("开始尝试数据库连接");

        try {
//            conn = JdbcUtil.getConnection();
            conn = C3P0Util.getConnection();

            if(conn!=null){
                System.out.println("成功拿到数据库连接");
            }else{
                System.out.println("未从C3P0拿到数据库连接");
            }

            ps = conn.prepareStatement(sql);

            // 给?赋值
            if (params != null && params.length > 0) {

                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();

            //封装arrayList

            ResultSetMetaData rsmd=rs.getMetaData();//元数据，即使查询语句为空也能拿到元数据，即表结构
            int columnCount=rsmd.getColumnCount();
            System.out.println("columnCount is: "+columnCount);

            arrayList=new ArrayList<Object[]>();

            //rs.next()是空的，但是rs本身不为null
            while(rs.next()){
                System.out.println("rs不为空");
                //封装Object[]
                Object[] objects=new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    objects[i]=rs.getObject(i+1);
                    //测试语句
//                    System.out.println(objects[i]);
                }

                arrayList.add(objects);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
//            System.out.println("测试");
//            JdbcUtil.release(rs, ps, conn);//立即关闭s
            C3P0Util.release(rs,ps,conn);
            return arrayList;
        }
    }

    public static int executeUpdate(String sql,Object[] params){
        int res = 0;
        try{
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement(sql);

            if(params != null && params.length>0){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,ps,conn);
            return res;
        }
    }
}
