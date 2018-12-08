package com.lwk.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLUtil {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;


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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.release(null, ps, conn);
            return rs;
        }
    }
}