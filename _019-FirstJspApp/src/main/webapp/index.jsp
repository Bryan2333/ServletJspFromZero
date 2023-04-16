<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%--
    1. Jsp本质上是一个Servlet

    2. 注释

        1. 显示注释

            1. 能在客户端看到的注释，HTML风格 <!-- -->

        2. 隐式注释

            1. 不能在客户端看到的注释, 如本标签

                1. 本标签

                2. Java注释，只能用在Java代码块中
--%>
</body>
</html>