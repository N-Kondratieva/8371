package com.example.Server;

import com.example.Server.models.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletOrder", value = "/orders")
public class ServletOrder extends HttpServlet {

    public static Database database = new Database();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/JSON");
        res.setCharacterEncoding("UTF-8");

        for (String el : database.getOrders()){
            res.getWriter().write(el);
            res.getWriter().write("*");
        }

        res.getWriter().flush();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String inputLine = req.getReader().readLine();
        if(inputLine != null){
            res.getWriter().write("Данные получены\n");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = null;
        try {
            order = objectMapper.readValue(inputLine,Order.class);
            database.saveOrder(order);
            res.getWriter().write("Данные записаны");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String inputLine = req.getReader().readLine();
        if(inputLine != null){
            res.getWriter().write("Данные получены\n");
        }
        database.deleteUser(Integer.parseInt(inputLine),"orders");
        res.getWriter().write("Пользователь удален");
    }
    public void destroy() {
        super.destroy();
    }
}