<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
    1. Page指令用于设置当前页面的相关信息

    2. 属性

      1. pageEncoding: 设置页面的编码

      2. contentType: 设置页面的类型和编码，一般不和 pageEncoding 同时使用

      3. import: 用于导入类

      4. errorPage: 当页面发生异常时，跳转到对应的页面

      5. isErrorPage: 该页面对应的Servlet会有一个Exception对象，可以输出错误信息
--%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String dateFormatted = sdf.format(date);
%>
now date = <%=dateFormatted%>
</body>
</html>