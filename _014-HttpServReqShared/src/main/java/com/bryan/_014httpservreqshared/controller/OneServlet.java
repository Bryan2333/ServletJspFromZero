package com.bryan._014httpservreqshared.controller;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "OneServlet", value = "/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("userName");

        System.out.println(userName);
    }
}
