package com.bryan._008httpstatuscode;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Servlet302", value = "/servlet302")
public class Servlet302 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String address =  "https://www.baidu.com";

        response.sendRedirect(address);
    }
}
