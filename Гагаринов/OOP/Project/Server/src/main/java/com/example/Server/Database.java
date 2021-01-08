package com.example.Server;


import com.example.Server.models.Order;
import com.example.Server.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Connection dbConnection;
    private static String username = "root";
    private static String password = "Root1234";

    public Database() {
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/oop?serverTimezone=Europe/Moscow";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(url, this.username, this.password);
        return this.dbConnection;
    }
    public void saveOrder(Order order) {
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
            prSt.setString(1, order.getServiceId());
            prSt.setString(2, order.getEmployeeId());
            prSt.setString(3, order.getCustomerFIO());
            prSt.setString(4, order.getCustomerEmail());
            prSt.setInt(5, order.getDurationMaterial());
            prSt.setInt(6, order.getCost());
            prSt.setString(7, order.getInDate());
            prSt.setString(8, order.getApproximateDate());
            prSt.setBoolean(9, order.isStatus());
            prSt.setString(10, order.getInputMaterial());

            prSt.executeUpdate();

        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }

    }
    public ArrayList<String> getOrders() {

        String select = "SELECT * FROM oop.orders";
        ResultSet resultSet = getResultSetForExecuteQuery(select);
        ArrayList<String> orders = new ArrayList<String>();
        try {
            while (resultSet.next()) {
                Order buffOrder = new Order(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getBoolean(10),
                        resultSet.getString(11));
                String orderJSON = new ObjectMapper().writeValueAsString(buffOrder);
                orders.add(orderJSON);
            }
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public ArrayList<String> getUsers(){

        String select = "   SELECT idusers, login, password, FIO , role FROM users inner join roles on idrole = idroles";
        ResultSet resultSet = getResultSetForExecuteQuery(select);
        ArrayList<String> users = new ArrayList<String>();
        try {


            while (resultSet.next()) {

                User buffUser = new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                String usersJSON = new ObjectMapper().writeValueAsString(buffUser);
                users.add(usersJSON);
            }
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUser(User user){
        ResultSet resultSet = null;
        String getIdRole = "SELECT idroles FROM roles WHERE role = '"+ user.getRole() +"'" ;
        String insert = "INSERT INTO users(login, password, idrole, FIO) VALUES(?,?,?,?)";
        try {
            PreparedStatement prStForId = this.getDbConnection().prepareStatement(getIdRole);
            resultSet = prStForId.executeQuery();
            int roleId = 0;
            while (resultSet.next()){
                roleId = resultSet.getInt(1);
            }
            PreparedStatement prSt = this.getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setInt(3, roleId);
            prSt.setString(4,user.getFio());

            prSt.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }
    }
    public void deleteUser(int id,String table){

        String delete = "DELETE FROM `oop`.`"+table+"` WHERE (`id"+table+"` = '"+id +"')";
        ResultSet resultSet = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSetForExecuteQuery(String SQLRequest){
        ResultSet resultSet = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(SQLRequest);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
