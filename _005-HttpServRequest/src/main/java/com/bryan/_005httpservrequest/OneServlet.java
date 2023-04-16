package com.bryan._005httpservrequest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        // 1. 通过请求对象，读取请求行中的 url 信息
        String requestURL = req.getRequestURL().toString();

        // 2. 通过请求对象，读取请求行中的 method 信息
        String method = req.getMethod();

        // 3. 通过请求对象，读取请求行中的 uri 信息
        // uri : 资源文件精准定位地址
        // 实际上是从 URL 中截取的一个字符串 "/网站名/资源文件名"
        // URI用于让http服务器对被访问的资源进行定位
        String requestURI = req.getRequestURI();

        System.out.println("URL " + requestURL);
        System.out.println("Method " + method);
        System.out.println("URI " + requestURI);
    }
}