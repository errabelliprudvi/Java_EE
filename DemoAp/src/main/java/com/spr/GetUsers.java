package com.spr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getUsers")
public class GetUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = "SELECT * FROM users";
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (Connection con = Jdbc.getConnection();
             PreparedStatement psmt = con.prepareStatement(query);
             ResultSet rs = psmt.executeQuery();
             PrintWriter out = resp.getWriter()) {

            out.append("[");
            boolean first = true;
            while (rs.next()) {
                if (!first) {
					out.append(",");
				}
                first = false;
                out.append("{\"name\":\"").append(rs.getString("name")).append("\",")
                   .append("\"email\":\"").append(rs.getString("email")).append("\"}");
            }
            out.append("]");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
