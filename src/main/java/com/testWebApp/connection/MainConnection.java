package com.testWebApp.connection;

import com.testWebApp.model.User;
import com.testWebApp.repository.impl.UserDAOImpl;

public class MainConnection {
    public static void main(String[] args) {
        JDBConnection jdbConnection = new JDBConnection();
        UserDAOImpl userDAO = new UserDAOImpl(jdbConnection);
        System.out.println(userDAO.findUser("Kaufmannthe","12"));
    }
}
