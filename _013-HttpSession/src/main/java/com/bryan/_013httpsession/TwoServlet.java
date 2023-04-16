package com.bryan._013httpsession;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "TwoServlet", value = "/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 通过请求对象向 Tomcat 服务器申请当前用户在服务端的私人储物柜 HttpSession
        HttpSession session = request.getSession();


        // 2. 将 HttpSession 中的所有 keys 取出来，存放到一个枚举对象中
        Enumeration<String> goodsNames = session.getAttributeNames();

        while (goodsNames.hasMoreElements()) {
            String goodsName = goodsNames.nextElement();
            int goodsNum = (int) session.getAttribute(goodsName);
            System.out.printf("商品名称: %s, 商品数量: %d\n", goodsName, goodsNum);
        }
    }
}
