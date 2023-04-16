package com.bryan._016servcontextattrlistener.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "OneServlet", urlPatterns = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("key1", "value"); //添加

        servletContext.setAttribute("key1", "value2"); //更新

        servletContext.removeAttribute("key1"); //删除
    }
}
