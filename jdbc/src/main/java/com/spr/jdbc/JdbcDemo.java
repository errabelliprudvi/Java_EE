package com.spr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo 
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/testDb";
		String user = "root";
		String password = "Spr@6149";
		
		try 
		{
			 // 1?? Load MySQL JDBC Driver (Not needed for Java 8+)              
            Class.forName("com.mysql.cj.jdbc.Driver");                        

			// 2?? Establish Connection 
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to MySQL successfully!");
			
			// 3?? Create Statement 
			Statement stmt = con.createStatement();
			String query = "Select * from users";
			
			ResultSet rs = stmt.executeQuery(query);
			
			// 4?? Process Results  
			while(rs.next())
			{
				System.out.println("user_id : " + rs.getInt("user_id") + " Name : " + rs.getString("name") );
			}
			
			// 5?? close connection
			rs.close();
			stmt.close();
			con.close();
			
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
