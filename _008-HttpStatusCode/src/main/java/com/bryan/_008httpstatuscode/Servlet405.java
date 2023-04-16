package com.bryan._008httpstatuscode;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Servlet405", value = "/servlet405")
public class Servlet405 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        System.out.println("Servlet405 doPost method ran");
    }
}
