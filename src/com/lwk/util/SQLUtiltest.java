package com.lwk.util;

import com.lwk.exception.DaoException;
import com.lwk.model.Userinfo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SQLUtiltest {
    public static void main(String[] args) {
        try{
            String sql = "select * from userinfo where name=? and pwd=?";

            String[] params = { "123","123" };

            //dao中不在含有数据库连接部分
//            ResultSet rs = SQLUtil.executeQuery(sql, params);
//            if(rs!=null){
//                System.out.println("结果集不为空，但是conn已被关闭，rs无法使用");
//            }
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("pwd"));
//            }
            ArrayList<Object[]> al = SQLUtil.executeQueryRD(sql,params);
            if(al != null && al.size() > 0){
                Object[] objects = al.get(0);
                System.out.println((String)objects[0]);
                System.out.println((String)objects[1]);
            }
        }catch (Exception e){
            //抛出Dao的运行时异常
            e.printStackTrace();
        }
    }
}
