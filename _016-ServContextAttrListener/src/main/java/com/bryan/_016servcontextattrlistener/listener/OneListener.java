package com.bryan._016servcontextattrlistener.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class OneListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("新增共享数据");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("共享数据被更新");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("共享数据被删除");
    }
}
