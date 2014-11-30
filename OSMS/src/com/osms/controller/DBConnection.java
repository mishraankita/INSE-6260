package com.osms.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	
	public static Connection  getConnection() throws SQLException{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		return con;
	}

}
