package com.bryan._004httpservresponse;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String result = "Hello World"; // 执行结果

        // 1. 通过响应对象获取输出流
        PrintWriter writer = response.getWriter();

        // 2. 通过输出流将执行结果以二进制形式写入响应体
        writer.write(result);

    }
}
