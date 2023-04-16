package com.bryan._015servletcontextlistener.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebListener
public class OneListener implements ServletContextListener {

    public OneListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用域对象被初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用域对象被销毁");
    }
}
