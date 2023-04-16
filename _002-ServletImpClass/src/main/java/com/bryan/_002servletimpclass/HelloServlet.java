package com.bryan._002servletimpclass;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/*
*   抽象类可以降低 接口实现类 实现接口 的 难度
*
*   HelloServlet -----> (abstract)HttpServlet -------> (abstract)GenericServlet
*
*                                                                init
*                                                                destroy
*                                                                getServerInfo
*                                                                getServerConfig
*
*
*   Servlet接口实现类开发方法
*
*   1. 创建一个Java类继承HttpServlet类，使之成为Servlet接口的实现类
*   2. 重写父类的两个方法 doGet或者doPost
*   3. 将Servlet接口实现类的相关信息注册到Tomcat中
*
*   注册信息:
*
*   <servlet>
        <!-- 声明一个变量存储 servlet 接口实现类类路径 -->
        <servlet-name>HelloServlet</servlet-name>
        <!-- 声明servlet接口实现类类路径 -->
        <servlet-class>com.bryan._02servletimpclass.HelloServlet</servlet-class>
    </servlet>

    <!--  为了降低用户访问servlet接口实现类的难度,需要设置请求别名  -->
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <!-- 设置简短的请求别名 需要以 / 开头 -->
        <url-pattern>/firstServlet</url-pattern>
    </servlet-mapping>
*
*   现在浏览器向Tomcat索要HelloServet地址 http://localhost:8080/myWeb/firstServlet
*
*   通过父类决定在什么情况下调用子类的方法 ------- 模板设计模式
*
*
*/

@WebServlet(name = "HelloServlet", urlPatterns = "/one")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HelloServlet针对浏览器发出Get请求方式进行处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        System.out.println("HelloServlet针对浏览器发出Post请求方式进行处理");
    }
}