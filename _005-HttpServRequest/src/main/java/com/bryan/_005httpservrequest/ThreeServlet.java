package com.bryan._005httpservrequest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.UnsupportedEncodingException;

/*
    问题

*       以 GET 方法发送中文参数值，可以得到正常的结果
*       以 GET 方法发送中文参数值，可以得到乱码
*
*   问题原因

        浏览器以 [GET] 方式发送请求，请求参数保存在 [请求头] 中，请求头中的二进制内容由Tomcat负责解码
        Tomcat9默认的解码方式是UTF-8,因此中文内容可以正常显示

        浏览器以 [POST] 方式发送请求，请求参数保存在 [请求体] 中，请求体中的二进制内容由[当前请求对象request]负责解码
        request对象默认采用 ISO-8859-1 字符集进行解码，而该字符集是东欧语系字符集，
        不支持中文，因此如果请求体中参数内容为中文，则无法解码只能得到乱码
*
    解决方法

        在 POST 的请求方式下，在读取请求体的内容之前，应告知请求对象使用UTF-8字符集对请求体内容进行解码
*/

@WebServlet(name = "ThreeServlet", value = "/three")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        // 通过请求对象读取 请求体 中的参数信息
        String userName = request.getParameter("userName");

        System.out.println("从请求体中得到参数值 " + userName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        // 使用UTF-8字符集进行解码
        request.setCharacterEncoding("utf-8");

        // 通过请求对象读取 请求头 中的参数信息
        String userName = request.getParameter("userName");

        System.out.println("从请求头中得到参数值 " + userName);
    }
}
