package com.testWebApp.controller;

import com.testWebApp.connection.JDBConnection;
import com.testWebApp.model.User;
import com.testWebApp.repository.impl.UserDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/registerUser")
public class CreateUserServlet extends HttpServlet {
    JDBConnection connector = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connector);

    public CreateUserServlet()  {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String fullName = req.getParameter("full_name");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("swd");
        User user = new User(fullName,login,password,age);

        try(Connection connection = connector.getConnection()) {
            userDAO.create(user);
            if(userDAO.create(user)){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration/testError.jsp");
                requestDispatcher.forward(req,resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
