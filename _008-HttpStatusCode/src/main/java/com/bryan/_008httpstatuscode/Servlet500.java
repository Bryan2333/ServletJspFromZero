package com.bryan._008httpstatuscode;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.HashMap;

@WebServlet(name = "Servlet500", value = "/servlet500")
@SuppressWarnings("all")
public class Servlet500 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int one = map.get(1);

        System.out.println("hello");
    }
}
