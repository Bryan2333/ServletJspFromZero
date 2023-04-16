package com.bryan._011servletcontext.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // 1. 通过 请求对象 获得 ServletContext 对象
        ServletContext servletContext = request.getServletContext();

        // 2. 通过对应的 key 获得共享数据
        String value1 = (String) servletContext.getAttribute("key1");
        System.out.println(value1);
    }
}
