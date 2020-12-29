package com.company;

public class User {
    private int id;
    private String login;
    private String password;
    private String fio;
    private String role;

    public User(int id, String login, String password,String fio ,String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {
        return fio;
    }

    public String getRole() {
        return role;
    }
}
