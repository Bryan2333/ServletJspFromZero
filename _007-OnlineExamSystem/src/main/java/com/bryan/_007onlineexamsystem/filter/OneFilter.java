package com.bryan._007onlineexamsystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "OneFilter", urlPatterns = "/*")
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1. 通过请求对象获得URI
        String requestURI = request.getRequestURI();

        // 2. 如果本次请求的资源文件与登陆相关，则放行
        if (requestURI.contains("login") || "/myWeb/".equals(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 如果本次请求访问的是其他资源文件，则通过请求对象向Tomcat索要HttpSession对象
        HttpSession session = request.getSession(false);

        // 判断用户的合法性
        if (session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        servletRequest.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
    }
}
