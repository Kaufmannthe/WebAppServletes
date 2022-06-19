package com.testWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private String userFullName;
    private String userLogin;
    private String userPassword;
    private int userID;
    private int userAge;


    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public User(String userFullName, String userLogin, String userPassword, int userAge) {
        this.userFullName = userFullName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userAge = userAge;
    }

    public User(String userFullName, String userLogin, int userAge) {
        this.userFullName = userFullName;
        this.userLogin = userLogin;
        this.userAge = userAge;
    }
}
