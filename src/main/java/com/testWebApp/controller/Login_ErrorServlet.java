package com.testWebApp.controller;

import com.testWebApp.connection.JDBConnection;
import com.testWebApp.repository.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_error")
public class Login_ErrorServlet extends HttpServlet {
    JDBConnection connection = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connection);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("psw");

        if (userDAO.findUser(login, password)) {
            resp.sendRedirect("/feature/home_page.jsp");

        } else {
            resp.sendRedirect("/feature/login_page_error.jsp");
        }
    }
}
