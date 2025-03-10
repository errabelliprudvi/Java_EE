package com.spr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcStatements 
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/testDb";
		String user = "root";
		String pwd = "Spr@6149";
		
		String query = "Select * from users where user_id = ?";
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 6);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("user_id") +" "+ rs.getString("name"));
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
