package com.bryan._007onlineexamsystem.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.HashMap;
import java.util.Set;

public class JdbcUtil {

    final String URL = "jdbc:mariadb://localhost:3306/ServletFromZero";
    final String USERNAME = "bryan";
    final String PASSWORD = "password";
    PreparedStatement ps = null;
    Connection con = null;

    //将jar包中driver实现类加载到JVM中
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public JdbcUtil() {}

    // 重载close方法
    @SuppressWarnings("all")
    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ServletContext servletContext = request.getServletContext();
        HashMap<Connection, Boolean> map =  (HashMap<Connection, Boolean>) servletContext.getAttribute("key1");
        map.put(con, true);

    }

    // 通过全局作用域对象得到Connection
    @SuppressWarnings("all")
    public Connection getCon(HttpServletRequest request) {
        // 通过 [请求对象] 获得 [全局作用域对象]
        ServletContext servletContext = request.getServletContext();

        // 通过 [全局作用域对象] 获得 [保存Connection的Map对象]
        HashMap<Connection, Boolean> map = (HashMap<Connection, Boolean>) servletContext.getAttribute("key1");

        // 从Map对象中获得空闲的Connection
        Set<Connection> connections = map.keySet();

        for (Connection connection : connections) {
            Boolean idle = map.get(connection);
            con = connection;
            if (idle) {
                map.put(connection, false);
                break;
            }
        }
        return con;
    }

    // 重载createStatement方法
    public PreparedStatement createStatement(String sql, HttpServletRequest request) {

        try {
            ps = getCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //封装连接通道创建细节
    public Connection getCon() {

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //封装交通工具创建细节
    public PreparedStatement createStatement(String sql) {

        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    // ps与con销毁细节 insert,update,delete
    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //select ps,con,rs
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
