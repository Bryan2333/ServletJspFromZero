package com.bryan._004httpservresponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
*   问题描述：
*
*   浏览器接收到响应结果后将 <br> 当成文本内容显示在浏览器中 并没有将 <br> 当成HTML标签进行解析
*
*   问题原因:
*
*   浏览器接收到响应包后，根据其中的 content-type 属性的值对二进制内容进行编译
*   而 content-type 默认值为 text, 因此浏览器会用 文本编译器 对二进制内容进行解析
*
*   解决方法 :
*
*   在得到输出流之前，设置响应头的 content-type 属性，使得浏览器用正确的编译器编译二进制文本
*
*/

@WebServlet(name = "ThreeServlet", value = "/three")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String result = "Java<br>MySql<br>HTML<br>MyBatis<br>";
        String result2 = "红烧排骨<br>糖醋里脊";

        response.setContentType("text/html;charset=UTF-8"); // 设置响应头中的 content-type 属性值

        PrintWriter writer = response.getWriter(); // 向 Tomcat 索要输出流

        writer.print(result);
        writer.print(result2);
    }
}
