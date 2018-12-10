package com.lwk.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        if (name!=null&&!"".equals(name)){
            if("lwk".equals(name)&&"lwk".equals(pwd)){
                req.getRequestDispatcher("/succ.html").forward(req,resp);
                System.out.println("成功登录");
            }else{
                req.getRequestDispatcher("/1.html").forward(req,resp);
                System.out.println("拒绝登录");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
