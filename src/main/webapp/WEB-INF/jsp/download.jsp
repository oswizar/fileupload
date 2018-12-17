<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>
<a href="download?fileName=<%=request.getAttribute("fileName")%>">
    <%=request.getAttribute("fileName")%>
</a>
</body>
</html>
