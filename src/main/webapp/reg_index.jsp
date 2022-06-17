<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 17/06/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/register" method="post">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="full_name"><b>Full Name</b></label>
        <input type="text" placeholder="Enter your Full Name" name="full_name" id="full_name" required>

        <label for="age"><b>Age</b></label>
        <input type="number" placeholder="Enter your Age" name="age" id=age required>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter your Login" name="login" id="login" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
        <hr>
        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
        <hr>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerbtn">Register</button>
    </form>
</div>
</body>
</html>
