<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1. Java脚本段

        1. <% Java代码 %>

        2. 可以编写Java代码，定义局部变量

    2. 声明脚本段

        1. 声明全局变量，如方法、类、代码块

        2. <%! Java代码 %>

    3. 输出脚本段

        1. 输出变量或字面量

        2. <%=数值 %>
--%>

<%-- 1. Java脚本段 --%>
<%
    // 定义局部变量
    String str = "Hello, JSP";
    // 输出到控制台
    System.out.println(str);
    // 输出全局变量
    System.out.println(num);

%>

<%-- 2. 声明脚本段--%>
<%!
    int num = 100;
%>

<%-- 3. 输出表达式 --%>
<%= str%>
</body>
</html>
