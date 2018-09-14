<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>List Page</title>
</head>
<body>
<h4>List Page</h4>
Welcome:<shiro:principal/>
<shiro:hasRole name="admin">
    <br><br>
    <a href="admin.jsp">Admin Page</a>
</shiro:hasRole>
<shiro:hasRole name="user">
    <br><br>
    <a href="user.jsp">User Page</a>
</shiro:hasRole>
<br><br>
<a href="shiro/testShiroAnnotation">Test ShiroAnnotation</a>
<br><br>
<a href="shiro/logout">Logout</a>
</body>
</html>