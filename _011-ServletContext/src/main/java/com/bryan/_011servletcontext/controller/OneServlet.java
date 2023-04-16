package com.bryan._011servletcontext.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String test = request.getParameter("test");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/two");

        // 1. 通过当前请求对象获取 ServletContext 对象
        ServletContext servletContext = request.getServletContext();

        // 2. 将数据添加到 ServletContext 对象中，作为共享数据
        servletContext.setAttribute("key1", test);

        requestDispatcher.forward(request, response);

    }
}
