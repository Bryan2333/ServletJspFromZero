package com.bryan._004httpservresponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/*
 *   浏览器在接收到响应包后，如果发现响应头中存在 location 属性
 *   就会自动地通过地址栏向location指定的网站发送请求
 *
 */

@WebServlet(name = "FourServlet", value = "/four")
public class FourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String result = "https://www.baidu.com";

        // 通过响应对象，将地址赋给响应头中的location属性
        response.sendRedirect(result); // 响应头 location="https://www.baidu.com"


    }
}
