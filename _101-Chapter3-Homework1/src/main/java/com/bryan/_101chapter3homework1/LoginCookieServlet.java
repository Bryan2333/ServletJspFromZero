package com.bryan._101chapter3homework1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginCookieServlet", value = "/login")
public class LoginCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName"); // 获取用户名
        String password = request.getParameter("password"); // 获取用户密码
        int count = 0;

        // 判断是否为目标用户
        if (!"Bryan".equals(userName) || !"1234".equals(password)) {
            writer.println("<h1 style='color: red;'>登陆失败</h1>");
        }
        Cookie[] cookies = request.getCookies();
        Cookie countCookie = null; // 先假定计数cookie不存在
        Cookie userNameCookie = null; // 先假定用户名cookie不存在
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("countCookie".equals(cookie.getName())) {
                    countCookie = cookie;
                    continue;
                }

                if ("userNameCookie".equals(cookie.getName())) {
                    userNameCookie = cookie;
                }
            }
        }

        if (countCookie == null) {
            // 如果计数cookie不存在，则创建新的cookie
            countCookie = new Cookie("countCookie", 1 + "");
            response.addCookie(countCookie);
            writer.println("cookie created successfully");
        } else {

            count = Integer.parseInt(countCookie.getValue());
        }
        count++;
        // 如果计数cookie已存在，则在原有计数上加1
        Cookie countCookie1 = new Cookie("countCookie", String.valueOf(count));
        response.addCookie(countCookie1);

        if (userNameCookie == null) {
            Cookie userName1 = new Cookie("userName", userName);
            response.addCookie(userName1);
        }

        writer.println("<h1>登陆成功</h1>");
        if (count > 4) {
            writer.println("<h2>Gift is waiting for you</h>");
        }
    }
}