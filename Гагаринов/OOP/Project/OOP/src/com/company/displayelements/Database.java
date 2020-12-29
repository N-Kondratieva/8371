package com.company.displayelements;

import com.company.Order;
import com.company.User;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection dbConnection;
    String username = "root";
    String password = "Root1234";

    public Database() {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/oop?serverTimezone=Europe/Moscow";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(url, this.username, this.password);
        return this.dbConnection;
    }

    public void saveOrder(String service,
                          String employee,
                          String customerfio,
                          String customeremail,
                          int duration,
                          int cost,
                          long indate,
                          long approximatedate,
                          boolean status,
                          String inputmaterial) {
        String insert = "INSERT INTO orders (service," +
                " employee, " +
                "customerfio, " +
                "customeremail," +
                "duration," +
                "cost," +
                "indate," +
                "approximatedate," +
                "status," +
                "inputmaterial)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?) ";

        try {
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, service);
            prSt.setString(2, employee);
            prSt.setString(3, customerfio);
            prSt.setString(4, customeremail);
            prSt.setInt(5, duration);
            prSt.setInt(6, cost);
            prSt.setLong(7, indate);
            prSt.setLong(8, approximatedate);
            prSt.setBoolean(9, status);
            prSt.setString(10, inputmaterial);

            prSt.executeUpdate();

        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }

    }


    public ArrayList<Order> getOrders() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM oop.orders";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            while (resultSet.next()) {
                Order buffOrder = new Order(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getLong(8),
                        resultSet.getLong(9),
                        resultSet.getBoolean(10),
                        resultSet.getString(11));
                orders.add(buffOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<User> getUsers(){
        ResultSet resultSet = null;
        String select = "   SELECT idusers, login, password, FIO , role FROM users inner join roles on idrole = idroles";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<User> users = new ArrayList<User>();
        try {
            

            while (resultSet.next()) {

                User buffUser = new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));

                users.add(buffUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUser(String login,String password,String fio,String role){
        ResultSet resultSet = null;
        String getIdRole = "SELECT idroles FROM roles WHERE role = '"+ role +"'" ;
        String insert = "INSERT INTO users(login, password, idrole, FIO) VALUES(?,?,?,?)";
        try {
            PreparedStatement prStForId = this.getDbConnection().prepareStatement(getIdRole);
            resultSet = prStForId.executeQuery();
            int roleId = 0;
            while (resultSet.next()){
                roleId = resultSet.getInt(1);
            }
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, login);
            prSt.setString(2, password);
            prSt.setInt(3, roleId);
            prSt.setString(4, fio);

            prSt.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }
    }
}

// Запрос на получение ролей SELECT role FROM users inner join roles on idrole = idroles
