package com.lwk.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class myhttpservlet extends HttpServlet {
    private int Getn=0;
    private int Postn=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.print("<html><body>");
//        out.print("HelloWorld");
//        out.print("</body></html>");
        System.out.println("第"+(++Getn)+"个get请求");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println("name="+name);
        System.out.println("pwd="+pwd);
        if (name!=null&&!"".equals(name)){
            if("lwk".equals(name)&&"lwk".equals(pwd)){
                req.getRequestDispatcher("/succ.html").forward(req,resp);
                System.out.println("成功登录");
            }else{
                req.getRequestDispatcher("/1.html").forward(req,resp);
                System.out.println("拒绝登录");
            }
        }
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第"+(++Postn)+"个post请求");
        System.out.println("name="+req.getParameter("usernmae"));
        System.out.println("pwd"+req.getParameter("password"));
        super.doGet(req, resp);
    }
}
