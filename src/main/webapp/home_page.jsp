<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 18/06/2022
  Time: 03:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successes</title>
    <style>

        .btn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 15%;
            opacity: 0.9;
        }

        .btn:hover {
            opacity: 1;
        }


    </style>
</head>
<body>
<h1 style="text-align: center">You are logged into your account</h1>
<a href="profilePage.jsp">
    <button type="submit" class="btn">Profile</button>
</a>
<hr>
<a href="helloPage.jsp">
    <button type="submit" class="btn">Log out</button>
</a>
</body>
</html>
