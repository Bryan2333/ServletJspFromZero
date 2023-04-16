package com.bryan._004httpservresponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
*   write 方法可以将 字符 字符串 ASCII码 写入响应体
*
*   结局方法使用 print 方法
*
*/

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int account = 50; // 执行结果

        PrintWriter writer = response.getWriter();

        writer.print(account);
    }
}
