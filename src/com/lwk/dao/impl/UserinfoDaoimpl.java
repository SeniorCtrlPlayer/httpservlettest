package com.lwk.dao.impl;

import com.lwk.dao.UserinfoDao;
import com.lwk.exception.DaoException;
import com.lwk.exception.IdIsNullException;
import com.lwk.model.Userinfo;
import com.lwk.util.SQLUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserinfoDaoimpl implements UserinfoDao {
    @Override
    public Userinfo findUserByName(String name) {

        Userinfo userinfo = null;

        try{
            String sql = "select * from userinfo where name=?";

            String[] params = { name };

            //dao中不在含有数据库连接部分
//            ResultSet rs = SQLUtil.executeQuery(sql, params);
            ArrayList<Object[]> al = SQLUtil.executeQueryRD(sql,params);
//            if (rs.next()) {
//
//                // 封装成javabean
//
//                userinfo = new Userinfo();
//
//                userinfo.setId(rs.getInt("id"));
//                userinfo.setName(rs.getString("name"));
//                userinfo.setNickName(rs.getString("nickName"));
//                userinfo.setPwd(rs.getString("pwd"));
//                userinfo.setGender(rs.getString("gender"));
//                userinfo.setBirthday(rs.getDate("birthday"));
//                userinfo.setHobby(rs.getString("hobby"));
//                userinfo.setTel(rs.getString("tel"));
//                userinfo.setEmail(rs.getString("email"));
//                userinfo.setGrade(rs.getInt("grade"));
//                userinfo.setDescription(rs.getString("description"));
//            }
            if (al != null && al.size() > 0) {
                Object[] objects = al.get(0);

                userinfo = new Userinfo();
                userinfo.setId((Integer)objects[0]);
                userinfo.setName((String)objects[1]);
                userinfo.setNickName((String)objects[2]);
                userinfo.setPwd((String)objects[3]);
                userinfo.setGender((String)objects[4]);
                userinfo.setBirthday((Date)objects[5]);
                userinfo.setHobby((String)objects[6]);
                userinfo.setTel((String)objects[7]);
                userinfo.setEmail((String)objects[8]);
                userinfo.setGrade((Integer)objects[9]);
                userinfo.setDescription((String)objects[10]);

            }
        }catch (Exception e){
            //抛出Dao的运行时异常
            throw new DaoException(e);
        }
        return userinfo;
    }

    @Override
    public Userinfo checkUser(String name, String pwd) {
        Userinfo userinfo = null;

        try{
            String sql = "select * from users where name=? and pwd=?";

            String[] params = { name,pwd };

            //dao中不在含有数据库连接部分
//            ResultSet rs = SQLUtil.executeQuery(sql, params);
            ArrayList<Object[]> al = SQLUtil.executeQueryRD(sql, params);

//            if (rs.next()) {
//
//                // 封装成javabean
//
//                userinfo = new Userinfo();
//
//                userinfo.setId(rs.getInt("id"));
//                userinfo.setName(rs.getString("name"));
//                userinfo.setNickName(rs.getString("nickName"));
//                userinfo.setPwd(rs.getString("pwd"));
//                userinfo.setGender(rs.getString("gender"));
//                userinfo.setBirthday(rs.getDate("birthday"));
//                userinfo.setHobby(rs.getString("hobby"));
//                userinfo.setTel(rs.getString("tel"));
//                userinfo.setEmail(rs.getString("email"));
//                userinfo.setGrade(rs.getInt("grade"));
//                userinfo.setDescription(rs.getString("description"));
//            }
            if (al != null && al.size() > 0) {
                Object[] objects = al.get(0);

                userinfo = new Userinfo();
                userinfo.setId((Integer)objects[0]);
                userinfo.setName((String)objects[1]);
                userinfo.setNickName((String)objects[2]);
                userinfo.setPwd((String)objects[3]);
                userinfo.setGender((String)objects[4]);
                userinfo.setBirthday((Date)objects[5]);
                userinfo.setHobby((String)objects[6]);
                userinfo.setTel((String)objects[7]);
                userinfo.setEmail((String)objects[8]);
                userinfo.setGrade((Integer)objects[9]);
                userinfo.setDescription((String)objects[10]);

            }
        }catch (Exception e){
            //抛出Dao的运行时异常
            throw new DaoException(e);
        }
        return userinfo;
    }

    @Override
    public Userinfo findUserById(Integer id) {
        return null;
    }

    @Override
    public List<Userinfo> findAllUsers() {
        return null;
    }

    @Override
    public int addUser(Userinfo userinfo) {
        return 0;
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public int updateUserById(Userinfo userinfo) {
        return 0;
    }
}
