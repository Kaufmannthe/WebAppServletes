<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 18/06/2022
  Time: 04:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/feature/login" method="post">
    <label for="login"><b>Login</b></label>
    <input type="text" placeholder="Enter your Login" name="login" id="login" required>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
    <hr>
    <button type="submit" class="loginbtm">Login</button>
</form>
</body>
</html>
