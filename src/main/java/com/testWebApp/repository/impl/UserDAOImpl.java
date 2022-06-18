package com.testWebApp.repository.impl;

import com.testWebApp.connection.JDBConnection;
import com.testWebApp.model.User;
import com.testWebApp.repository.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDAOImpl implements UserDAO {
    private static final String CREATE_USER = "INSERT INTO users (user_full_name,user_login,user_password,user_age) VALUES (?,?,?,?)";
    private static final String USER_UPDATE = "UPDATE users SET user_login = ?, user_password = ?, user_age = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ? ";
    private static final String FIND_ALL_USERS = "SELECT * FROM users";
    private static final String FIND_BY_LOGIN = "SELECT * FROM users WHERE user_login = ?";
    private static final String DELETE_BY_ID ="DELETE FROM users WHERE id = ?";
    private static final String FIND_USER = "SELECT * FROM users WHERE user_login = ? AND user_password = ?";

    private JDBConnection connector;
    public UserDAOImpl(JDBConnection connector){
        this.connector = connector;
    }

    @Override
    public List<User> findAll() {
        List<User> personList = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS);

            while (resultSet.next()) {
                User person = new User();
                person.setUserID(resultSet.getInt("id"));
                person.setUserFullName(resultSet.getString("user_full_name"));
                person.setUserLogin(resultSet.getString("user_login"));
                person.setUserAge(resultSet.getInt("user_age"));
                personList.add(person);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Optional<User> findByID(int id) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUserID(resultSet.getInt("id"));
                user.setUserFullName(resultSet.getString("user_full_name"));
                user.setUserLogin(resultSet.getString("user_login"));
                user.setUserAge(resultSet.getInt("user_age"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.of(user);
    }

    @Override
    public boolean create(User entity) {
        try(Connection connection = connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1,entity.getUserFullName());
            statement.setString(2,entity.getUserLogin());
            statement.setString(3,entity.getUserPassword());
            statement.setInt(4,entity.getUserAge());

            return statement.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }   return false;
    }

    @Override
    public boolean update(User entity) {
        try(Connection connection = connector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(USER_UPDATE)){
            preparedStatement.setString(1,entity.getUserLogin());
            preparedStatement.setString(2,entity.getUserPassword());
            preparedStatement.setInt(3,entity.getUserAge());
            preparedStatement.setInt(4,entity.getUserID());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public boolean deleteByID(int id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            System.out.print("Результат удаления пользователя: " );
            return preparedStatement.executeUpdate() == 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }return false;
    }

    @Override
    public Optional<User> findByLogin(String name) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setUserID(resultSet.getInt("id"));
                user.setUserFullName(resultSet.getString("user_full_name"));
                user.setUserLogin(resultSet.getString("user_login"));
                user.setUserAge(resultSet.getInt("user_age"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.of(user);
    }

    @Override
    public boolean findUser(String login, String password) {
        try(Connection connection = connector.getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_USER)) {
            ps.setString(1,login);
            ps.setString(2,password);

            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
