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
import java.util.Objects;


@WebServlet("/register")
public class CreateUserServlet extends HttpServlet {
    JDBConnection connector = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connector);

    public CreateUserServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String fullName = req.getParameter("full_name");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("psw");
        String passwordConfirm = req.getParameter("psw-repeat");

        if (!Objects.equals(password, passwordConfirm)) {
            resp.sendRedirect("/feature/reg_index.jsp");
            printWriter.write("Пароли не совпадают. Попробуйте снова.");
        }
        if (Objects.equals(fullName, "") || age == 0 || Objects.equals(login, "") || Objects.equals(password, "")) {
            resp.sendRedirect("/feature/reg_index.jsp");
            printWriter.write("Данные введены некорректно. Попробуйте снова.");
        }

        User user = new User(fullName,login,password,age);
        try {

            userDAO.create(user);
            resp.sendRedirect("/feature/succes_registration.jsp");
        } catch (Exception e) {
            printWriter.write("ERROR");
        }
    }
}
