package com.company;

public class User
{
    private String userId;
    private String name;
    private String password;
    private String role;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userID) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
