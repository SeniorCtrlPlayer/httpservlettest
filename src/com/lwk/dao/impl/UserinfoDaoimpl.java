package com.lwk.dao.impl;

import com.lwk.dao.UserinfoDao;
import com.lwk.exception.IdIsNullException;
import com.lwk.model.Userinfo;
import com.lwk.util.SQLUtil;

import java.sql.ResultSet;
import java.util.List;

public class UserinfoDaoimpl implements UserinfoDao {
    @Override
    public Userinfo findUserByName(String name) {

        Userinfo userinfo = null;

        try{
            String sql = "select * from userinfo where name=?";

            String[] params = { name };

            //dao中不在含有数据库连接部分
            ResultSet rs = SQLUtil.executeQuery(sql, params);

            if (rs.next()) {

                // 封装成javabean

                userinfo = new Userinfo();

                userinfo.setId(rs.getInt("id"));
                userinfo.setName(rs.getString("name"));
                userinfo.setNickName(rs.getString("nickName"));
                userinfo.setPwd(rs.getString("pwd"));
                userinfo.setGender(rs.getString("gender"));
                userinfo.setBirthday(rs.getDate("birthday"));
                userinfo.setHobby(rs.getString("hobby"));
                userinfo.setTel(rs.getString("tel"));
                userinfo.setEmail(rs.getString("email"));
                userinfo.setGrade(rs.getInt("grade"));
                userinfo.setDescription(rs.getString("description"));
            }
        }catch (Exception e){

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
