package com.kodilla.tictactoe;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String login;
    private String password;
    private String userName;
    private String userLastName;
    private int howManyWins ;

    public User(int userId, String login, String password, String userName, String userLastName) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.userLastName = userLastName;
        this.howManyWins = 0;
    }

    @Override
    public String toString() {
        return ""+userId +'|'+login + '|' + password + '|' + userName + '|' + userLastName + '|' + howManyWins +"";
          }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getHowManyWins() {
        return howManyWins;
    }

    public void setHowManyWins(int howManyWins) {
        this.howManyWins = howManyWins;
    }
}
