package com.spr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertValues 
{
	public static void main(String[] args)
	{
		String query = "Insert Into users ( name, email, password_hash) "
				+ "Values(?, ?, ?)";
		
		Connection con = MySqlJDBC.getConnection();
		
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Grosp");
			pstmt.setString(2, "email@gmailk.com");
			pstmt.setString(3, "AAA123");
			
			int r = pstmt.executeUpdate();
			System.out.println(r);
			
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
