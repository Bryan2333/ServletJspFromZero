package com.bryan._003servletlifecycle;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {

    public TwoServlet() {
        System.out.println("TwoServlet实例对象被创建");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("TwoServlet is running....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
