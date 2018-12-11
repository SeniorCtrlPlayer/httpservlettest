package com.lwk.util;

import java.sql.*;
import java.util.ArrayList;

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
            conn = JdbcUtil.getConnection();
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


        try {
//            conn = JdbcUtil.getConnection();
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement(sql);

            // 给?赋值
            if (params != null && params.length > 0) {

                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();

            //封装arrayList

            ResultSetMetaData rsmd=rs.getMetaData();//元数据
            int columnCount=rsmd.getColumnCount();
            System.out.println("columnCount is: "+columnCount);

            arrayList=new ArrayList<Object[]>();

            while(rs.next()){
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
//            JdbcUtil.release(rs, ps, conn);//立即关闭
            C3P0Util.release(rs,ps,conn);
            return arrayList;
        }
    }
}
