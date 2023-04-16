package com.bryan._012foodordercookie.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        String UserName;
        String Money;

        // 1. 从请求体中读取用户参数
        UserName = request.getParameter("userName");
        Money = request.getParameter("money");

        // 2. 开卡
        Cookie username = new Cookie("userName", UserName);
        Cookie money = new Cookie("money", Money);

        // 3. 设定 Cookie 的存活时间 单位: 秒
        username.setMaxAge(120);
        money.setMaxAge(120);

        // 4. 发卡，将参数信息写入Cookie
        response.addCookie(username);
        response.addCookie(money);

        // 5. 通知 Tomcat 将点餐页面写入响应体交给浏览器
        request.getRequestDispatcher("/order.html").forward(request, response);
    }

}
