package com.bryan._007onlineexamsystem.controller;

import com.bryan._07onlineexamsystem.dao.UserDao;
import com.bryan._07onlineexamsystem.entity.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UserFindServlet", value = "/user/find")
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        *   令牌制的缺点：
        *
        *       1. 增加开发难度
        *
        *       2. 不能对静态资源文件提供保护
        *
        */
        // 索要当前用户的HttpSession
        /*HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/myWeb/login_error.html");
            return;
        }*/


        // 1. 调用 DAO 将查询语句推送到 MySQL 数据库，获得所有的用户信息
        UserDao userDao = new UserDao();
        ArrayList<User> users = userDao.find();

        // 2. 调用响应对象将用户结合 <table> 标签以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String tableStart = """
                <div style='margin: 0 auto;'>
                    <table border='1' align='center'>
                        <tr>
                            <td>用户编号</td>
                            <td>用户姓名</td>
                            <td>用户密码</td>
                            <td>用户性别</td>
                            <td>用户邮箱</td>
                            <td>操作</td>
                        </tr>
                """;
        writer.print(tableStart);
        for (User user : users) {
            String userRow = """
                        <tr>
                            <td>%s</td>
                            <td>%s</td>
                            <td>*****</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td><a href='/myWeb/user/delete?userId=%s'>删除用户</a></td>
                        </tr>
                    """.formatted(user.getUserId(), user.getUserName(),
                    user.getSex(), user.getEmail(), user.getUserId());
            writer.print(userRow);
        }

        String tableEnd = """
                    </table>
                </div>
                """;
        writer.print(tableEnd);
    }
}
