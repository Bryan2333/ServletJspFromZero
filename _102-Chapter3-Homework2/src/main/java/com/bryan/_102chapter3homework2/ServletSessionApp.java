package com.bryan._102chapter3homework2;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ServletSessionApp", value = "/ServletSessionApp")
public class ServletSessionApp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName; // 用户名
        String password; // 密码
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        userName = request.getParameter("userName"); // 获得用户密码
        password = request.getParameter("password"); // 获得用户口令


        // 如果不是目标用户，提示登陆失败
        if (!"Bryan".equals(userName) || !"1234".equals(password)) {
            writer.println("<h1 style='text-align: center;'>登陆失败</h1>");
        }

        if (userName != null && !userName.isEmpty()) {
            session.setAttribute("userName", userName);
        }

        long CreationTimeStamp = session.getCreationTime(); // 获取 session 创建时间
        long LastVisitTimeStamp = session.getLastAccessedTime(); // 获取最后一次访问时间
        Instant CreationInstance = Instant.ofEpochMilli(CreationTimeStamp);
        Instant LastVisitInstance = Instant.ofEpochMilli(LastVisitTimeStamp);


        LocalDateTime CreationDateTime = LocalDateTime.ofInstant(CreationInstance, ZoneId.of("+08:00"));
        LocalDateTime LastVisitDateTime = LocalDateTime.ofInstant(LastVisitInstance, ZoneId.of("+08:00"));

        // 最后格式化转换后的 LocalDateTime 实例
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        session.setAttribute("id", session.getId());
        session.setAttribute("CreateTime", dtf.format(CreationDateTime));
        session.setAttribute("LastVisitTime", dtf.format(LastVisitDateTime));
        session.setAttribute("visitCount", session.getAttribute("visitCount"));

        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 0;
        }
        visitCount++;
        session.setAttribute("visitCount", visitCount);

        String information = """
                <html>
                <H2>Welcome to My Website</H2>
                <H3>Session information</H3>
                <table border="1">
                    <tr>
                        <th>Session Info</th>
                        <th>value</th>
                    </tr>
                    <tr>
                        <td>id</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>Creation Time</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>Time of Last Access</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>User ID</td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td>Number of visits</td>
                        <td>%s</td>
                    </tr>
                </table>
                </body>
                                             
                </html>
                             """.formatted(session.getId(),
                session.getAttribute("CreateTime"),
                session.getAttribute("LastVisitTime"),
                session.getAttribute("userName"),
                session.getAttribute("visitCount"));

        writer.println(information);
    }
}
