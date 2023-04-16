package com.bryan._007onlineexamsystem.listener;

import com.bryan._07onlineexamsystem.util.JdbcUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

@WebListener
public class OneListener implements ServletContextListener {

    // Tomcat启动时，先创建好20个Connection
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HashMap<Connection, Boolean> map = new HashMap<>();
        JdbcUtil jdbcUtil = new JdbcUtil();
        for (int i = 1; i <= 20; i++) {
            Connection connection = jdbcUtil.getCon();
            // true表示这条连接处于空闲状态，false表示连接处于被使用状态
            System.out.println("创建Connection" + i);
            map.put(connection, true);
        }
        // 为了在HTTP服务器运行期间，能一直使用这20个Connection，将Connect对象保存到全局作用域对象中
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("key1", map);
    }

    @Override
    @SuppressWarnings("all")
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        HashMap<Connection, Boolean> map = (HashMap) servletContext.getAttribute("key1");

        Set<Connection> connections = map.keySet();

        for (Connection connection : connections) {
            try {
                connection.close();
                System.out.println(connection + "被关闭");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
