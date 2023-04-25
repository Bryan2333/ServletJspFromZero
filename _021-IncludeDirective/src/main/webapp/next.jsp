<%@ page import="java.io.PrintWriter" %>
<%@ page %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    next page <br/>

    <%
        PrintWriter writer = response.getWriter();
        writer.println(address);
        String userName = "bryan";

//        String address = "广东深圳";
    %>

</body>
</html>
