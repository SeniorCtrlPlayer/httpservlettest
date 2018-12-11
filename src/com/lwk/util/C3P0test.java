package com.lwk.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0test {
    public static void main(String[] args) {
//        System.out.println(C3P0Util.getConnection());
        try {
            Connection conn = C3P0Util.getConnection();
            String sql = "select * from userinfo where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            String params[] = {"123"};
            if (params != null && params.length > 0) {

                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
