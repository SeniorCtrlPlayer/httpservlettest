package com.lwk.service;

import java.util.List;

import com.lwk.exception.IdIsNullException;
import com.lwk.model.Userinfo;

public interface UserinfoService {

    /**
     * 根据用户名查询单个用户
     *
     * @param name
     * @return
     */
    public Userinfo findUserByName(String name);

    /**
     * 检查登录用户
     *
     * @param name
     * @param pwd
     * @return
     */
    public Userinfo checkUser(String name,String pwd);

    /**
     * 根据id查询单个用户
     *
     * @param id
     * @return
     * @throws IdIsNullException
     */
    public Userinfo findUserById(Integer id)throws IdIsNullException;

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<Userinfo> findAllUsers();

    /**
     * 添加用户
     *
     * @param userinfo
     * @return
     */
    public int addUser(Userinfo userinfo);

    /**
     * 根据id删除单个用户
     *
     * @param id
     * @return
     * @throws IdIsNullException
     */
    public int deleteUserById(Integer id)throws IdIsNullException;

    /**
     * 根据id修改单个用户
     *
     * @param userinfo
     * @return
     * @throws IdIsNullException
     */
    public int updateUserById(Userinfo userinfo)throws IdIsNullException;

}
