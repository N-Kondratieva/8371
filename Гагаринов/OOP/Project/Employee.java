package com.company;

public class Employee extends User {

    private String fio;
    private Position position;
    private int salary;
    private String email;
    private String phoneNumber;

    public Employee(int id,
                    String login,
                    String password,
                    Role role,
                    String fio,
                    Position position,
                    int salary,
                    String email,
                    String phoneNumber) {
        super(id, login, password, role);
        this.fio = fio;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
