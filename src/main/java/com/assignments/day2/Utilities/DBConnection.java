package com.assignments.day2.Utilities;

import java.sql.*;

public class DBConnection {
	
	public static Connection provideConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.getMessage();
		}
		
		//mySql connection url
		String url = "jdbc:mysql://localhost:3306/db1";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, "root", "jatin");
		} catch (SQLException error) {
			System.out.println("Connection Failed!");
			error.printStackTrace();
		}
		
		return conn;
	}
}
