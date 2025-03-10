package com.spr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spr.Jdbc;
import com.spr.model.User;

public class UserDAO {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection con = Jdbc.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
