<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h4>Login Page</h4>
<form action="shiro/login" method="POST">
    username: <input type="text" name="username"/>
    <br><br>
    password: <input type="password" name="password"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>