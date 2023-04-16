package com.bryan._003servletlifecycle;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

/*
*   一般情况下 Servlet接口实现类的实例对象，只能有http服务器创建，开发者不能手动创建实例对象
*
*   在默认情况下，http服务器接收到对于当前 Servlet 接口实现类的第一次请求时，会自动创建该实现类的实例对象
*
*   在手动配置的情况下，可以在 web.xml 文件中添加属性 要求http服务器启动时自动创建某个servlet接口实现类的对象实例
*
*   <servlet>
        <servlet-name>TwoServlet</servlet-name>
        <servlet-class>com.bryan._03servletlifecycle.TwoServlet</servlet-class>
        <load-on-startup>1</load-on-startup>  <!-- 填写一个大于零的整数 -->
    </servlet>
*
*/

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    public OneServlet() {
        System.out.println("OneServlet实例对象被创建");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("OneServlet is running...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void destroy() {
        System.out.println("OneServlet实例对象被销毁了");
    }
}
