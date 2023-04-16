package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	final static String DB_url = "jdbc:mysql://localhost/project";
	final static String USER = "root";
	final static String PASS = "12345";
	
	public static Connection createConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DB_url, USER, PASS);
		
	}

}
