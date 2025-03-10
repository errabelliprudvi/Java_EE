package com.spr.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UpdateValuesTest {
	static UpdateValues uv;
	@BeforeAll
	static void run()
	{
		uv = new UpdateValues();
	}
	@Test
	void testUpdate() 
	{
		String query = "Update users set name = \"prudvi\" where user_id = 6";
		
		assertEquals(1, uv.update(query));
		
	}

}
