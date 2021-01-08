package com.example.Server;

import com.example.Server.models.Order;
import com.example.Server.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUser", value = "/users")
public class ServletUser extends HttpServlet {

    public static Database database = new Database();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/JSON");
        res.setCharacterEncoding("UTF-8");
        for (String el : database.getUsers()){
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
        User user = null;
        try {
            user = objectMapper.readValue(inputLine,User.class);
            database.saveUser(user);
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
        database.deleteUser(Integer.parseInt(inputLine),"users");
        res.getWriter().write("Пользователь удален");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
