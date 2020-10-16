package com.company;

public class User {
    private int id;
    private String login;
    private String password;
    private Role role;

    public User(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
