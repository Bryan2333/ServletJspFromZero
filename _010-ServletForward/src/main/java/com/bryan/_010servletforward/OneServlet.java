package com.bryan._010servletforward;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet ran");

        // 1. 通过当前请求对象申请资源文件申请报告对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/two");

        // 2. 将资源文件申请报告对象发送给Tomcat
        requestDispatcher.forward(request, response);

    }

}