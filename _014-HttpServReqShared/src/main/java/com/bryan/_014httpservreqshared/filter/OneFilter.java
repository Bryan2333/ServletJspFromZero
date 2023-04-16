package com.bryan._014httpservreqshared.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "OneFilter", urlPatterns = "/*")
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // 拦截请求对象，使用UTF-8对请求体中的参数信息进行重新编码
        request.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }
}
