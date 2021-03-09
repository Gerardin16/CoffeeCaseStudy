package com.groupthree.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionManagement {

	static private Connection connection;
	
	public static Connection getConnection(String url,String username,String password)throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url,username,password); 
		return connection;
		
	}
	
	
}
