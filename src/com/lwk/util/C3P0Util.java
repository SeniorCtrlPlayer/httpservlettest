package com.lwk.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Util {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static Connection getConnection(){
        System.out.println("C3P0收到连接请求");
        Connection conn = null;

        try {
            conn = cpds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            return conn;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn){
        try {
            if (rs != null) {
                rs.close();
                rs = null;// 垃圾回收，上！
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;// 垃圾回收，上！
            }
            if (conn != null) {
                conn.close();
                conn = null;// 垃圾回收，上！
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
