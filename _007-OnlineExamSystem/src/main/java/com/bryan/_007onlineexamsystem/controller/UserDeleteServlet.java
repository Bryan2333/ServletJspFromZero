package com.bryan._007onlineexamsystem.controller;

import com.bryan._07onlineexamsystem.dao.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet", value = "/user/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. 调用 请求对象 读取 请求头的参数，获得用户编号
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userId");

        // 2. 调用 UserDao 将用户编号填入Sql语句中，并提交各数据库执行
        UserDao userDao = new UserDao();
        int row = userDao.delete(userId);

        String success = "<p style='color: black; font-size: 40px;'>删除用户成功</p>";
        String fail = "<p style='color: red; font-size: 40px;'>删除用户失败</p>";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.print(row == 1 ? success : fail);

    }
}
