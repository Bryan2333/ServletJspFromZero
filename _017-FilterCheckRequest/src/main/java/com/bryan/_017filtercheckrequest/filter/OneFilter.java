package com.bryan._017filtercheckrequest.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "OneFilter", urlPatterns = "/mm.png")
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // 1. 通过拦截的请求对象获得请求包的参数信息，从而得到来访用户的年龄
        String age = servletRequest.getParameter("age");

        // 2. 根据年龄判断请求的合法性
        if (Integer.parseInt(age) < 70) {
            // 将拦截的请求对象和响应对象交还给Tomcat
            filterChain.doFilter(servletRequest, servletResponse); // 放行
        } else {
            // filter代替HTTP服务器拒绝本次请求
            servletResponse.setContentType("text/html;charset=utf-8");

            PrintWriter writer = servletResponse.getWriter();
            writer.println("<h2 style='color: red;'>珍爱生命</h2>");
        }
    }
}
