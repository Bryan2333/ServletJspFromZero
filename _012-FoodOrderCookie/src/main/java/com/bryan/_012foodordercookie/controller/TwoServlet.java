package com.bryan._012foodordercookie.controller;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int dumpling_money = 30;
        int noodle_money = 15;
        int rice_money = 10;
        String food;
        String userName = null;
        int money;
        int cost = 0;
        int balanced = 0;
        Cookie newCookie = null;
        PrintWriter writer = response.getWriter();

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // 1. 读取请求头参数信息
        food = request.getParameter("food");

        // 2. 读取 请求头 中的 Cookie
        Cookie[] cookies = request.getCookies();

        // 3. 刷卡消费
        for (Cookie cookie : cookies) {
            String key = cookie.getName();
            String value = cookie.getValue();

            if ("userName".equals(key)) {
                userName = value;
            } else if ("money".equals(key)) {
                money = Integer.parseInt(value);
                if ("饺子".equals(food)) {
                    if (money < dumpling_money) {
                        writer.println("用户 " + userName + " 余额不足，请充值");
                    } else {
                        balanced = money - dumpling_money;
                        newCookie = new Cookie("money", balanced + "");
                        cost = dumpling_money;
                    }
                } else if ("面条".equals(food)) {
                    if (noodle_money > money) {
                        writer.println("用户 " + userName + " 余额不足，请充值");
                    } else {
                        balanced = money - noodle_money;
                        newCookie = new Cookie("money", balanced + "");
                        cost = noodle_money;
                    }
                } else if ("盖饭".equals(food)) {
                    if (rice_money > money) {
                        writer.println("用户 " + userName + " 余额不足，请充值");
                    } else {
                        balanced = money - rice_money;
                        newCookie = new Cookie("money", balanced + "");
                        cost = rice_money;
                    }
                }
            }
        }

        // 4. 将用户的卡返回给用户
        response.addCookie(newCookie);

        // 5. 将消费记录写入到响应体
        writer.println("用户 " + userName + " 本次你消费 " + cost + " 元，余额 " + balanced + " 元");
    }
}
