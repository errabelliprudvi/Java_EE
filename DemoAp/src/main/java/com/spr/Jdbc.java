package com.spr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc
{
	private static String url = "jdbc:mysql://localhost:3306/testDb";
	private static String user = "root";
	private static String password = "Spr@6149";






	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user,password);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return con;
	}
}
