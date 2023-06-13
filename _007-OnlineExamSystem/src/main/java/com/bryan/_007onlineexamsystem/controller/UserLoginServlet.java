package com.bryan._007onlineexamsystem.controller;

import com.bryan._007onlineexamsystem.dao.UserDao;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/user/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 调用 请求对象 对 请求体 使用 UTF-8 重新编码
        request.setCharacterEncoding("utf-8");

        // 2. 从请求体中读取参数，获得用户信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // 3. 将用户信息填入 Sql 语句中，并交给 Sql 服务器查询
        UserDao userDao = new UserDao();
        int row = userDao.login(userName, password);

        // 4. 根据 Sql服务器查询返回的结果，将不同的资源地址写入响应头，交给浏览器
//        response.sendRedirect(row == 1 ? "/myWeb/index.html" : "/myWeb/login_error.html");
        /*if (row == 1) {
            HttpSession session = request.getSession();
            response.sendRedirect("/myWeb/index.html");
        } else {
            response.sendRedirect("/myWeb/login_error.html");
        }*/


    }
}
