package com.bryan._005httpservrequest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. 通过请求对象获得请求头中的所有的请求参数的名称
        //    将所有请求参数名保存到一个枚举对象中
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paraName = parameterNames.nextElement();

            String value = request.getParameter(paraName);

            System.out.println("请求参数名=" + paraName + " 值=" + value);
        }


    }
}
