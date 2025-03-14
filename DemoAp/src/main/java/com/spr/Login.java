package com.spr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login  extends HttpServlet
{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String password = req.getParameter("password");

	String query = "INSERT into users (name, email, password_hash) Values(?, ?, ?)";

	try {
		Connection con = Jdbc.getConnection();
		PreparedStatement psmt = con.prepareStatement(query);

		psmt.setString(1, name);
		psmt.setString(2, email);
		psmt.setString(3, password);

		int rs = psmt.executeUpdate();

		System.out.println("Rows effected: " + rs);

		psmt.close();
		con.close();

	}
	catch (SQLException e) {

		e.printStackTrace();
	}
   }
}
