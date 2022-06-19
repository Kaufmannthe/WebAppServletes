package com.testWebApp.controller;

import com.testWebApp.connection.JDBConnection;
import com.testWebApp.model.User;
import com.testWebApp.repository.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    JDBConnection connector = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connector);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<html>");
        printWriter.write("h1 style='text-align: center'>Welcome to your profile11</h1");
        printWriter.write("</html>");
        String fullName = req.getParameter("full_name");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String passwordConfirm = req.getParameter("psw-repeat");
    }
}
