package com.bryan._009servletredirect;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/*
*   重定向解决方案需要 浏览器 和 服务器 之间进行多次往返，会增加用户的等待时间
*/

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("OneServet 负责洗韭菜");

        // 重定向解决方案

        response.sendRedirect("/myWeb/two"); // 地址格式: /网站名/网站资源
    }

}
