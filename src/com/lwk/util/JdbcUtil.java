package com.lwk.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static{
        InputStream is=JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");

        Properties props=new Properties();

        try {
            props.load(is);

            driverClass=props.getProperty("jdbc.driverClass");
            url=props.getProperty("jdbc.url");
            username=props.getProperty("jdbc.username");
            password=props.getProperty("jdbc.password");

            Class.forName(driverClass);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            return conn;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
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
