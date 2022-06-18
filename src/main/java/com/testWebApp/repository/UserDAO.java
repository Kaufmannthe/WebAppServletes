package com.testWebApp.repository;

import com.testWebApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends BaseDAO <User>{
    Optional<User> findByLogin (String name);
    boolean findUser (String login, String password);
}
