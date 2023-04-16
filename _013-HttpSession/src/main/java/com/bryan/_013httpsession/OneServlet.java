package com.bryan._013httpsession;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;

        // 1. 通过请求对象获得用户传递的参数，即商品名称
        goodsName = request.getParameter("goodsName");

        // 2. 通过请求对象向 Tomcat 申请用户的私人储物柜，即 HttpSession 对象
        HttpSession session = request.getSession();

        // 3. 将用户选购的商品放入储物柜中
        Integer goodsNum = (Integer) session.getAttribute("goodsName");

        if (goodsNum == null) {
            session.setAttribute(goodsName, 1);
        } else {
            session.setAttribute(goodsName, goodsNum + 1);
        }
    }
}
