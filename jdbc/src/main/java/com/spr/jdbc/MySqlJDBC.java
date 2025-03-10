package com.spr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlJDBC 
{
	private static String url = "jdbc:mysql://localhost:3306/testDb";
	private static String user = "root";
	private static String password = "Spr@6149";
	
	private static Connection con;
	
	public static Connection getConnection() 
	{
		try 
		{
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		
		return con;
		
	}

}
