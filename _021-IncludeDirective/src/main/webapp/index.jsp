<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>

index page before <br>

<%
    String address = "海南海口";
%>

<%-- 静态联编
1. 两个文件之间可以共享同一个变量
2. 如果不共享变量，则不能定义同名的变量
3. include指令会在Jsp翻译引擎翻译之前执行，因此只有一个文件
--%>
<%@ include file="/next.jsp" %>

index page after <br>

<%=userName %> <br>
</body>
</html>