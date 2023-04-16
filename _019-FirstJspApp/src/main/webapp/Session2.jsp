<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: bryan
  Date: 2023/4/16
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String test = (String) session.getAttribute("key1");
%>
user = <%=test %>
</body>
</html>
