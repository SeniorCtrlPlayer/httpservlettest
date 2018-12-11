package com.lwk.service.impl;

import com.lwk.dao.UserinfoDao;
import com.lwk.dao.impl.UserinfoDaoimpl;
import com.lwk.exception.DaoException;
import com.lwk.exception.IdIsNullException;
import com.lwk.model.Userinfo;
import com.lwk.service.UserinfoService;
import com.lwk.util.SQLUtil;

import java.sql.ResultSet;
import java.util.List;

public class UserinfoServiceimpl implements UserinfoService {

    private UserinfoDao userDao = new UserinfoDaoimpl();

    @Override
    public Userinfo findUserByName(String name) {
        return userDao.findUserByName(name);
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

    @Override
    public Userinfo findUserByNameAndPwd(String name, String pwd) {
        return userDao.checkUser(name, pwd);
    }

    @Override
    public Userinfo checkUser(String name, String pwd) {
        return null;
    }
}
