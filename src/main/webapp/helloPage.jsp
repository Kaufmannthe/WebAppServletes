<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 17/06/2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu</title>
    <style>
        body {
            background-image: url("/background.jpg");
        }

        .btn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 10px;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.8;
            border-radius: 30px;
        }

        .btn:hover {
            opacity: 1;
        }

        .buttons {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">Hello</h1>
<div class="buttons">

    <a href="/feature/reg_index.jsp">
        <button type="submit" class="btn">Sign up</button>
    </a>

    <a href="/feature/login_page.jsp">
        <button type="submit" class="btn">Login</button>
    </a>

</div>

</body>
</html>
