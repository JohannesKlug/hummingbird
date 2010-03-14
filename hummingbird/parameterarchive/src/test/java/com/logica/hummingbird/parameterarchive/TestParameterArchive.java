package com.logica.hummingbird.parameterarchive;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestParameterArchive {

	Connection conn;
	
	@Before
	public void setUp() throws Exception {
	       Class.forName("org.h2.Driver");
	        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	        
	}
	
	@Test
	public void testConnection() {
		System.out.println(conn.toString());
	}
	
	@After
	public void tearDown() throws SQLException {
		conn.close();
	}
	


}
