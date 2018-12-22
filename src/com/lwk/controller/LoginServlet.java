package com.lwk.controller;

import com.lwk.model.Userinfo;
import com.lwk.service.UserinfoService;
import com.lwk.service.impl.UserinfoServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    //此时的userinfoService具有和HttpServlet一样的生命周期?
    //userinfoService内部可以控制数据的连接，但是userinfoService和LoginServlet一样每次开机只需要申请一次
    //userinfoService返回的是一个JavaBean
    UserinfoService userinfoService = new UserinfoServiceimpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println("username is "+name);
        System.out.println("passowrd is "+pwd);

        Userinfo userinfo = userinfoService.findUserByNameAndPwd(name,pwd);

        if(userinfo!=null){
            req.getRequestDispatcher("/succ.html").forward(req,resp);
            System.out.println("登录成功");
        }else{
            req.getRequestDispatcher("/1.html").forward(req,resp);
            System.out.println("账号密码错误！");
        }
//        if (name!=null&&!"".equals(name)){
//            if("lwk".equals(name)&&"lwk".equals(pwd)){
//                req.getRequestDispatcher("/succ.html").forward(req,resp);
//                System.out.println("成功登录");
//            }else{
//                req.getRequestDispatcher("/1.html").forward(req,resp);
//                System.out.println("拒绝登录");
//            }
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
