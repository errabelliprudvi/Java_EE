package com.spr.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spr.Jdbc;
import com.spr.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();

        try (Connection con = Jdbc.getConnection();
             PreparedStatement psmt = con.prepareStatement("SELECT * FROM users");
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                users.add(new com.spr.model.User(rs.getString("name"), rs.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB_INF/views/users.jsp").forward(req, resp);
    }
}
