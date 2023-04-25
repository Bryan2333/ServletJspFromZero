<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 向HttpSession中存放数据，则使用getSession(true) , 即getSession()
        // 从HttpSession中读取数据，则使用getSession(false)
        HttpSession session = request.getSession(false);
        PrintWriter writer = response.getWriter();
        if (session != null) {
            String user = (String) session.getAttribute("key1");
            writer.println("user = " + user);
        }
        writer.println("session = " + session);
    %>
</body>
</html>
