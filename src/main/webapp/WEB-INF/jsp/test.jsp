<%--
  Created by IntelliJ IDEA.
  User: XieXing
  Date: 2018/12/26
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    System.out.println(basePath);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="http://983836259.blog.51cto.com/7311475/">
    <title>FilterDemo</title>
</head>
<body>
<%
    System.out.println("test.jsp is loading");
%>
<div align="center">
    This is test page
</div>
</body>
</html>