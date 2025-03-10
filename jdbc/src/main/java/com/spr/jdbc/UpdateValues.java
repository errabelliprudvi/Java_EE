package com.spr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateValues 
{
  public int update(String query)
  {
	  int r = 0;
	  Connection con = MySqlJDBC.getConnection();
	  try
	  {
		PreparedStatement pstmt = con.prepareStatement(query);
		r = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  
	  return r;
	  
}
}
