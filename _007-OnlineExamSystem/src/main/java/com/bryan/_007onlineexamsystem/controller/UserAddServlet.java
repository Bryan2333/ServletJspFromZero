package com.bryan._007onlineexamsystem.controller;

import com.bryan._07onlineexamsystem.dao.UserDao;
import com.bryan._07onlineexamsystem.entity.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "UserAddServlet", value = "/user/add")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName;
        String password;
        String email;
        String sex;
        UserDao userDao = new UserDao();
        User user;
        int result;
        PrintWriter out;

        // 1. 通过请求对象读取请求头的参数信息，得到用户的信息
        userName = request.getParameter("username");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        // 2. 调用 UserDao 将用户信息填充到 INSERT 语句并使用 JDBC 将用户信息添加到数据库中
        user = new User((String) null, userName, password, sex, email);
        Date begin = new Date();
        result = userDao.add(user, request);
        Date end = new Date();
        System.out.println("创建用户所需时间: " + (end.getTime() - begin.getTime()) + "毫秒");
        // 3.  调用响应对象 将 处理结果 以二进制的形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();

        out.print(result == 1 ? "<p style='color: black; font-size: 40px;'>用户信息注册成功</p>" :
                "<p style='color: red; font-size: 40px;'>用户信息注册失败</p>");
    }
}
